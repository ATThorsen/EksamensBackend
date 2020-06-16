/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Recipe;
import java.util.ArrayList;
import java.util.List;


public class RecepiesDTO {
    
      List<RecipeDTO> all = new ArrayList<>();
      List<Recipe> allList;
         
    public RecepiesDTO(List<RecipeDTO> recipeList) {
         for (RecipeDTO r : recipeList){
             all.add(r);
             
         }
       
    }
    
    
}
