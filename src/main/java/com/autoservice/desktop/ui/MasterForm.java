package com.autoservice.desktop.ui;

import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.UtilClass;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class MasterForm {
    private JPanel masterForm;
    private JButton getOrdersListButton;
    private JTextArea allOrdersPane;
    private JButton changeStatusButton;
    private FormCreator formCreator=new FormCreator();


    public MasterForm() {
        getOrdersListButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersPane.setText(UtilClass.sendRequestToGetAllOrders());

            }
        });
        changeStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formCreator.createFormChangeStatus();
            }
        });
    }
}
