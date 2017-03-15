package web_service.flight_database;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Dell on 15.03.2017.
 */
public class AviaDB {

    private static Connection connection;
    private static InitialContext context;
    private static DataSource dataSource;

    public AviaDB() {
    }

    private static AviaDB instance;

    public static AviaDB getInstance() {
        if (instance == null){
            instance = new AviaDB();
        }
        return instance;
    }

    public Connection getConnection() {
        try {
            if (connection == null || connection.isClosed()) {
                context = new InitialContext();
                dataSource = (DataSource) context.lookup("");
                connection = dataSource.getConnection();
            }
        } catch (SQLException e) {
            Logger.getLogger(AviaDB.class.getName()).log(Level.SEVERE,null,e);
        } catch (NamingException e) {
            Logger.getLogger(AviaDB.class.getName()).log(Level.SEVERE,null,e);
        }

        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                Logger.getLogger(AviaDB.class.getName()).
                        log(Level.SEVERE,null,e);
            }
        }
    }
}
