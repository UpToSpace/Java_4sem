import java.sql.Connection;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
    DatabaseConnector dc = new DatabaseConnector();
    Connection connection = dc.Connect();
    WeatherHandler wh = new WeatherHandler(connection);

    String region = "Минск";
    wh.GetRegionWeather(region);

    region = "Москва";
    wh.GetSnowDates(region, -2.0);

    String language = "беларуский";
    wh.GetLanguageDates(language);

    int square = 600000;
    wh.GetSquareDates(square);

    dc.Disconnect(connection);
    }
}
