package com.autoservice.desktop.service;

import com.autoservice.desktop.data.AuthDto;
import com.autoservice.desktop.data.OrderDto;
import com.autoservice.desktop.ui.OrderForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
public class UtilClass {

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

    public static List<OrderDto> ordersParser(String orders) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        return Arrays.asList(objectMapper.readValue(orders, OrderDto[].class));
    }
}
