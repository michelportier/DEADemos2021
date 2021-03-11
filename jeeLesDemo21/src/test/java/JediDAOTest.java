import oose.dea.dao.JediDAO;
import oose.dea.domain.Jedi;
import org.junit.jupiter.api.Test;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.*;

public class JediDAOTest {

    @Test
    public void getJediTest(){
        try {
            /**** Arrange ****/
            String expectedSQL = "select * from jedi where customerId = ?";
            int idToTest = 76576;

            // setup Mocks
            DataSource dataSource = mock(DataSource.class);
            Connection connection = mock(Connection.class);
            PreparedStatement preparedStatement = mock(PreparedStatement.class);
            ResultSet resultSet = mock(ResultSet.class);

            // instruct Mocks
            when(dataSource.getConnection()).thenReturn(connection);
            when(connection.prepareStatement(expectedSQL)).thenReturn(preparedStatement);
            when(preparedStatement.executeQuery()).thenReturn(resultSet);
            when(resultSet.next()).thenReturn(false);

            // setup classes
            JediDAO jediDAO = new JediDAO();
            jediDAO.setDataSource(dataSource);

            /**** Act ****/
            Jedi jedi = jediDAO.getJedi(idToTest);

            /**** Assert ****/
            verify(connection).prepareStatement(expectedSQL);// TODO: test doesn't work properly
            verify(preparedStatement).setInt(1,idToTest);
            verify(preparedStatement).executeQuery();

            assertNull(jedi);

        }
        catch (Exception e){
            fail();
        }
    }
}
