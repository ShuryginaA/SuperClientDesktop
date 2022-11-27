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
public class CustomerForm {
    private JPanel customerForm;
    private JButton bookButton;
    private JButton ordersButton;
    private JTextArea orders;

    private FormCreator formCreator=new FormCreator();

    public CustomerForm() {
        bookButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               formCreator.createFormCallBack();
            }
        });

    }

    private void sendRequest() {
//        if (timeField.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null,
//                    "Вы не ввели время." +
//                            "Заполните и попробуйте снова.",
//                    "Ошибка записи",
//                    JOptionPane.WARNING_MESSAGE);
//
//        }
//        var client = HttpClient.newHttpClient();
//        String requestBody = timeField.getText();
//        HttpRequest request = HttpRequest.newBuilder()
//                .uri(URI.create("http://localhost:8080/orders"
//                        + "/" + FormCreator.userId + "/bookTime"))
//                .header("Content-Type", "application/json")
//                .POST(HttpRequest.BodyPublishers.ofString(requestBody))
//                .build();
//
//        try {
//            String response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
//            if (response.equals("Success")) {
//                JOptionPane.showMessageDialog(null,
//                        "Вы успешно записаны на  " +
//                                requestBody,
//                        "Успех",
//                        JOptionPane.INFORMATION_MESSAGE);
//            }
//
//        } catch (IOException | InterruptedException ex) {
//            ex.printStackTrace();
//        }
    }
}
