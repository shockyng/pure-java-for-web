package me.shockyng.resources;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class HelloWordResource extends HttpResource {

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String username = getQueryParam("username", exchange);
        processResponse("Hello World " + username, exchange);
    }

    @Override
    public String getResourceName() {
        return "/hello-world";
    }
}
