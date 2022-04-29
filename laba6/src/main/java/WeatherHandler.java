import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class WeatherHandler {
    private static Logger logger = Logger.getLogger(WeatherHandler.class.getName());
    private final Connection connection;
    public WeatherHandler(Connection connection)
    {
        this.connection = connection;
    }
    public void GetRegionWeather(String region) throws SQLException  // Вывести сведения о погоде в заданном регионе.
    {
        String sql = "select Weather.date, Weather.temperature, Weather.precipitation from Region" +
                " inner join Weather on Region.name = Weather.region where Region.name like ?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, region);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            String message = "\nDate: "+ resultSet.getString(1) + "\nTemperature: " +
                    resultSet.getDouble(2) + "\nPrecipitation: " + resultSet.getDouble(3);
            logger.log(Level.INFO,message);
        }
        if (resultSet != null)
        {
            resultSet.close();
        }
    }

    //Вывести даты, когда в заданном регионе шел снег
    //и температура была ниже заданной отрицательной.
    public void GetSnowDates(String region, double temperature) throws SQLException
    {
        String sql = "select Weather.date, Weather.temperature, Weather.precipitation from Region" +
                " inner join Weather on Region.name = Weather.region where Region.name like '" +
                region +"' and Weather.temperature < " + temperature;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {
            String message = "\nDate: "+ resultSet.getString(1) + "\nTemperature: " +
                    resultSet.getDouble(2) + "\nPrecipitation: " + resultSet.getDouble(3);
            logger.log(Level.INFO,message);
        }
        if (resultSet != null)
        {
            resultSet.close();
        }
    }

    //Вывести информацию о погоде за прошедшую неделю в регионах,
    //жители которых общаются на заданном языке.
    public void GetLanguageDates(String language) throws SQLException
    {
        String sql = "select Weather.date, Weather.temperature, Weather.precipitation from Region" +
                " inner join Weather on Region.name = Weather.region inner join Citizen_type on " +
                "Region.citizen_type = Citizen_type.name where Citizen_type.language like '"+
                language + "' and Weather.date between cast('2022-04-18' as date) and cast('2022-04-25' as date)";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {
            String message = "\nDate: "+ resultSet.getString(1) + "\nTemperature: " +
                    resultSet.getDouble(2) + "\nPrecipitation: " + resultSet.getDouble(3);
            logger.log(Level.INFO,message);
        }
        if (resultSet != null)
        {
            resultSet.close();
        }
    }

    // Вывести среднюю температуру за прошедшую неделю в регионах с
    // площадью больше заданной.
    public void GetSquareDates(int square) throws SQLException
    {
        String sql = "select avg(Weather.temperature) from Region" +
                " inner join Weather on Region.name = Weather.region where Weather.date between" +
                " cast('2022-04-18' as date) and cast('2022-04-25' as date) and Region.square > "+ square;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        while(resultSet.next())
        {
            String message = "\nTemperature: "+ resultSet.getDouble(1);
            logger.log(Level.INFO,message);
        }
        if (resultSet != null)
        {
            resultSet.close();
        }
    }
}
