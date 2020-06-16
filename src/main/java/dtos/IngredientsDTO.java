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
public class IngredientsDTO {
    
    private Long item_id;
    private String Ingeriedent;
    private String amount;
    
       public IngredientsDTO(Long item_id, String Ingeriedent, String amount) {
        this.item_id = item_id;
        this.Ingeriedent = Ingeriedent;
        this.amount = amount;
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
    
}
