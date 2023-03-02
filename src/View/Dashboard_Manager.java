package View;

import javax.swing.*;
import java.awt.*;

public class Dashboard_Manager extends JFrame{
    private JPanel panelMain;
    private JPanel panelButtons;
    private JButton btn_AddRoom;
    private JButton btn_UpdateRoom;
    private JButton btn_ViewRoom;
    private JButton btn_RemoveRoom;
    private JButton btn_RemoveRoomRecords;
    private JButton btn_AddBooking;
    private JButton btn_UpdateBooking;
    private JButton btn_ViewBooking;
    private JPanel panelBackground;
    private JLabel lbl_BackgroundImage;
    private JLabel lbl_DashboardManager;

    //constructor
    public Dashboard_Manager(){
        super();
        setTitle("Dashboard of Manager");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(2000,800));
        setResizable(false);
    }

    public static void main(String[] args) {

        Dashboard_Manager dashboard_manager = new Dashboard_Manager();
        dashboard_manager.setVisible(true);
    }
}
