package rest;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.RecipeDTO;
import entities.Recipe;
import errorhandling.NotFoundException;
import facades.RecipeFacade;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Aske
 */@Path("recipe")
public class RecipeResource {
    
     Gson  gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/Eksamen",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final RecipeFacade FACADE =  RecipeFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllRecipe() {
        return GSON.toJson(FACADE.getAllRecipe());
    }
    
    @Path("id/{value}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRecipeByID(@PathParam("value") int value) throws NotFoundException {
        return GSON.toJson(FACADE.getRecipe(value));
    }
    
    @Path("add")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String addRecipe(String json) {
    RecipeDTO RecipeDTO = GSON.fromJson(json, RecipeDTO.class);
    RecipeDTO persistedRecipe = FACADE.addRecipe(RecipeDTO.getDish(),RecipeDTO.getPreparationTime(), RecipeDTO.getDirections());
    return GSON.toJson(persistedRecipe);
    }
     
}
