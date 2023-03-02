package View;

import Controller.Room_Controller;
import Controller.User_Controller;
import Model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
    private JComboBox comboBox_Type;

    //constructor
    public AddRoom_Manager(){
        super();
        setTitle("Add Room Form");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(900,500));
        setResizable(false);

        btn_Cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        btn_Save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //create an object from Model Class
                Room room = new Room();

                //concurrency
                ExecutorService executorService = Executors.newSingleThreadExecutor();

                executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        try{
                            //get values
                            String roomNo = txt_RoomNo.getText().toString();
                            String roomType = comboBox_Type.getSelectedItem().toString();
                            int roomSize = Integer.parseInt(txt_RoomSize.getText());
                            String currentStatus = comboBox_status.getSelectedItem().toString();
                            String reason = txt_Reason.getText().toString();

                            //Date and Time get



                            room.setRoomNo(roomNo);
                            room.setType(roomType);
                            room.setSize(roomSize);
                            room.setStatus(currentStatus);
                            room.setReason(reason);

                            //Date and Time set

                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

                try {
                    //create new object
                    Room_Controller room_controller = new Room_Controller();
                    room_controller.save(room);

                    //close the current UI
                    dispose();

                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public static void main(String[] args) {
        //create a new object
        AddRoom_Manager addRoomManager = new AddRoom_Manager();
        addRoomManager.setVisible(true);
    }

}
