package View;

import javax.swing.*;
import java.awt.*;

public class ViewRoom_Clerk extends JFrame{
    private JLabel lbl_ViewRoom;
    private JPanel panelMain;
    private JTextField txt_Search;
    private JLabel lbl_Search;
    private JTable tb_ViewRoomDetails;


    //constructor
    public ViewRoom_Clerk(){
        super();
        setTitle("View Room Clerk");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);
    }

    public static void main(String[] args) {

        //create a new object
        ViewRoom_Clerk viewRoom_clerk = new ViewRoom_Clerk();
        viewRoom_clerk.setVisible(true);
    }
}
