package View;

import Controller.User_Controller;
import Model.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private JTextField txt_Username;
    private JTextField txt_Email;
    private JPasswordField txt_Password;
    private JPasswordField txt_ConfPw;
    private JComboBox comboBoxPosision;

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
        btn_Register.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create an object from Model Class
                User user = new User();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //get values
                            String fullName = txt_Username.getText().toString();
                            String position = comboBoxPosision.getSelectedItem().toString();
                            String email = txt_Email.getText().toString();
                            String password = txt_Password.getText().toString();
                            String cpassword = txt_ConfPw.getText().toString();

                            user.setName(fullName);
                            user.setEmail(email);
                            user.setPassword(password);
                            user.setPosition(position);
                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();



                try {
                    User_Controller userController = new User_Controller();
                    userController.save(user);

                    //close the current UI
                    dispose();

                    //open next related UI
                    Login_Form login_form = new Login_Form();
                    login_form.setVisible(true);

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

    public static void main(String[] args) {
        //create a new object
        Registration_Form registration_form = new Registration_Form();
        registration_form.setVisible(true);
    }
}
