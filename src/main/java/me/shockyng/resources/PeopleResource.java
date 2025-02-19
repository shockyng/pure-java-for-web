package me.shockyng.resources;

import com.sun.net.httpserver.HttpExchange;
import me.shockyng.config.HttpResource;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class PeopleResource extends HttpResource {

    public void perform(HttpExchange exchange) throws IOException {
        try {
            Properties properties = new Properties();
            properties.setProperty("user", "postgres");
            properties.setProperty("password", "123456789");
            Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/api-db", properties);

            String createPeopleTableQuery = """
                CREATE TABLE PEOPLE(
                    PERSON_ID SERIAL PRIMARY KEY,
                    PERSON_NAME VARCHAR(255)
                );
            """;

            PreparedStatement preparedStatement = connection.prepareStatement(createPeopleTableQuery);
            int result = preparedStatement.executeUpdate();
            if (result == 0) processResponse("Table created successfully", HttpURLConnection.HTTP_OK, exchange);

        } catch (Exception e) {
            processResponse(e.getMessage(), HttpURLConnection.HTTP_BAD_REQUEST, exchange);
        }
    }
}
