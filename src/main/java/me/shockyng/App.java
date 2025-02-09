package me.shockyng;

import me.shockyng.config.APIServer;
import me.shockyng.resources.HelloWordResource;

import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        APIServer.create();
        APIServer.bindResource(new HelloWordResource());
        APIServer.start();
    }
}
