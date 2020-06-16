package dtos;


import entities.Ingeriedents;
import entities.Recipe;
import java.util.ArrayList;
import java.util.List;




public class RecipeDTO {
    
    
    private String dish;
    private String preparationTime;
    private String directions;
    private List<Ingeriedents> ingeriedents;  

    public RecipeDTO(Recipe recipe) {
        this.dish = recipe.getDish();
        this.preparationTime = recipe.getPreparationTime();
        this.directions = recipe.getDirections();
    }
    
    public RecipeDTO(String dish, String preparationTime, String directions) {
        this.dish = dish;
        this.preparationTime = preparationTime;
        this.directions = directions;
    }

    public RecipeDTO() {
    }
    
      public RecipeDTO(Recipe recipe, List<Ingeriedents> miDTO) {
        this.dish = recipe.getDish();
        this.preparationTime = recipe.getPreparationTime();
        this.directions = recipe.getDirections();
        for (Ingeriedents r : miDTO){
             ingeriedents.add(r);
     }
      }

    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public String getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(String preparationTime) {
        this.preparationTime = preparationTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public List<Ingeriedents> getIngeriedents() {
        return ingeriedents;
    }

    public void setIngeriedents(List<Ingeriedents> ingeriedents) {
        this.ingeriedents = ingeriedents;
    }
    
    
}
