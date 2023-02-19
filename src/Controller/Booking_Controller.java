package Controller;

import Model.Booking;
import com.sun.source.tree.TryTree;

import javax.swing.*;
import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public class Booking_Controller implements Booking_Interface {

    Connection con;

    //get database connection
    public Booking_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Booking booking) {

        try{
            //insert query
            String query = "INSERT INTO booking (Booking_id, FromDate, ToDate, StartTime, EndTime, " +
                    "Occasion, Period, Client, ContactNo, Notes, RoomNo) " +
                    "VALUES ('"+booking.getBooking_id()+"','"+booking.getFromDate()+"','"+booking.getToDate()+"','"+booking.getStartTime()+"','"+booking.getEndTime()+"','"+booking.getOccasion()+"'," +
                    "'"+booking.getPeriod()+"','"+booking.getClient()+"','"+booking.getContactNo()+"','"+booking.getNotes()+"','"+booking.getRoomNo()+"')";

            //set query
            Statement statement = con.createStatement();
            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null,"Successfully Saved","information",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(Booking booking) {
        try{

            //update query
            String query = "UPDATE booking SET Booking_id='"+booking.getBooking_id()+"',FromDate='"+booking.getFromDate()+"',ToDate='"+booking.getToDate()+"',StartTime='"+booking.getStartTime()+"'," +
                    "EndTime='"+booking.getEndTime()+"',Occasion='"+booking.getOccasion()+"',Period='"+booking.getPeriod()+"',Client='"+booking.getClient()+"',ContactNo='"+booking.getContactNo()+"'," +
                    "Notes='"+booking.getNotes()+"',RoomNo='"+booking.getRoomNo()+"' WHERE Booking_id='"+booking.getBooking_id()+"'";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null,"Successfully Updated","information",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Booking booking) {

    }

    @Override
    public List<Booking> list() {
        return null;
    }

    @Override
    public Booking get(int Booking_id) {
        return null;
    }
}
