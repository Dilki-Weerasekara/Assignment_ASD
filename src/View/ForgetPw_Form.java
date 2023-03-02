package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ForgetPw_Form extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_forgetPw;
    private JLabel lbl_Email;
    private JLabel lbl_ConfirmPw;
    private JButton btn_Update;
    private JButton btn_cansel;
    private JPasswordField txt_ConfirmPw;
    private JTextField txt_Email;
    private JPasswordField txt_NewPw;
    private JLabel lbl_NewPw;

    //constructor
    public ForgetPw_Form(){
        super();
        setTitle("Forget Password Form");
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
        //create a new object
        ForgetPw_Form forgetPw_form = new ForgetPw_Form();
        forgetPw_form.setVisible(true);
    }
}
