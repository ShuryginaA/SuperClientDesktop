package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.CallBackDto;
import com.autoservice.desktop.data.ForSavingOrderDto;
import com.autoservice.desktop.service.UtilClass;
import lombok.Getter;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@Getter
public class OrderForm {
    private JPanel orderForm;
    private JTextField name;
    private JTextField clientId;
    private JTextField dateAndTime;
    private JButton okButton;

    public OrderForm(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() ||
                        clientId.getText().isEmpty()
                || dateAndTime.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Все поля обязательны" +
                                    "Заполните их и попробуйте снова.",
                            "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                ForSavingOrderDto tmpDto=new ForSavingOrderDto(
                        name.getText(), Long.parseLong(clientId.getText()), dateAndTime.getText());
                String response = UtilClass.sendRequestToSaveOrder(new ForSavingOrderDto(
                        name.getText(), Long.parseLong(clientId.getText()), dateAndTime.getText()
                ));
                if (response.equals("Success")) {
                    JOptionPane.showMessageDialog(null,
                            "Заказ отправлен",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}

