package com.autoservice.desktop.service;

import com.autoservice.desktop.data.AuthDto;
import com.autoservice.desktop.ui.CustomerForm;
import com.autoservice.desktop.ui.ManagerForm;
import com.autoservice.desktop.ui.MasterForm;
import com.autoservice.desktop.ui.RegistrationForm;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.NoArgsConstructor;

import javax.swing.*;


@NoArgsConstructor
public class FormCreator {

    public static Long userId;
    public void createFormAfterLogin(String response) throws JsonProcessingException {
        var objectMapper = new ObjectMapper();
        AuthDto authDto = objectMapper.readValue(response, AuthDto.class);
        userId=authDto.getId();
        if(authDto.getRoleName().equals("MANAGER"))
        {
            JFrame loginFrame=new JFrame("Manager");
            loginFrame.setContentPane(new ManagerForm().getManagerForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        }
        else
        if(authDto.getRoleName().equals("MASTER"))
        {
            JFrame loginFrame=new JFrame("Master");
            loginFrame.setContentPane(new MasterForm().getMasterForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        }

        else if (authDto.getRoleName().equals("CUSTOMER")) {
            JFrame loginFrame=new JFrame("Customer");
            loginFrame.setContentPane(new CustomerForm().getCustomerForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(null,
                    "Вы не зарегистрированы или ввели неверный логин или пароль." +
                            "Попробуйте снова.",
                    "Ошибка входа",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
    public void createFormRegister(){
        JFrame registerForm=new JFrame("Register");
        registerForm.setContentPane(new RegistrationForm().getRegistration());
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        registerForm.pack();
        registerForm.setVisible(true);
    }
}
