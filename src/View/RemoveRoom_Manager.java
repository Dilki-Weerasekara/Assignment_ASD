package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RemoveRoom_Manager extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_RemoveRoom;
    private JLabel lbl_RoomNo;
    private JComboBox comboBox_RoomNO;
    private JLabel lbl_Reason;
    private JTextArea txt_Reason;
    private JButton btn_Delete;
    private JButton btn_Cancel;

    public RemoveRoom_Manager(){
        super();
        setTitle("Remove Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(600,400));
        setResizable(false);
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        //create a new object
        RemoveRoom_Manager removeRoom_manager = new RemoveRoom_Manager();
        removeRoom_manager.setVisible(true);
    }
}
