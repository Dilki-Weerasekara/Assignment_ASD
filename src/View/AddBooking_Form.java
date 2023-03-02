package View;

import Controller.Booking_Controller;
import Model.Booking;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


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
    private JComboBox comboBox_roomNo;
    private JLabel lbl_RoomFacilities;
    private JLabel lbl_FromDate;
    private JLabel lbl_ToDate;
    private JLabel lbl_TimeStart;
    private JLabel lbl_TimeEnd;
    private JTextField txt_stratTime;
    private JTextField txt_endTime;
    private JComboBox comboBox_AMPM;
    private JLabel lbl_RoomSize;
    private JLabel lbl_ShowSize;
    private JLabel lbl_RoomType;
    private JLabel lbl_ShowType;
    private JPanel fromDate;
    private JPanel toDate;

    public AddBooking_Form(){
        super();
        setTitle("Add Booking Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(700,500));
        setResizable(false);

        //add Calendar
        Calendar calendar = Calendar.getInstance();
        JDateChooser fdateChooser = new JDateChooser(calendar.getTime());
        fdateChooser.setDateFormatString("yyyy-MM-dd");
        fromDate.add(fdateChooser);

        JDateChooser tdateChooser = new JDateChooser(calendar.getTime());
        tdateChooser.setDateFormatString("yyyy-MM-dd");
        toDate.add(tdateChooser);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btn_Save.addActionListener(new ActionListener() {
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
                            String roomNo = comboBox_roomNo.getSelectedItem().toString();

                            //Booking dates
                            Date fromDate = fdateChooser.getDate();
                            Date toDate = tdateChooser.getDate();
                            //Booking Times
                            String sTime = txt_stratTime.toString();
                            String eTime = txt_endTime.toString();
                            String occasion = comboBox_occasion.getSelectedItem().toString();
                            String period = comboBox_AMPM.getSelectedItem().toString();
                            String client = txt_ClientName.getText().toString();
                            int contact = Integer.parseInt(txt_ClientContactNo.getText());
                            String note = txt_SpecialNotes.getText().toString();


                            //set values
                            booking.setRoomNo(roomNo);
                            booking.setOccasion(occasion);
                            booking.setPeriod(period);
                            booking.setClient(client);
                            booking.setContactNo(contact);
                            booking.setNotes(note);

                        }catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

                try{
                    Booking_Controller booking_controller = new Booking_Controller();

                    //new object assign
                    booking_controller.save(booking);

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
    public static void main(String[] args) {
        //create a  new object
        AddBooking_Form addBooking_form = new AddBooking_Form();
        addBooking_form.setVisible(true);
    }
}
