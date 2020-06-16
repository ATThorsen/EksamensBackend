/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author Aske
 */
public class addRecipeDTO {
    
    long weekID;
    long RecipeID;

    public addRecipeDTO(long weekID, long RecipeID) {
        this.weekID = weekID;
        this.RecipeID = RecipeID;
    }

    public long getWeekID() {
        return weekID;
    }

    public void setWeekID(long weekID) {
        this.weekID = weekID;
    }

    public long getRecipeID() {
        return RecipeID;
    }

    public void setRecipeID(long RecipeID) {
        this.RecipeID = RecipeID;
    }
    
    
    
}
