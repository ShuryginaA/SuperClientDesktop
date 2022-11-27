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
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                List<OrderDto> orders=UtilClass.ordersParser(UtilClass.sendRequestToGetAllOrders());
                allOrdersPane.append("\n");
                for(OrderDto o:orders){
                    allOrdersPane.append("Id: "+ o.getId()+" " +
                            "Название: "+o.getName()+" "+"Имя клиента: "+o.getClientName()+" " +
                            "Статус: "+o.getStatus() +"\n");
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
    }

}
