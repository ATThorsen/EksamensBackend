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
//@NamedQuery(name = "Item.deleteAllRows", query = "DELETE from Item")
//public class Item {
//    
//    
//    private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long itemId; 
//    private String name;
//    private double pricePerKilo;
//    
//     @OneToMany (mappedBy ="item")
//    private List<Ingredient> ingredient = new ArrayList<>(); 
//    
//    @ManyToOne
//    private Storage storage;
//
//   
//    
//        public Long getId() {
//        return itemId;
//    }
//
//    public void setId(Long itemId) {
//        this.itemId = itemId;
//    }
//
//    public Item(Long itemId, String name, double pricePerKilo) {
//        this.itemId = itemId;
//        this.name = name;
//        this.pricePerKilo = pricePerKilo;
//    }
//
//    
//    public Item() {
//    }
//
//    public Item(String name, double pricePerKilo) {
//        this.name = name;
//        this.pricePerKilo = pricePerKilo;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public double getPricePerKilo() {
//        return pricePerKilo;
//    }
//
//    public Storage getStorage() {
//        return storage;
//    }
//
//    public void setStorage(Storage storage) {
//        this.storage = storage;
//    }
//
//    public List<Ingredient> getIngredient() {
//        return ingredient;
//    }
//
//    public void setIngredient(List<Ingredient> ingredient) {
//        this.ingredient = ingredient;
//    }
//
//    public void setPricePerKilo(double pricePerKilo) {
//        this.pricePerKilo = pricePerKilo;
//    }
//    
//    
//    
//    
//}
