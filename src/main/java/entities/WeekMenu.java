/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dtos.WeekMenuDTO;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "WeekMenu.deleteAllRows", query = "DELETE from WeekMenu")
public class WeekMenu {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int weekNo;
    private int year;
    @ManyToMany(mappedBy="weekMenu", cascade = {CascadeType.ALL})
    private List<Recipe> recipes = new ArrayList();

    public WeekMenu() {
    }

    public WeekMenu(WeekMenuDTO WMDTO) {
        this.weekNo = WMDTO.getWeekNo();
        this.year = WMDTO.getYear();
    }

    public WeekMenu(int weekNo, int year) {
        this.weekNo = weekNo;
        this.year = year;
    }

    
    
    public WeekMenu(Long id, int weekNo, int year) {
        this.id = id;
        this.weekNo = weekNo;
        this.year = year;
    }

        public WeekMenu(Long id, int weekNo, int year, List<Recipe> recipes) {
        this.id = id;
        this.weekNo = weekNo;
        this.year = year;
        this.recipes = recipes;
    }

    
    
    
        public void addRecipeToWeekMenu (Recipe recipe) {
           if(!this.recipes.contains(recipe)) {
            this.recipes.add(recipe); 
        }
        if (!recipe.getWeekMenu().contains(this)) {
            recipe.getWeekMenu().add(this); 
        }
        
    }
    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }
        
    public int getWeekNo() {
        return weekNo;
    }

    public void setWeekNo(int weekNo) {
        this.weekNo = weekNo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
    
}
