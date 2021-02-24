package oose.dea;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("starwars")
public class StarWars {

    @GET
    @Path("hi")
    public String helloWorld(){
        return "May the force be with you!";
    }
}
