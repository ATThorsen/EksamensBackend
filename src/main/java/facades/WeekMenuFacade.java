/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.WeekMenuDTO;
import dtos.addRecipeDTO;
import entities.Recipe;
import entities.WeekMenu;
import errorhandling.NotFoundException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author Aske
 */
public class WeekMenuFacade {
    
       private static WeekMenuFacade instance;
    private static EntityManagerFactory emf;
    

    public static WeekMenuFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new WeekMenuFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }


        public WeekMenuDTO create(int weekNo, int weekYear) throws NotFoundException {
         EntityManager em = emf.createEntityManager();
        WeekMenu WeekMenu = new WeekMenu(weekNo, weekYear);
        try {
            em.getTransaction().begin();
            em.persist(WeekMenu);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        WeekMenuDTO rMenu = new WeekMenuDTO(WeekMenu);
        return rMenu;
    }

    public addRecipeDTO addRecipeToWeek(long recipeID, long weekID) {
        EntityManager em = emf.createEntityManager();
        System.out.println(recipeID + weekID);
        try {
            em.getTransaction().begin();
            WeekMenu find = em.find(WeekMenu.class, weekID);
            Recipe r = em.find(Recipe.class, recipeID);
            System.out.println(find.getId());
            System.out.println(r.getId());
            find.addRecipeToWeekMenu(r);
            em.persist(find);
        em.getTransaction().commit();
      } finally {
            em.close();
        }
        return new addRecipeDTO(recipeID, weekID);
    
    }
}