package me.shockyng.resources;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

public abstract class HttpResource implements HttpHandler {

    /**
     * @return the resource URI is going to be requested via HTTP method
     */
    public abstract String getResourceName();

    public void processResponse(String responseBodyMessage, HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        byte[] bytes = responseBodyMessage.getBytes();
        exchange.sendResponseHeaders(200, bytes.length);
        os.write(bytes);
        os.close();
    }

    public String getQueryParam(String paramName, HttpExchange exchange) {
        return Arrays.stream(exchange
                        .getRequestURI()
                        .getQuery()
                        .split("&"))
                .filter(item -> item.contains(paramName))
                .map(item -> item.split("=")[1])
                .findFirst()
                .get();
    }
}
