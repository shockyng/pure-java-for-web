package me.shockyng.resources;

import com.sun.net.httpserver.HttpExchange;
import me.shockyng.config.HttpResource;

import java.io.IOException;
import java.net.HttpURLConnection;

public class NotFoundResource extends HttpResource {

    public void perform(HttpExchange exchange) throws IOException {
        processResponse("Path not found", HttpURLConnection.HTTP_NOT_FOUND, exchange);
    }
}
