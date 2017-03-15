package web_service.flight_database;

import web_service.flight_dir_object.Country;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Dell on 15.03.2017.
 */
public class CountryDB {

    public static Country getCountry(long id) throws SQLException {

        Country country = null;
        Connection connection = AviaDB.getInstance().getConnection();

        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.prepareStatement("SELECT *FROM spr_country WHERE id = ?");
            statement.setLong(1, id);

            resultSet = statement.executeQuery();
            resultSet.first();

            country = new Country();
            country.setId(resultSet.getLong("id"));
            country.setName(resultSet.getString("name"));
            //country.setDesc();
            country.setShortName(resultSet.getString("short_name"));
            //country.setFlag();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
        }
        return country;
    }
}
