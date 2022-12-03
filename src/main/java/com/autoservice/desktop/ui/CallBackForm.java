package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.CallBackDto;
import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.UtilClass;
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

    public CallBackForm() {

        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (name.getText().isEmpty() ||
                        phone.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Вы не ввели имя или номер телефона." +
                                    "Заполните эти поля и попробуйте снова.",
                            "Ошибка входа",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String response = UtilClass.sendRequestToOrderCallback(new CallBackDto(
                        name.getText(), phone.getText(), comment.getText()
                ));
                if (response.equals("Success")) {
                    JOptionPane.showMessageDialog(null,
                            "Мы вам перезвоним, заказ отправлен",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                FormCreator.callbackForm.dispose();
            }
        });
    }
}
