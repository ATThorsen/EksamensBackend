package dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class pokeDTO {

    @JsonProperty("id")
    private int id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("types")
    private JsonArray types; 
    @JsonProperty("moves")
    private JsonArray moves; 

    public pokeDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public pokeDTO(JsonObject jobj) {
        this.id = jobj.get("id").getAsInt();
        this.name = jobj.get("name").getAsString();
        this.types = jobj.getAsJsonArray("types"); 
        this.moves = jobj.getAsJsonArray("moves"); 
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JsonArray getTypes() {
        return types;
    }

    public void setTypes(JsonArray types) {
        this.types = types;
    }

    public JsonArray getMoves() {
        return moves;
    }

    public void setMoves(JsonArray moves) {
        this.moves = moves;
    }

    


}
