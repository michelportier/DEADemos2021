package oose.dea.service;

import oose.dea.dao.IJediDAO;
import oose.dea.dao.JediDAO;
import oose.dea.domain.Jedi;
import oose.dea.service.dto.APKDTO;
import oose.dea.service.dto.JediDTO;
import oose.dea.service.dto.ShipDTO;


import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("starwars")
public class StarWars {

    private IJediDAO jediDAO;

    @GET
    @Path("hi")
    public String helloWorld(){
        return "May the force be with you, Luke!";
    }

    @GET
    @Path("jedi/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getJedi(@PathParam("id") int id){

        // Retrieve from database:
        Jedi jedi = jediDAO.getJedi(id);


        if (jedi == null){
            // help de jedi bestaat niet! wat doen we nu?
            return Response.status(404).build();
        }

        // this is considered ugly, but is it?
        JediDTO jediDTO = new JediDTO();
        jediDTO.name = jedi.getName();
        jediDTO.customerId = jedi.getId();

        return Response.status(200).entity(jediDTO).build();

    }

    @POST
    @Path("apk")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAPKForShip(ShipDTO shipDTO){
        APKDTO apkdto = new APKDTO();
        apkdto.isValid = false;
        apkdto.comments = "This ship has not been approved for  any galaxies"  ;

        if (shipDTO.name.equals("Millennium Falcon")){
            apkdto.comments = "This ship has been approved for galaxies far, far away" ;
            apkdto.isValid = true;

        }

        return Response.status(200).entity(apkdto).build();
    }

    @Inject
    public void setJediDAO(IJediDAO jediDAO) {
        this.jediDAO = jediDAO;
    }
}
