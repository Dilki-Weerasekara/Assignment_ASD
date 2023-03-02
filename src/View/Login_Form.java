package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login_Form extends JFrame{

    private JLabel lbl_Login;

        private JPanel panelMain;
        private JLabel lbl_Email;
        private JLabel lbl_Password;
        private JButton btn_cansel;
        private JFormattedTextField dontHaveAnAccountFormattedTextField;
        private JTextField txt_Username;
        private JPasswordField txt_password;
        private JLabel lbl_LogoIcon;
        private JButton btn_Logic;

        //constructor
    public Login_Form(){
        super();
        setTitle("Login Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(600,400));
        setResizable(false);
        btn_cansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        Login_Form login_form = new Login_Form();
        login_form.setVisible(true);
    }

    }

