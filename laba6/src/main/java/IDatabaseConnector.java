import java.sql.Connection;
import java.sql.SQLException;

public interface IDatabaseConnector {
    public Connection Connect();
    public void Disconnect(Connection connection) throws SQLException;
}
