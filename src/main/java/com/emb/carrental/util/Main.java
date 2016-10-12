package com.emb.carrental.util;

import java.io.IOException;
import java.net.URI;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

/**
 *
 * @author bu_000
 */
public class Main {

    // Base URI the Grizzly HTTP server will listen on
    public static final String API_PATH = "http://localhost:8888/CarRental/api/";

    public static HttpServer startServer() {
        // create a resource config that scans for JAX-RS resources and providers
        // in com.emb.carrental.res package
        final ResourceConfig resourceConfig = new ResourceConfig().packages("com.emb.carrental");

        // create and start a new instance of grizzly http server
        // exposing the Jersey application at API_PATH
        return GrizzlyHttpServerFactory.createHttpServer(URI.create(API_PATH), resourceConfig);
    }

    public static void main(String[] args) throws IOException {
        final HttpServer server = startServer();
        LOG.info("Started Jersey server at ", API_PATH);
        LOG.info("To stop the server hit ENTER key");
        System.in.read();
        server.stop();
    }
}
