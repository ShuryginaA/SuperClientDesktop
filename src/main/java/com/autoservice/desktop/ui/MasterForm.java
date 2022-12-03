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
public class MasterForm {
    private JPanel masterForm;
    private JButton getOrdersListButton;
    private JTextArea allOrdersPane;
    private JButton changeStatusButton;
    private FormCreator formCreator=new FormCreator();


    public MasterForm() {
        getOrdersListButton.addActionListener(new ActionListener() {
            @SneakyThrows
            @Override
            public void actionPerformed(ActionEvent e) {
                allOrdersPane.setText("");
                List<OrderDto> orders=UtilClass.ordersParser(UtilClass.sendRequestToGetAllOrders());
                allOrdersPane.append("\n");
                for(OrderDto o:orders){
                    allOrdersPane.append("Id: "+ o.getId()+" " +
                            "Название: "+o.getName()+" "+"Имя клиента: "+o.getClientName()+" " +
                            "Дата и время записи: "+o.getDate()+" "+
                            "Статус: "+o.getStatus() +"\n");
                }

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
