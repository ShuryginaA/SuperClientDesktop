package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.LoginForm;
import com.autoservice.desktop.service.FormCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@Getter
public class Login {
    private JTextField username;
    private JPasswordField password;
    private JButton login;
    public JPanel jpanel;
    private JButton register;
    private FormCreator formCreator=new FormCreator();

    public Login() {
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              sendRequest(new LoginForm(username.getText(),password.getText()));
            }
        });
        register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formCreator.createFormRegister();
            }
        });
    }

    private void sendRequest(LoginForm loginForm){
      if(loginForm.getUsername().isEmpty() ||
      loginForm.getPassword().isEmpty()){
          JOptionPane.showMessageDialog(null,
                  "Вы не ввели логин или пароль." +
                          "Заполните эти поля и попробуйте снова.",
                  "Ошибка входа",
                  JOptionPane.WARNING_MESSAGE);

      }
        var client = HttpClient.newHttpClient();
        var objectMapper = new ObjectMapper();
        String requestBody="Test";
        try {
            requestBody = objectMapper
                    .writeValueAsString(loginForm);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("http://localhost:8080/auth"))
                .header("Content-Type","application/json")
                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                .build();

        try {
            String response=client.send(request, HttpResponse.BodyHandlers.ofString()).body();
            formCreator.createFormAfterLogin(response);

        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }



}


