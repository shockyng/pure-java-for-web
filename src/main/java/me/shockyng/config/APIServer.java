package me.shockyng.config;

import com.sun.net.httpserver.HttpServer;
import me.shockyng.APILogger;
import me.shockyng.resources.HttpResource;

import java.io.IOException;
import java.net.Inet6Address;
import java.net.InetSocketAddress;

public class APIServer {

    private static final APILogger logger = APILogger.getLogger(APIServer.class);
    private static final int PORT = 8080;
    private static HttpServer server;

    public static void create() throws IOException {
        String loopBackAddress = Inet6Address.getLoopbackAddress().getHostAddress();
        logger.info("Host address retrieved: " + loopBackAddress);
        InetSocketAddress inetSocketAddress = new InetSocketAddress(loopBackAddress, PORT);
        logger.info("InetSocketAddress created");
        server = HttpServer.create(inetSocketAddress, 0);
        logger.info("Server created");
    }

    public static void start() {
        server.start();

        logger.info("Server started and listing at port " + PORT);
    }

    public static void bindResource(HttpResource httpResource) {
        server.createContext(httpResource.getResourceName(), httpResource);
    }
}
