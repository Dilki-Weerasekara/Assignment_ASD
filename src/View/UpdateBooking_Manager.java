package View;

import Controller.Booking_Controller;
import Model.Booking;
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

public class UpdateBooking_Manager extends JFrame {
    private JPanel panelMain;
    private JLabel lbl_UpdateBooking;
    private JLabel lbl_RoomNo;
    private JLabel lbl_BookingDate;
    private JLabel lbl_BookingTime;
    private JLabel lbl_Occasion;
    private JLabel lbl_ClientName;
    private JLabel lbl_ClientContact;
    private JLabel lbl_SpecialNotes;
    private JComboBox comboBox_RoomNo;
    private JTextField textField1;
    private JTextField textField2;
    private JTextArea textArea;
    private JButton btn_Update;
    private JButton btn_Cancel;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel lbl_DateFrom;
    private JLabel lbl_DateTo;
    private JLabel lbl_TimeStart;
    private JTextField txt_TimeStart;
    private JLabel lbl_TimeEnd;
    private JTextField txt_timeEnd;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JPanel panel_bookDate;
    private JPanel panel_bookTo;

    //constructor
    public UpdateBooking_Manager(){
        super();
        setTitle("Update Booking Manager");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);
        setVisible(true);

        //add Calendar
        Calendar calendar = Calendar.getInstance();

        //from Date
        JDateChooser fdateChooser = new JDateChooser(calendar.getTime());
        fdateChooser.setDateFormatString("yyyy-MM-dd");
        panel_bookDate.add(fdateChooser);

        //To Date
        JDateChooser tdateChooser = new JDateChooser(calendar.getTime());
        tdateChooser.setDateFormatString("yyyy-MM-dd");
        panel_bookTo.add(tdateChooser);


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
                Booking booking = new Booking();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {

                        try{

                            //get values
                            String roomNo = comboBox_RoomNo.getSelectedItem().toString();

                            //Booking dates
                            Date fromDate = fdateChooser.getDate();
                            Date toDate = tdateChooser.getDate();

                            //Booking Times
                            String sTime = txt_TimeStart.getText().toString();
                            String eTime = txt_timeEnd.getText().toString();

                            String occasion = comboBox1.getSelectedItem().toString();
                            String period = comboBox2.getSelectedItem().toString();
                            String client = textField1.getText().toString();
                            int contact = Integer.parseInt(textField2.getText());
                            String note = textArea.getText().toString();


                            //set values
                            booking.setRoomNo(roomNo);
                            booking.setOccasion(occasion);
                            booking.setPeriod(period);
                            booking.setClient(client);
                            booking.setContactNo(contact);
                            booking.setNotes(note);
                            booking.setStartTime(sTime);
                            booking.setEndTime(eTime);
                            booking.setFromDate(fromDate);
                            booking.setToDate(toDate);


                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

                try{
                    Booking_Controller booking_controller = new Booking_Controller();

                    //new object assign
                    booking_controller.update(booking);

                    //close the current UI
                    dispose();

                    //open next related UI
                    ViewBooking_Details viewBookingDetails = new ViewBooking_Details();
                    viewBookingDetails.setVisible(true);

                }catch(Exception ex){
                    throw new RuntimeException(ex);
                }

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
