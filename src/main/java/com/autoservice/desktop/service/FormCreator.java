package com.autoservice.desktop.service;

import com.autoservice.desktop.ui.CustomerForm;
import com.autoservice.desktop.ui.ManagerForm;
import com.autoservice.desktop.ui.MasterForm;
import com.autoservice.desktop.ui.RegistrationForm;
import lombok.NoArgsConstructor;

import javax.swing.*;


@NoArgsConstructor
public class FormCreator {
    public void createFormLogin(String response){
        if(response.contains("MANAGER"))
        {
            JFrame loginFrame=new JFrame("Manager");
            loginFrame.setContentPane(new ManagerForm().getManagerForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        }
        else
        if(response.contains("MASTER"))
        {
            JFrame loginFrame=new JFrame("Master");
            loginFrame.setContentPane(new MasterForm().getMasterForm());
            loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            loginFrame.pack();
            loginFrame.setVisible(true);
        }

        else if (response.contains("CUSTOMER")) {
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
