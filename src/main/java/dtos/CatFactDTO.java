/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author casper
 */
public class CatFactDTO {
    
    private String text;
    private String createdAt;

    
    public CatFactDTO(){}
    public CatFactDTO(String text, String createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }
    
    
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }
    
    
    
    
}
