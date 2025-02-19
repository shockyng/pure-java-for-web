package me.shockyng.config;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.util.Arrays;

public abstract class HttpResource {

    public void processResponse(String responseBodyMessage, int StatusCode, HttpExchange exchange) throws IOException {
        OutputStream os = exchange.getResponseBody();
        byte[] bytes = responseBodyMessage.getBytes();
        exchange.sendResponseHeaders(StatusCode, bytes.length);
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
