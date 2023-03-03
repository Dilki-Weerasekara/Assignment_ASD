package View;
import Controller.User_Controller;
import Model.User;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        btn_Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create an object from Model Class
                User user = new User();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {

                       try {
                           //get values
                           String email = txt_Email.getText().toString();
                           String password = txt_NewPw.getText().toString();
                           String confirm_password = txt_ConfirmPw.getText().toString();

                           //set values
                           user.setEmail(email);
                           user.setPassword(password);

                            if(password.equals(confirm_password)){
                                User_Controller user_controller = new User_Controller();
                                user_controller.update(user);
                                dispose();

                            }else{
                                JOptionPane.showMessageDialog(null, "Password does not match with Confirm Password","Error",JOptionPane.ERROR_MESSAGE);
                            }

                       }catch(Exception e){
                           System.out.println(e.getMessage());
                       }

                    }
                });
                executorService.shutdown();



            }
        });
    }


    public static void main(String[] args) {
        //create a new object
        ForgetPw_Form forgetPw_form = new ForgetPw_Form();
        forgetPw_form.setVisible(true);
    }
}
