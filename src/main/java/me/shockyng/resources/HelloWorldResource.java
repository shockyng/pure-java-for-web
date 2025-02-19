package me.shockyng.resources;

import com.sun.net.httpserver.HttpExchange;
import me.shockyng.config.HttpResource;

import java.io.IOException;
import java.net.HttpURLConnection;

public class HelloWorldResource extends HttpResource {
    public void perform(HttpExchange exchange) throws IOException {
        processResponse("Hello World API", HttpURLConnection.HTTP_OK, exchange);
    }
}
