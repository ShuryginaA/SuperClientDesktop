package com.autoservice.desktop.ui;

import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.RequestMaker;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class ManagerForm {
    private JPanel managPanel;
    private JButton changeOrderButton;
    private JButton addNewOrderButton;
    private JScrollPane allOrders;
    private JButton getOrdersListButton;
    private JTextArea allOrdersPane;
    private JLabel managLabel;
    private FormCreator formCreator=new FormCreator();

    public ManagerForm() {
        getOrdersListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersPane.setText(RequestMaker.sendRequestToGetAllOrders());

            }
        });
        addNewOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
           formCreator.createFormNewOrder();
            }
        });
        changeOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formCreator.createFormEditOrder();
            }
        });
    }

}
