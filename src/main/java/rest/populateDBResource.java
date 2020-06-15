package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CatFactDTO;
import utils.EMF_Creator;
import utils.SetupTestUsers; 
import facades.FacadeExample;
import facades.UserFacade;
import java.io.IOException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

//Todo Remove or change relevant parts before ACTUAL use

@Path("db")
public class populateDBResource {
    Gson  gson = new Gson();

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3306/ca3",
                "dev",
                "ax2",
                EMF_Creator.Strategy.DROP_AND_CREATE);
    private static final UserFacade FACADE =  UserFacade.getUserFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            

    @Path("fill")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        String[] args = null;
       FACADE.populateDB(); 
      //  long count = FACADE.getRenameMeCount();
        return "Hej";  //Done manually so no need for a DTO 
    }

 
}
