package web_service.flight_database;

import web_service.flight_dir_object.City;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dell on 15.03.2017.
 */
public class CityDB {

    public CityDB() {
    }

    private static CityDB instance;

    private static CityDB getInstance() {
        if (instance == null) {
            instance = new CityDB();
        }
        return instance;
    }

    public City getCity(String name) {
        try {
            return getCity(getCityStatement(name));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
          AviaDB.getInstance().closeConnection();
        }
        return null;
    }

    public City getCity(long id) {
        try {
            return getCity(getCityStatement(id));
        } catch (SQLException e) {
            Logger.getLogger(CityDB.class.getName()).log(Level.SEVERE,null,e);
        } finally {
            AviaDB.getInstance().closeConnection();
        }
        return null;
    }

    private City getCity(PreparedStatement statement) {
        City city = null;
        ResultSet resultSet;

        try {
            resultSet = statement.executeQuery();

            resultSet.next();
            if (resultSet.isFirst()) {
                city = new City();
                city.setId(resultSet.getLong("id"));
                city.setName(resultSet.getString("name"));
                city.setCountry(CountryDB.getCountry(resultSet.getLong("country_id")));
                city.setDesc(resultSet.getString("desc"));
                city.setPostcode(resultSet.getString("postcode"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return city;
    }

    private PreparedStatement getCityStatement(String name) throws SQLException {
        Connection connection = AviaDB.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT  * FROM  spr_city WHERE name = ?");
        statement.setString(1, name);
        return statement;
    }

    private PreparedStatement getCityStatement(long id) throws SQLException {
        Connection connection = AviaDB.getInstance().getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT  * FROM  spr_city WHERE id = ?");
        statement.setLong(1,id);
        return statement;
    }

}
