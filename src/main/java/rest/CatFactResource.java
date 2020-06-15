package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CatFactDTO;
import utils.EMF_Creator;
import facades.FacadeExample;
import java.io.IOException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

//Todo Remove or change relevant parts before ACTUAL use
@RolesAllowed("user")
@Path("catfact")
public class CatFactResource {
    Gson  gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/ca3",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final FacadeExample FACADE =  FacadeExample.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getCatFact() throws IOException {
        
        
        
        String catFact = HttpUtils.fetchData("https://cat-fact.herokuapp.com/facts/random");
        
        CatFactDTO cfDTO = gson.fromJson(catFact, CatFactDTO.class);
        
        return  gson.toJson(cfDTO);
        
    }
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getRenameMeCount();
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }

 
}