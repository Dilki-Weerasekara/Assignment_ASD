package View;

import javax.swing.*;
import java.awt.*;

public class ViewRoom_Manager extends JFrame{
    private JLabel lbl_RoomDetails;
    private JTextField txt_Search;
    private JTable tb_ViewRoomDetails;
    private JPanel panelMain;
    private JLabel lbl_searchIcon;

    //constructor
    public ViewRoom_Manager(){
        super();
        setTitle("View Room Manager");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);
    }



    public static void main(String[] args) {

        //create a new object
        ViewRoom_Manager viewRoomManager = new ViewRoom_Manager();
        viewRoomManager.setVisible(true);
    }
}


