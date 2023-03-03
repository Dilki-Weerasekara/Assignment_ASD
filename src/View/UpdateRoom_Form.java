package View;

import Controller.Room_Controller;
import Model.Room;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private JComboBox comboBox3;
    private JPanel panel_datefrom;
    private JPanel panel_dateto;

    //constructor
    public UpdateRoom_Form(){
        super();
        setTitle("Update Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(750,450));
        setResizable(false);
        setVisible(true);

        //add Calendar
        Calendar calendar = Calendar.getInstance();

        //from Date
        JDateChooser fdateChooser = new JDateChooser(calendar.getTime());
        fdateChooser.setDateFormatString("yyyy-MM-dd");
        panel_datefrom.add(fdateChooser);

        //To Date
        JDateChooser tdateChooser = new JDateChooser(calendar.getTime());
        tdateChooser.setDateFormatString("yyyy-MM-dd");
        panel_dateto.add(tdateChooser);


        //cancel button
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_Update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create an object from Model Class
                Room room = new Room();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //get values
                            String roomNo = comboBox2.getSelectedItem().toString();
                            String roomType = comboBox3.getSelectedItem().toString();
                            int roomSize = Integer.parseInt(textField2.getText());
                            String currentStatus = comboBox1.getSelectedItem().toString();
                            String reason = txt_Reason.getText().toString();

                            //Room dates
                            Date fromDate = fdateChooser.getDate();
                            Date toDate = tdateChooser.getDate();

                            //Room Times

                            String startTime = txt_timefrom.getText().toString();
                            String endTime = txt_timeto.getText().toString();


                            room.setRoomNo(roomNo);
                            room.setType(roomType);
                            room.setSize(roomSize);
                            room.setStatus(currentStatus);
                            room.setReason(reason);
                            room.setStartTime(startTime);
                            room.setEndTime(endTime);
                            room.setFromDate(fromDate);
                            room.setToDate(toDate);


                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

                try {
                    //create new object
                    Room_Controller room_controller = new Room_Controller();
                    room_controller.update(room);

                    //close the current UI
                    dispose();


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
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
