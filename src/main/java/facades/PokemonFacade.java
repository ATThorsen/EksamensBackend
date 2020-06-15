/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import dtos.pokeDTO;
import entities.RenameMe;
import java.io.IOException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import utils.HttpUtils;

/**
 *
 * @author mikke
 */
public class PokemonFacade {

    private String PokemonByURL = "https://pokeapi.co/api/v2/pokemon/";

    private static EntityManagerFactory emf;
    private static PokemonFacade instance;

    public PokemonFacade() {
    }

    public static PokemonFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PokemonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public pokeDTO getPokemonById(int id) throws IOException {
        String poke = HttpUtils.fetchData(PokemonByURL + id);
        JsonObject jobj = new Gson().fromJson(poke, JsonObject.class);

        pokeDTO pdto = new pokeDTO(jobj);

        return pdto;
    }

    public Object getPokemonById(String name) throws IOException {
        String poke = HttpUtils.fetchData(PokemonByURL + name);
        JsonObject jobj = new Gson().fromJson(poke, JsonObject.class);
        pokeDTO pdto = new pokeDTO(jobj);
        return pdto;
    }

}
