package View;

import Controller.Booking_Controller;
import Controller.Room_Controller;
import Model.Booking;
import Model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateBooking_Manager extends JFrame {
    private JPanel panelMain;
    private JLabel lbl_UpdateBooking;
    private JLabel lbl_RoomNo;
    private JLabel lbl_Facilities;
    private JLabel lbl_BookingDate;
    private JLabel lbl_BookingTime;
    private JLabel lbl_Occasion;
    private JLabel lbl_ClientName;
    private JLabel lbl_ClientContact;
    private JLabel lbl_SpecialNotes;
    private JComboBox comboBox_RoomNo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea1;
    private JButton btn_Update;
    private JButton btn_Cancel;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel lbl_DateFrom;
    private JTextField txt_FromDate;
    private JLabel lbl_DateTo;
    private JTextField textField5;
    private JLabel lbl_TimeStart;
    private JTextField txt_TimeStart;
    private JLabel lbl_TimeEnd;
    private JTextField textField6;
    private JComboBox comboBox1;
    private JComboBox comboBox2;

    //constructor
    public UpdateBooking_Manager(){
        super();
        setTitle("Update Booking Manager");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);
        setVisible(true);
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });


    }

    public void viewRoomId(){
        try {
            Booking_Controller booking_controller = new Booking_Controller();
            ArrayList<Room> list = booking_controller.viewBooking();

            for (Room room : list){
                String room_No = room.getRoomNo();
                comboBox_RoomNo.addItem(room_No);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


    public static void main(String[] args) {

        //create a new object
        UpdateBooking_Manager updateBooking_manager = new UpdateBooking_Manager();
        updateBooking_manager.viewRoomId();
    }
}
