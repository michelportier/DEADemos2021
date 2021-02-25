import oose.dea.StarWars;
import oose.dea.oose.dea.dto.JediDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class StarWarsTest {

    private StarWars starWars;

    @BeforeEach
    public void setUp(){
        starWars = new StarWars();
    }

    @Test
    public void helloWorldTest (){
        // Arrange
        String expected = "May the force be with you, Luke!";

        // Act
        String actual = starWars.helloWorld();

        // Assert
        assertEquals(expected,actual);
    }

    @Test
    public void getJediTest(){
        int statuscodeExpected = 200;
        int id = 41;
        String name = "Thijmen";

        Response response = starWars.getJedi(id);
        JediDTO jediDTO = (JediDTO) response.getEntity();

        assertEquals(statuscodeExpected, response.getStatus());
        assertEquals(id,jediDTO.customerId);
        assertEquals(name,jediDTO.name);


    }

    @Test
    public void getJediNotFoundTest(){
        int statuscodeExpected = 404;
        int id = 50;

        Response response = starWars.getJedi(id);
        String responseString = (String) response.getEntity();

        assertEquals(statuscodeExpected, response.getStatus());
        assertEquals("niet gevonden",responseString);



    }


}
