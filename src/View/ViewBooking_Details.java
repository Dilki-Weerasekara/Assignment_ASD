package View;

import Controller.Booking_Controller;
import Model.Booking;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.util.List;

public class ViewBooking_Details extends JFrame{
    private JPanel panelMain;
    private JTextField txtSearch;
    private JTable tb_ViewBookingDetails;
    private JLabel lbl_SerachIcon;
    private JScrollPane tb_BookingDetails;

    //constructor
    public ViewBooking_Details(){
        super();
        setTitle("View Booking Details");
        setContentPane(panelMain);
        setMinimumSize(new Dimension(800,400));
        setResizable(false);
        setVisible(true);
    }

    //Re call method for table view data
    public void ViewTableData() throws Exception{

        //create new object on Controller Class
        Booking_Controller booking_controller = new Booking_Controller();

        //table columns
        String[]  colNames = {"StartTime","EndTime","Occasion","Period","Client","ContactNo","Notes","RoomNo"};

        //store data in Jtable
        List<Booking> list = booking_controller.list();
        DefaultTableModel defaultTableModel = (DefaultTableModel)tb_ViewBookingDetails.getModel();
        defaultTableModel.setColumnIdentifiers(colNames);
        defaultTableModel.setRowCount(0);

        //Table UI modifications
        JTableHeader header = tb_ViewBookingDetails.getTableHeader();
        header.setBackground(Color.BLACK);
        header.setForeground(Color.WHITE);
        Font font = new Font("Calibri Light  ", Font.BOLD, 14);
        header.setFont(font);

        //get values from database to the JTable
        for(Booking booking : list){

            String sTime = booking.getStartTime();
            String eTime = booking.getEndTime();
            String occasion = booking.getOccasion();
            String period = booking.getPeriod();
            String client = booking.getClient();
            int contact = booking.getContactNo();
            String Notes = booking.getNotes();
            String RoomNo = booking.getRoomNo();


            //pass table data to the JTable View
            defaultTableModel.addRow(new Object[]{sTime,eTime,occasion,period,client,contact,Notes,RoomNo});

        }



    }
    public static void main(String[] args) throws Exception{
        //create a new object
        ViewBooking_Details viewBookingDetails = new ViewBooking_Details();
        viewBookingDetails.setVisible(true);
        viewBookingDetails.ViewTableData();

    }
}
