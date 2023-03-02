package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddRoom_Manager extends JFrame{
    private JPanel panelMain;
    private JLabel lbl_AddRoom;
    private JLabel lbl_RoomNo;
    private JLabel lbl_RoomType;
    private JLabel lbl_RoomSize;
    private JButton btn_Save;
    private JButton btn_Cancel;
    private JTextField txt_RoomNo;
    private JTextField txt_RoomSize;
    private JRadioButton btn_radioComputLab;
    private JRadioButton btn_radioTutorial;
    private JRadioButton btn_radioLecture_Theatre;
    private JLabel lbl_CurrentStatus;
    private JComboBox comboBox_status;
    private JLabel lbl_Reason;
    private JTextField txt_Reason;
    private JLabel lbl_Date;
    private JLabel lbl_From;
    private JTextField textField1;
    private JLabel lbl_To;
    private JTextField textField2;
    private JLabel lbl_TimePeriod;
    private JTextField txt_Start;
    private JTextField txt_End;
    private JLabel lbl_End;
    private JLabel lbl_Start;

    public AddRoom_Manager(){
        super();
        setTitle("Add Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(900,500));
        setResizable(false);
        setVisible(true);
        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        AddRoom_Manager addRoomManager = new AddRoom_Manager();
    }

}
