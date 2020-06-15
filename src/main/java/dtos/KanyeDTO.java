/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

/**
 *
 * @author jenso
 */
public class KanyeDTO {
    
    private String text;
    private String createdAt;
    private String quote; 

    public KanyeDTO(String text, String createdAt) {
        this.text = text;
        this.createdAt = createdAt;
    }

    public KanyeDTO(String text, String createdAt, String quote) {
        this.text = text;
        this.createdAt = createdAt;
        this.quote = quote;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
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
