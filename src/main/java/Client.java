import com.autoservice.desktop.ui.Login;

import javax.swing.*;

import static com.autoservice.desktop.service.FormCreator.loginFrame;

public class Client {

    /**
     * Launch the application.
     */
//    public static JFrame loginFrame=new JFrame("Login");
    public static void main(String[] args) {
        loginFrame=new JFrame("Login");
        loginFrame.setContentPane(new Login().getJpanel());
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.pack();
        loginFrame.setVisible(true);
    }
}
