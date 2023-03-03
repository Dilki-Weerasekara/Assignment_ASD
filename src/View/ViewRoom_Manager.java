package View;

import Controller.Room_Controller;
import Model.Room;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ViewRoom_Manager extends JFrame{
    private JLabel lbl_RoomDetails;
    private JTextField txt_Search;
    private JTable tb_ViewRoomDetails;
    private JPanel panelMain;
    private JButton btn_search;

    //constructor
    public ViewRoom_Manager(){
        super();
        setTitle("View Room Manager");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);
        setVisible(true);
        btn_search.addActionListener(new ActionListener() {
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
                            String roomNo = txt_Search.getText().toString();
                            Room_Controller room_controller = new Room_Controller();
                            room_controller.get(roomNo);



                           //set Values
                           // room.setRoomNo(roomNo);

                        } catch (Exception e){
                            System.out.println(e.getMessage());
                        }
                    }
                });
                executorService.shutdown();

//
            }
        });
    }

    //Re call method for table view data
    public void ViewTableData() throws Exception{

        //create new object on Controller Class
        Room_Controller room_controller = new Room_Controller();

        //table columns
        String[]  colNames = {"RoomNo","Type","Size","Status","Reason","StartTime","EndTime"};

        //store data in Jtable
        List<Room> list = room_controller.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel)tb_ViewRoomDetails.getModel();
        defaultTableModel.setColumnIdentifiers(colNames);
        defaultTableModel.setRowCount(0);

        //Table UI modifications
        JTableHeader header = tb_ViewRoomDetails.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        Font font = new Font("Calibri Light  ", Font.BOLD, 14);
        header.setFont(font);

        //get values from database to the JTable
        for(Room room : list){

            String RoomNo = room.getRoomNo();
            String type = room.getType();
            int Size = room.getSize();
            String Status = room.getStatus();
            String Reason = room.getReason();

            String StartTime = room.getStartTime();
            String EndTime = room.getEndTime();

            //pass table data to the JTable View
            defaultTableModel.addRow(new Object[]{RoomNo,type,Size,Status,Reason,StartTime,EndTime});

        }



    }

    public static void main(String[] args) throws Exception {

        //create a new object
        ViewRoom_Manager viewRoomManager = new ViewRoom_Manager();
        viewRoomManager.ViewTableData();
    }
}


