import oose.dea.StarWars;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StarWarsTest {


    @Test
    public void helloWorldTest (){
        // Arrange
        StarWars starWars = new StarWars();

        // Act
        String expected = "May the force be with you, Luke!";
        String actual = starWars.helloWorld();

        // Assert
        assertEquals(expected,actual);
    }


}
