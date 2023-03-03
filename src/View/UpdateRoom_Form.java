package View;

import Controller.Room_Controller;
import Model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class UpdateRoom_Form extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_UpdateRoom;
    private JLabel lbl_RoomNo;
    private JButton btn_Update;
    private JButton btn_Cancel;
    private JLabel lbl_ShowRoomNo;
    private JComboBox comboBox1;
    private JLabel lbl_Reason;
    private JTextArea txt_Reason;
    private JComboBox comboBox2;
    private JLabel lbl_DatePeriod;
    private JLabel lbl_TimePeriod;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField txt_datefrom;
    private JLabel lbl_DateFrom;
    private JLabel lbl_DateTo;
    private JTextField txt_dateto;
    private JLabel lbl_TimeFrom;
    private JLabel lbl_TimeTo;
    private JTextField txt_timefrom;
    private JTextField txt_timeto;

    //constructor
    public UpdateRoom_Form(){
        super();
        setTitle("Update Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(750,450));
        setResizable(false);
        setVisible(true);

        //cancel button
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public void viewRoomId(){
        try {
            Room_Controller room_controller = new Room_Controller();
            ArrayList<Room> list = room_controller.viewRoom();

            for (Room room : list){
                String room_No = room.getRoomNo();
                comboBox2.addItem(room_No);
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public static void main(String[] args) {

        //create a new object
        UpdateRoom_Form updateRoomForm = new UpdateRoom_Form();
        updateRoomForm.viewRoomId();
    }
}
