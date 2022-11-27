package com.autoservice.desktop.ui;

import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class CallBackForm {
    private JPanel callBackForm;
    private JTextField name;
    private JTextField phone;
    private JTextArea comment;
    private JButton okButton;

    public CallBackForm(){

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
    }
}
