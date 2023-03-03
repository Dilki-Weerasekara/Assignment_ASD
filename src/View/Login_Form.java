package View;

import Controller.User_Controller;
import Model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Login_Form extends JFrame{

    private JLabel lbl_Login;

        private JPanel panelMain;
        private JLabel lbl_Email;
        private JLabel lbl_Password;
        private JButton btn_cansel;
    private JTextField txt_Email;
        private JPasswordField txt_password;
        private JLabel lbl_LogoIcon;
        private JButton btn_Login;
    private JButton btn_forgetPw;
    private JButton btn_NotRegister;

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
        btn_Login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create object from Model Class
                User user = new User();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //get values
                            String email = txt_Email.getText().toString();
                            String password = txt_password.getText().toString();

                            //set values
                            user.setEmail(email);
                            user.setPassword(password);


                            //validation for Login Fields
                            if(email.isEmpty()){
                                JOptionPane.showMessageDialog(txt_Email,"Enter Valid Email Address","Error",JOptionPane.ERROR_MESSAGE);
                            }
                            else if (password.isEmpty()) {
                                JOptionPane.showMessageDialog(txt_password,"Password Wrong","Error",JOptionPane.ERROR_MESSAGE);
                            }

                        }catch(Exception e){
                            System.out.println(e.getMessage());

                        }
                    }
                });
                executorService.shutdown();

                try{

                    //create a new object
                    User_Controller user_controller = new User_Controller();
                    user_controller.login(user);

                    //close current UI
                    dispose();

                }catch(Exception ex){
                    throw new RuntimeException(ex);

                }
            }
        });
    }
    public static void main(String[] args) {

        //login form set visible
        Login_Form login_form = new Login_Form();
        login_form.setVisible(true);
    }

    }

