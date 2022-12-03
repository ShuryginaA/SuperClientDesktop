package com.autoservice.desktop.ui;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class EditOrderForm {
    private JPanel editOrder;
    private JTextField orderNumber;
    private JTextField time;
    private JButton okButton;

    public  EditOrderForm(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
