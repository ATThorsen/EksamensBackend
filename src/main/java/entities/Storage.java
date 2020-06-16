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
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//
//@Entity
//@NamedQuery(name = "Storage.deleteAllRows", query = "DELETE from Storage")
//public class Storage {
//      private static final long serialVersionUID = 1L;
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long itemID;
//    private int amount;
//
//    @OneToMany (mappedBy="storage")
//    private List<Item> items = new ArrayList<>(); 
//
//    public Storage(int amount, int itemID) {
//        this.amount = amount;
//    }
//    
//   public void addItemToStorage (Item item) {
//        if(!this.items.contains(item)) {
//            this.itemID=item.getId();
//            this.items.add(item); 
//        }
////        if (!item.getStorage().equals(this)) {
////            item.setStorage(this); 
////        }
//    }
//
//    public long getItemID() {
//        return itemID;
//    }
//
//    public void setItemID(long itemID) {
//        this.itemID = itemID;
//    }
//
//    
//    
//    public Storage() {
//    }
//
//    public List<Item> getItems() {
//        return items;
//    }
//
//    public void setItems(List<Item> items) {
//        this.items = items;
//    }
//    
//    
//    public Storage(int amount) {
//        this.amount = amount;
//    }
//    
//    
//
//    public int getAmount() {
//        return amount;
//    }
//
//    public void setAmount(int amount) {
//        this.amount = amount;
//    }
//    
//    
//}
