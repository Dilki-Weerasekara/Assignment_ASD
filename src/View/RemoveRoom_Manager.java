package View;

import Controller.Room_Controller;
import Model.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
        btn_Delete.addActionListener(new ActionListener() {
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
                            String roomNo = comboBox_RoomNO.getSelectedItem().toString();
                            String Reason = txt_Reason.getText().toString();

                            //set Values
                            room.setRoomNo(roomNo);
                            room.setReason(Reason);

                            }catch(Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

                try {
                    //create new object
                    Room_Controller room_controller = new Room_Controller();
                    room_controller.delete(room);

                    //close the current UI
                    dispose();

                    //next UI
                    RemoveRoom_Details removeRoomDetails = new RemoveRoom_Details();
                    removeRoomDetails.setVisible(true);


                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    //view room id
    public void ViewroomNo(){
        try{
            Room_Controller room_controller = new Room_Controller();
            ArrayList<Room>list = room_controller.viewRoom();

            for (Room room : list){
                String room_No = room.getRoomNo();
                comboBox_RoomNO.addItem(room_No);
            }

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        //create a new object
        RemoveRoom_Manager removeRoom_manager = new RemoveRoom_Manager();
        removeRoom_manager.setVisible(true);
        removeRoom_manager.ViewroomNo();
    }
}
