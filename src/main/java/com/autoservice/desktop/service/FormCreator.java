package com.autoservice.desktop.service;

import com.autoservice.desktop.data.AuthDto;
import com.autoservice.desktop.ui.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@NoArgsConstructor
public class FormCreator {

    public static Long userId;

    public void createFormAfterLogin(String response) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        AuthDto authDto = objectMapper.readValue(response, AuthDto.class);
        userId = authDto.getId();
        if (authDto.getRoleName().equals("MANAGER")) {
            JFrame managerFrame = new JFrame("Manager");
            managerFrame.setContentPane(new ManagerForm().getManagPanel());
            managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            managerFrame.pack();
            managerFrame.setVisible(true);
        } else if (authDto.getRoleName().equals("MASTER")) {
            JFrame loginFrame = new JFrame("Master");
            loginFrame.setContentPane(new MasterForm().getMasterForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        } else if (authDto.getRoleName().equals("CUSTOMER")) {
            JFrame loginFrame = new JFrame("Customer");
            loginFrame.setContentPane(new CustomerForm().getCustomerForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(null,
                    "Вы не зарегистрированы или ввели неверный логин или пароль." +
                            "Попробуйте снова.",
                    "Ошибка входа",
                    JOptionPane.WARNING_MESSAGE);
        }
    }

    public void createFormRegister() {
        JFrame registerForm = new JFrame("Register");
        registerForm.setContentPane(new RegistrationForm().getRegistration());
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerForm.pack();
        registerForm.setVisible(true);
    }

    public void createFormNewOrder() {
        JFrame registerForm = new JFrame("New Order");
        registerForm.setContentPane(new OrderForm().getOrderForm());
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerForm.pack();
        registerForm.setVisible(true);
    }


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

}
