/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.UselessFactDTO;
import facades.FacadeExample;
import java.io.IOException;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.EMF_Creator;
import utils.HttpUtils;

/**
 *
 * @author Aske
 */
@Path("uselessfact")
public class UsslessFactResource {
    
        Gson  gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ca3",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getRenameMeCount();
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCatFact() throws IOException {
        String uselessFact = HttpUtils.fetchData("https://uselessfacts.jsph.pl/random.json?language=en");
        UselessFactDTO ufDTO = gson.fromJson(uselessFact, UselessFactDTO.class);
        
        return  gson.toJson(ufDTO);
        
    }

}
