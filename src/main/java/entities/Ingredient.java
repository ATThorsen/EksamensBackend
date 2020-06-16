///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package entities;
//
//import java.util.ArrayList;
//import java.util.List;
//import javax.persistence.CascadeType;
//import javax.persistence.Entity;
//import javax.persistence.FetchType;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//
//@Entity
//@NamedQuery(name = "Ingredient.deleteAllRows", query = "DELETE from Ingredient")
//public class Ingredient {
//    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long item_id;
//    private double amount;
//    
//    
//    
//    
//    @ManyToOne
//    private Recipe recipe;
//    
//    @ManyToOne
//    private Item item;
//
//    public Ingredient() {
//    }
//
//    public Ingredient( double amount, Item item) {
//        
//        this.amount = amount;
//        this.item = item;
//    }
//
//    public Ingredient(Recipe recipe) {
//        this.recipe = recipe;
//    }
//
//    
//    
//    public Ingredient(double amount) {
//        this.amount = amount;
//    }
//    
//    public Ingredient(Long item_id, double amount) {
//        this.item_id = item_id;
//        this.amount = amount;
//    }
//    
//       public void addItemToIngredient (Item item) {
//        this.item = item; 
//        if(!item.getIngredient().contains(this)){
//            this.item = item;
//        }
//    }
//
//    public Long getId() {
//        return item_id;
//    }
//
//    public void setId(Long item_id) {
//        this.item_id = item_id;
//    }
//
//    public double getAmount() {
//        return amount;
//    }
//
//    public void setAmount(double amount) {
//        this.amount = amount;
//    }
//
//    public Item getItem() {
//        return item;
//    }
//
//    public void setItem(Item item) {
//        this.item = item;
//    }
//
//    public Recipe getRecipe() {
//        return recipe;
//    }
//
//    public void setRecipe(Recipe recipe) {
//        this.recipe = recipe;
//    }
//    
//    
//    
//}
