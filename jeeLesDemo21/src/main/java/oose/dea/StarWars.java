package oose.dea;

import oose.dea.oose.dea.dto.JediDTO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("starwars")
public class StarWars {

    @GET
    @Path("hi")
    public String helloWorld(){
        return "May the force be with you, Luke!";
    }

    @GET
    @Path("jedi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJedi(@PathParam("id") int id){
        if (id != 41){
            // help de jedi bestaat niet! wat doen we nu?
            return Response.status(404).entity("niet gevonden").build();
        }
        JediDTO jediDTO = new JediDTO();
        jediDTO.name = "Thijmen";
        jediDTO.customerId = id;

        return Response.status(200).entity(jediDTO).build();

    }

}
