package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration_Form extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_UserReg;
    private JLabel lbl_FullName;
    private JLabel lbl_Position;
    private JLabel lbl_Email;
    private JLabel lbl_Password;
    private JLabel lbl_ConfPw;
    private JButton btn_Register;
    private JButton btn_Cansel;
    private JTextField textField1;
    private JRadioButton btn_radioManager;
    private JRadioButton btn_radioClerk;
    private JTextField txt_UserName;
    private JPasswordField txt_Password;
    private JPasswordField txt_ConfPw;

    //constructor
    public Registration_Form(){
        super();
        setTitle("User Registration Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(600,400));
        setResizable(false);

        btn_Cansel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        //create a new object
        Registration_Form registration_form = new Registration_Form();
        registration_form.setVisible(true);
    }
}
