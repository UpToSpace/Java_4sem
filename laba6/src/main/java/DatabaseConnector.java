import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector implements IDatabaseConnector {
    private final String user = "sa";
    private final String password = "Vv1542139";
    private final String dbURL = "jdbc:sqlserver://DESKTOP-6BQAJ6M;databaseName=Weathers;integratedSecurity=false;"
            + "encrypt=false;trustServerCertificate=true";

    public Connection Connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(dbURL, user, password);
            //logger.info("ESTABLISHED CONNECTION WITH MSSQL");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return connection;
    }

    @Override
    public void Disconnect(Connection connection) throws SQLException {
        if (connection != null)
        {
            connection.close();
        }
    }
}
