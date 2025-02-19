package me.shockyng.config;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import me.shockyng.resources.HelloWorldResource;
import me.shockyng.resources.NotFoundResource;
import me.shockyng.resources.PeopleResource;

import java.io.IOException;

public class ResourcePathResolver implements HttpHandler {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        switch (exchange.getRequestURI().toString()) {
            case "/hello-world" -> new HelloWorldResource().perform(exchange);
            case "/v1/people" -> new PeopleResource().perform(exchange);
            default -> new NotFoundResource().perform(exchange);
        }
    }
}
