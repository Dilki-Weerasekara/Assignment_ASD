package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        btn_AddRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddRoom_Manager addRoomManager = new AddRoom_Manager();
                addRoomManager.setVisible(true);
            }
        });
        btn_UpdateRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateRoom_Form updateRoomForm = new UpdateRoom_Form();
                updateRoomForm.setVisible(true);
            }
        });

        btn_ViewRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewRoom_Manager viewRoomManager = new ViewRoom_Manager();
                try {
                    viewRoomManager.ViewTableData();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        btn_RemoveRoom.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                RemoveRoom_Manager removeRoom_manager = new RemoveRoom_Manager();
                removeRoom_manager.setVisible(true);
            }
        });

        btn_AddBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddBooking_Form addBooking_form = new AddBooking_Form();
                addBooking_form.setVisible(true);
            }
        });
        btn_UpdateBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpdateBooking_Manager updateBooking_manager = new UpdateBooking_Manager();
                updateBooking_manager.setVisible(true);
            }
        });
        btn_ViewBooking.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewBooking_Details viewBookingDetails = new ViewBooking_Details();
                try {
                    viewBookingDetails.ViewTableData();
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {

        Dashboard_Manager dashboard_manager = new Dashboard_Manager();
        dashboard_manager.setVisible(true);
    }
}
