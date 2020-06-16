/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.WeekMenuDTO;
import dtos.addRecipeDTO;
import errorhandling.NotFoundException;
import facades.WeekMenuFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/**
 *
 * @author Aske
 */
 @Path("weekmenu")
public class WeekMenuResource {
    
     Gson  gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Eksamen",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final WeekMenuFacade FACADE =  WeekMenuFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    //Private Constructor to ensure Singleton
    
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
  @Path("add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addWeekMenu(String json) throws NotFoundException {
    WeekMenuDTO WeekMenuDTO = GSON.fromJson(json, WeekMenuDTO.class);
    WeekMenuDTO persistedWeekMenu = FACADE.create(WeekMenuDTO.getWeekNo(), WeekMenuDTO.getYear());
    return GSON.toJson(persistedWeekMenu);
    }
    
     @Path("addrecipe")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addRecipeToWeek(String json) throws NotFoundException {
    addRecipeDTO addRecipeDTO = GSON.fromJson(json, addRecipeDTO.class);
    
    addRecipeDTO weekAndRecipe = FACADE.addRecipeToWeek(addRecipeDTO.getRecipeID(),addRecipeDTO.getWeekID());
    return GSON.toJson(weekAndRecipe.getRecipeID() + " has been added to a "+weekAndRecipe.getWeekID() + " menu");
    }
    
    
}
