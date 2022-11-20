package com.autoservice.desktop.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.autoservice.desktop.data.RegistrationFormDto;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;

@Getter
public class RegistrationForm {
    private JPanel registration;
    private JTextField username;
    private JPasswordField password;
    private JPasswordField password2;
    private JTextField fullName;
    private JTextField phone;
    private JTextField email;
    private JButton register;

    public RegistrationForm() {
        register.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                if (username.getText().isEmpty() ||
                        password.getText().isEmpty()
                        || password2.getText().isEmpty()
                        || fullName.getText().isEmpty()
                        || phone.getText().isEmpty()
                        || email.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Все поля обязательны." +
                                    "Заполните их и попробуйте снова.",
                            "Ошибка регистрации",
                            JOptionPane.WARNING_MESSAGE);
                }
                if (!password.getText().equals(
                        password2.getText())) {
                    JOptionPane.showMessageDialog(null,
                            "Пароли не совпадают",
                            "Ошибка регистрации",
                            JOptionPane.WARNING_MESSAGE);
                }

                RegistrationFormDto registrationForm =
                        new RegistrationFormDto(
                                username.getText(),
                                password.getText(),
                                fullName.getText(),
                                phone.getText(),
                                email.getText()
                        );
                var client = HttpClient.newHttpClient();
                var objectMapper = new ObjectMapper();
                String requestBody = "Test";
                try {
                    requestBody = objectMapper
                            .writeValueAsString(registrationForm);
                } catch (JsonProcessingException ex) {
                    ex.printStackTrace();
                }
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create("http://localhost:8080/registration"))
                        .header("Content-Type", "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                        .build();
                String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
                if(response.equals("Success")){
                    JOptionPane.showMessageDialog(null,
                            "Вы успешно зарегистрированы, " +
                                    "пожалуйста, войдите в систему.",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
