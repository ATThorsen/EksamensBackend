
package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "Recipe.deleteAllRows", query = "DELETE from Recipe")
public class Recipe {
    

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dish;
    private String preparationTime;
    private String directions;
    
    @OneToMany (mappedBy ="recipe", cascade = CascadeType.ALL)
    private List<Ingeriedents> ingeriedents = new ArrayList<>();     

    @ManyToMany(cascade = {CascadeType.ALL})
    private List<WeekMenu> weekMenu = new ArrayList(); 

    public Recipe(String dish, String preparationTime, String directions) {
        this.dish = dish;
        this.preparationTime = preparationTime;
        this.directions = directions;
    }

    public List<Ingeriedents> getIngeriedents() {
        return ingeriedents;
    }

    public void setIngeriedents(List<Ingeriedents> ingeriedents) {
        this.ingeriedents = ingeriedents;
    }
    
    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        this.dish = dish;
    }

    public List<WeekMenu> getWeekMenu() {
        return weekMenu;
    }

    public void setWeekMenu(List<WeekMenu> weekMenu) {
        this.weekMenu = weekMenu;
    }

    
    public Recipe() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    
   public void addIngriedentsToRecipe (Ingeriedents ingeriedents) {
        if(!this.ingeriedents.contains(ingeriedents)) {
            ingeriedents.setRecipe(this);
            this.ingeriedents.add(ingeriedents); 
        }
        if (!ingeriedents.getRecipe().equals(this)) {
            ingeriedents.setRecipe(this); 
       }
    }
    
}