package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class AddBooking_Form extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_RoomNo;
    private JLabel lbl_BookingDate;
    private JLabel lbl_BookingTime;
    private JButton btn_Save;
    private JLabel lbl_Note;
    private JLabel lbl_ContactNo;
    private JLabel lbl_ClientName;
    private JLabel lbl_Occasion;
    private JButton cancelButton;
    private JLabel lbl_ShowRoomNo;
    private JLabel lbl_ShoeRoomType;
    private JComboBox comboBox_occasion;
    private JTextField txt_ClientName;
    private JTextField txt_ClientContactNo;
    private JTextArea txt_SpecialNotes;
    private JComboBox comboBox1;
    private JLabel lbl_RoomFacilities;
    private JLabel lbl_FromDate;
    private JTextField textField1;
    private JTextField textField3;
    private JLabel lbl_ToDate;
    private JLabel lbl_TimeStart;
    private JLabel lbl_TimeEnd;
    private JTextField textField4;
    private JTextField textField5;
    private JComboBox comboBox2;
    private JLabel lbl_RoomSize;
    private JLabel lbl_ShowSize;
    private JLabel lbl_RoomType;
    private JLabel lbl_ShowType;

    public AddBooking_Form(){
        super();
        setTitle("Add Booking Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }
    public static void main(String[] args) {
        //create a  new object
        AddBooking_Form addBooking_form = new AddBooking_Form();
        addBooking_form.setVisible(true);
    }
}
