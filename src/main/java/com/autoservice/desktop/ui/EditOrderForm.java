package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.CallBackDto;
import com.autoservice.desktop.data.UpdateOrderDto;
import com.autoservice.desktop.service.UtilClass;
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
                if (orderNumber.getText().isEmpty() ||
                        time.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Все поля обязательны" +
                                    "Заполните их и попробуйте снова.",
                            "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String response = UtilClass.sendRequestToUpdateOrder(new UpdateOrderDto(
                        Long.parseLong(orderNumber.getText()), time.getText()
                ));
                if (response.equals("Success")) {
                    JOptionPane.showMessageDialog(null,
                            "Заказ обновлен",
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
