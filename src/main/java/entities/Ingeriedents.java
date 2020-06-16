/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "Ingredintes.deleteAllRows", query = "DELETE from Ingeriedents")
public class Ingeriedents {
    
        private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;
    private String Ingeriedent;
    private String amount;

    @ManyToOne(cascade = {CascadeType.ALL})
    private Recipe recipe;
    
    public Ingeriedents(Long item_id, String Ingeriedent, String amount) {
        this.item_id = item_id;
        this.Ingeriedent = Ingeriedent;
        this.amount = amount;
    }

    public Ingeriedents(String Ingeriedent, String amount) {
        this.Ingeriedent = Ingeriedent;
        this.amount = amount;
    }

    public Ingeriedents(Long item_id, String Ingeriedent, String amount, Recipe recipe) {
        this.item_id = item_id;
        this.Ingeriedent = Ingeriedent;
        this.amount = amount;
        this.recipe = recipe;
    }
    
    

    public Ingeriedents() {
    }

    public Long getItem_id() {
        return item_id;
    }

    public void setItem_id(Long item_id) {
        this.item_id = item_id;
    }

    public String getIngeriedent() {
        return Ingeriedent;
    }

    public void setIngeriedent(String Ingeriedent) {
        this.Ingeriedent = Ingeriedent;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }
    
}
