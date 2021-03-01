import oose.dea.dao.IJediDAO;
import oose.dea.dao.JediDAO;
import oose.dea.domain.Jedi;
import oose.dea.service.StarWars;
import oose.dea.service.dto.JediDTO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import javax.ws.rs.core.Response;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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
    public void getJediTestRegular(){
        // Arrange
        int statuscodeExpected = 200;
        int id = 41;
        String name = "Thijmen";
        Jedi jedi = new Jedi(id);
        jedi.setName("Thijmen");

        IJediDAO jediDAOMock = mock(IJediDAO.class);
        when(jediDAOMock.getJedi(id)).thenReturn(jedi);
        starWars.setJediDAO(jediDAOMock);


        // Act
        Response response = starWars.getJedi(id);
        JediDTO jediDTO = (JediDTO) response.getEntity();

        // Assert
        assertEquals(statuscodeExpected, response.getStatus());
        assertEquals(id,jediDTO.customerId);
        assertEquals(name,jediDTO.name);


    }


    @Test
    public void getJediNotFoundTest(){
        // Arrange
        int statuscodeExpected = 404;
        int id = 41;

        IJediDAO jediDAOMock = mock(IJediDAO.class);
        when(jediDAOMock.getJedi(id)).thenReturn(null);
        starWars.setJediDAO(jediDAOMock);

        // Act
        Response response = starWars.getJedi(id);

        // Assert
        assertEquals(statuscodeExpected, response.getStatus());
    }


}
