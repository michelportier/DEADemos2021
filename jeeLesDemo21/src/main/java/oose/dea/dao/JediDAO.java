package oose.dea.dao;

import oose.dea.domain.Jedi;

import javax.annotation.Resource;
import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Default;
import javax.sql.DataSource;
import java.sql.*;

@Default
public class JediDAO implements IJediDAO {

    @Resource(name = "jdbc/starwars")
    DataSource dataSource;

    @Override
    public Jedi getJedi(int id){
        String sql = "select * from jedi where customerId = ?";

        try {
            Connection connection = dataSource.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Jedi jedi = new Jedi(resultSet.getInt("customerId"));
                jedi.setDark(resultSet.getBoolean("darkside"));
                jedi.setName(resultSet.getString("name"));
                jedi.setBsn(resultSet.getString("bsn"));

                return jedi;
            }

        } catch (SQLException exception) {
            exception.printStackTrace();
        }

        return null;

    }
}
