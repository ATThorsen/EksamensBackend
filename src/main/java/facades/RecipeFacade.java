/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RecepiesDTO;
import dtos.RecipeDTO;
import entities.Ingeriedents;
import entities.Recipe;
import errorhandling.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TemporalType;
import javax.persistence.TypedQuery;

public class RecipeFacade {

    private static RecipeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RecipeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    
      public RecepiesDTO getAllRecipe(){
            EntityManager em = getEntityManager();
        try{
            
             List<RecipeDTO> rDTO = new ArrayList();
            TypedQuery<Recipe> query = em.createQuery("SELECT r from Recipe r", Recipe.class);
            for(Recipe r : query.getResultList()){
                Recipe recipe = new Recipe(r.getDish(), r.getDirections(), r.getPreparationTime());
              RecipeDTO recipeDTO = new RecipeDTO(recipe);
                
                 rDTO.add(recipeDTO);
               
            }
            
            return new RecepiesDTO(rDTO);
        }finally{
            em.close();
        }
    }
      
          public RecipeDTO getRecipe(int id) throws NotFoundException{
        EntityManager em = emf.createEntityManager();
        try{
            Recipe r = em.find(Recipe.class, (long)id);
            if(r  == null){
                throw new NotFoundException("No Recipe found with that ID");
            }
            RecipeDTO result = new RecipeDTO(r);
//            List<Ingeriedents> ingredients =  em.createQuery("SELECT  i FROM Ingeriedents i WHERE Recipe =" + r.getId()).getResultList();
//           
//                result.setIngeriedents(ingredients);
//           
            return result;
            
        }finally{
            em.close();
        }
    }

    public RecipeDTO addRecipe(String directions, String dish, String preparationTime) {
              Recipe r = new Recipe(dish, preparationTime, directions);
        
        EntityManager em = emf.createEntityManager();
        try{
            em.getTransaction().begin();
            em.persist(r);
            em.getTransaction().commit();
            RecipeDTO rdto = new RecipeDTO(r.getDish(), r.getPreparationTime(), r.getDirections());
            return rdto;
        }finally{
            em.close();
        }
    }
      
      
}
