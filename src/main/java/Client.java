import com.autoservice.desktop.ui.Login;

import javax.swing.*;

public class Client {

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        JFrame loginFrame=new JFrame("Login");
        loginFrame.setContentPane(new Login().jpanel);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }
}
