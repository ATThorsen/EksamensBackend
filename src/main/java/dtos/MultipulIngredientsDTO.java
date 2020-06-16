/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dtos;

import entities.Ingeriedents;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Aske
 */
public class MultipulIngredientsDTO {
    
      List<IngredientsDTO> all = new ArrayList<>();
         
    public MultipulIngredientsDTO(List<IngredientsDTO> ingList) {
         for (IngredientsDTO r : ingList){
             all.add(r);
             
         }
       
    }
    
    
}
