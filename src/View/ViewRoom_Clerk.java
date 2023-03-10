package View;

import Controller.Room_Controller;
import Model.Room;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

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
        setVisible(true);
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

    public static void main(String[] args) throws Exception{

        //create a new object
        ViewRoom_Clerk viewRoom_clerk = new ViewRoom_Clerk();
        viewRoom_clerk.setVisible(true);
        viewRoom_clerk.ViewTableData();
    }
}
