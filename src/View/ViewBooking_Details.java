package View;

import javax.swing.*;
import java.awt.*;

public class ViewBooking_Details extends JFrame{
    private JPanel panelMain;
    private JTextField txtSearch;
    private JTable tb_ViewBookingDetails;
    private JLabel lbl_SerachIcon;

    //constructor
    public ViewBooking_Details(){
        super();
        setTitle("View Booking Details");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);
    }

    public static void main(String[] args) {
        //create a new object
        ViewBooking_Details viewBookingDetails = new ViewBooking_Details();
        viewBookingDetails.setVisible(true);
    }
}
