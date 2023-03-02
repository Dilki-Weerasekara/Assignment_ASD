package View;

import javax.swing.*;
import java.awt.*;

public class Dashboard_Clerk extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_DashboardClerk;
    private JButton btn_ViewRooms;
    private JButton btn_AddBooking;
    private JButton btn_ViewBooking;
    private JPanel panelButtons;
    private JLabel lbl_BackgroundImage;


    //constructor
    public Dashboard_Clerk(){
        super();
        setTitle("Add Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(2000,800));
        setResizable(false);
    }


    public static void main(String[] args) {
        //create a new object
        Dashboard_Clerk dashboard_clerk = new Dashboard_Clerk();
        dashboard_clerk.setVisible(true);
    }
}
