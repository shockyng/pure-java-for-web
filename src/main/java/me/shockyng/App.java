package me.shockyng;

import me.shockyng.config.APIServer;
import me.shockyng.config.ResourcePathResolver;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        APIServer.create();
        APIServer.start();
    }
}
