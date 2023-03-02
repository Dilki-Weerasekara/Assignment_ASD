package View;

import javax.swing.*;
import java.awt.*;

public class RemoveRoom_Details extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_RemoveRoomDetails;
    private JTextField txt_Search;
    private JLabel lbl_SearchIcon;
    private JTable tb_RemoveRoom;

    //constructor
    public RemoveRoom_Details(){
        super();
        setTitle("Remove Room View Details");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);

    }

    public static void main(String[] args) {
        RemoveRoom_Details removeRoomDetails = new RemoveRoom_Details();
        removeRoomDetails.setVisible(true);
    }

}
