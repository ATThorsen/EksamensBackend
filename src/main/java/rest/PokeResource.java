package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import utils.EMF_Creator;
import facades.FacadeExample;
import facades.PokemonFacade;
import java.io.IOException;
import javax.annotation.security.RolesAllowed;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("pokemon")
public class PokeResource {
        private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/startcode",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final PokemonFacade FACADE =  PokemonFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }

    

    @Path("/{id}")
    @GET
    @RolesAllowed({("admin"),("user")})
    @Produces({MediaType.APPLICATION_JSON})
    public String getPokemonById(@PathParam("id") int id) throws IOException {
        return GSON.toJson(FACADE.getPokemonById(id)); 
    }

    
    @Path("/name/{name}")
    @GET
    @RolesAllowed({("admin"),("user")})
    @Produces({MediaType.APPLICATION_JSON})
    public String getPokemonById(@PathParam("name") String name) throws IOException {
        return GSON.toJson(FACADE.getPokemonById(name)); 
    }

    

    
}
