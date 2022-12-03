package com.autoservice.desktop.service;

import com.autoservice.desktop.data.AuthDto;
import com.autoservice.desktop.ui.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import javax.swing.*;


@NoArgsConstructor
public class FormCreator {

    public static Long userId;
    public static JFrame loginFrame=new JFrame("Login");
    public static JFrame managerFrame = new JFrame("Manager");
    public static JFrame loginFrameMaster = new JFrame("Master");
    public static JFrame loginFrameCustomer = new JFrame("Customer");
    public static JFrame registerForm = new JFrame("Register");
    public static JFrame newOrderForm = new JFrame("New Order");
    public static JFrame editForm = new JFrame("Edit Order");
    public static JFrame statusForm = new JFrame("Change status");
    public static JFrame callbackForm = new JFrame("Call me back");




    public void createFormAfterLogin(String response) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        AuthDto authDto = objectMapper.readValue(response, AuthDto.class);
        if (authDto.getRoleName().equals("Unauthorized")) {
            JOptionPane.showMessageDialog(null,
                    "Вы не зарегистрированы или ввели неверный логин или пароль." +
                            "Попробуйте снова.",
                    "Ошибка входа",
                    JOptionPane.WARNING_MESSAGE);
        }
        userId = authDto.getId();
        if (authDto.getRoleName().equals("MANAGER")) {

            managerFrame.setContentPane(new ManagerForm().getManagPanel());
            managerFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            managerFrame.pack();
            managerFrame.setVisible(true);
        } else if (authDto.getRoleName().equals("MASTER")) {
            loginFrameMaster.setContentPane(new MasterForm().getMasterForm());
            loginFrameMaster.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrameMaster.pack();
            loginFrameMaster.setVisible(true);
        } else if (authDto.getRoleName().equals("CUSTOMER")) {
            loginFrameCustomer.setContentPane(new CustomerForm().getCustomerForm());
            loginFrameCustomer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrameCustomer.pack();
            loginFrameCustomer.setVisible(true);
        }
    }

    public void createFormRegister() {
        registerForm.setContentPane(new RegistrationForm().getRegistration());
        registerForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registerForm.pack();
        registerForm.setVisible(true);
    }

    public void createFormNewOrder() {
        newOrderForm.setContentPane(new OrderForm().getOrderForm());
        newOrderForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        newOrderForm.pack();
        newOrderForm.setVisible(true);
    }

    public void createFormEditOrder() {
        editForm.setContentPane(new EditOrderForm().getEditOrder());
        editForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        editForm.pack();
        editForm.setVisible(true);
    }

    public void createFormChangeStatus() {
        statusForm.setContentPane(new ChangeOrderStatusForm().getChangeOrderStatusForm());
        statusForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        statusForm.pack();
        statusForm.setVisible(true);
    }

    public void createFormCallBack() {
        callbackForm.setContentPane(new CallBackForm().getCallBackForm());
        callbackForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        callbackForm.pack();
        callbackForm.setVisible(true);
    }



}
