package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.OrderDto;
import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.UtilClass;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Getter
public class CustomerForm {
    private JPanel customerForm;
    private JButton callBackButton;
    private JButton ordersButton;
    private JTextArea ordersField;

    private FormCreator formCreator = new FormCreator();

    public CustomerForm() {
        callBackButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formCreator.createFormCallBack();
            }
        });

        ordersButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                ordersField.setText("");
                List<OrderDto> orders = UtilClass.ordersParser(UtilClass.sendRequestToGetAllUserOrders());
                ordersField.append("\n");
                for (OrderDto o : orders) {
                    ordersField.append("Id: " + o.getId() + " " +
                            "Название: " + o.getName() + " " +
                            "Дата и время записи: " + o.getDate() + " " +
                            "Статус: " + o.getStatus() + "\n");
                }

            }
        });
    }
}
