package com.autoservice.desktop.ui;

import com.autoservice.desktop.data.CallBackEntity;
import com.autoservice.desktop.data.OrderDto;
import com.autoservice.desktop.data.UpdateOrderDto;
import com.autoservice.desktop.data.UsernameDto;
import com.autoservice.desktop.service.FormCreator;
import com.autoservice.desktop.service.UtilClass;
import lombok.Getter;
import lombok.SneakyThrows;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

@Getter
public class ManagerForm {
    private JPanel managPanel;
    private JButton changeOrderButton;
    private JButton addNewOrderButton;
    private JScrollPane allOrders;
    private JButton getOrdersListButton;
    private JTextArea allOrdersPane;
    private JLabel managLabel;
    private JTextArea callBackTextArea;
    private JButton getCallBacksButton;
    private JButton getClientIdButton;
    private JTextField userNameField;
    private FormCreator formCreator = new FormCreator();

    public ManagerForm() {
        getOrdersListButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersPane.setText("");
                List<OrderDto> orders = UtilClass.ordersParser(UtilClass.sendRequestToGetAllOrders());
                allOrdersPane.append("\n");
                for (OrderDto o : orders) {
                    allOrdersPane.append("Id: " + o.getId() + " " +
                            "Название: " + o.getName() + " " + "Имя клиента: " + o.getClientName() + " " +
                            "Дата и время записи: " + o.getDate() + " " +
                            "Статус: " + o.getStatus() + "\n");
                }

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
        getCallBacksButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                callBackTextArea.setText("");
                List<CallBackEntity> callBacks = UtilClass.callBackParser(UtilClass.sendRequestToGetAllCallbacks());
                callBackTextArea.append("\n");
                for (CallBackEntity c : callBacks) {
                    callBackTextArea.append("Id: " + c.getId() + " " +
                            "Имя клиента: " + c.getName() + " " + "Телефон: " + c.getPhone() + " " +
                            "Комментарий: " + c.getComment() + "\n");
                }

            }
        });
        getClientIdButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (userNameField.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null,
                            "Укажите имя пользователя" +
                                    "Заполните их и попробуйте снова.",
                            "Ошибка",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }
                String response = UtilClass.sendRequestToGetIdByUserName(new UsernameDto(
                        userNameField.getText()
                ));
            if(response.equals("-100")){
                JOptionPane.showMessageDialog(null,
                        "Такого пользователя нет",
                        "Ошибка",
                        JOptionPane.INFORMATION_MESSAGE);
                return;
            }
                    JOptionPane.showMessageDialog(null,
                            "Id пользователя: "+response,
                            "Успех",
                            JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }
}
