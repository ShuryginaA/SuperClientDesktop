package com.autoservice.desktop.service;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@NoArgsConstructor
public class RequestMaker {

    public static String sendRequestToGetAllOrders() {
        var client = HttpClient.newHttpClient();
        String response = "Test";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/orders/allOrders"))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return response;
    }

    public static String sendRequestToChangeStatus(String orderId, String status) {
        var client = HttpClient.newHttpClient();
        String response = "Test";
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(("http://localhost:8080/orders/" +
                        orderId+"/changeStatus")))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(status))
                .build();

        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
        return response;
    }
}
