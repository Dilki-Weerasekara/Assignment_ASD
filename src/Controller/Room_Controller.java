package Controller;
import Model.Room;

import javax.swing.*;
import java.sql.Connection;
import java.util.List;
import java.sql.Statement;
import java.sql.SQLException;

public class Room_Controller implements Room_Interface{
    Connection con;

    //get database connection
    public Room_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Room room){
        
        try{
            //insert query
            String query = "INSERT INTO room(RoomNo, Type, Size, Status, Reason, FromDate, ToDate, StartTime, EndTime) " +
                    "VALUES ('"+room.getRoomNo()+"','"+room.getType()+"','"+room.getSize()+"','"+room.getStatus()+"'," +
                    "'"+room.getReason()+"','"+room.getFromDate()+"','"+room.getToDate()+"','"+room.getStartTime()+"','"+room.getEndTime()+"')";

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
    public void update(Room room) {

        try{
            //update query
            String query = "UPDATE `room` SET `RoomNo`='"+room.getRoomNo()+"',`Type`='"+room.getType()+"',`Size`='"+room.getSize()+"',`Status`='"+room.getStatus()+"'," +
                    "`Reason`='"+room.getReason()+"',`FromDate`='"+room.getFromDate()+"',`ToDate`='"+room.getToDate()+"',`StartTime`='"+room.getStartTime()+"'," +
                    "`EndTime`='"+room.getEndTime()+"' WHERE RoomNo = '"+room.getRoomNo()+"'";

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
    public void delete(Room room) {

        try{
            //delete query
            String query = "DELETE FROM `room` WHERE RoomNo = '"+room.getRoomNo()+"'";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null,"Successfully Deleted","information",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public List<Room> list() {
        return null;
    }

    @Override
    public Room get(String RoomNo) {
        return null;
    }
}
