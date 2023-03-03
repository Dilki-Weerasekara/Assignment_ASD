package Controller;

import Model.Room;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Room_Controller implements Room_Interface {
    Connection con;

    //get database connection
    public Room_Controller() throws Exception {
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Room room) {

        try {
            //insert query
            String query = "INSERT INTO room(RoomNo, Type, Size, Status, Reason, FromDate, ToDate, StartTime, EndTime) " +
                    "VALUES ('" + room.getRoomNo() + "','" + room.getType() + "','" + room.getSize() + "','" + room.getStatus() + "'," +
                    "'" + room.getReason() + "','" + room.getFromDate() + "','" + room.getToDate() + "','" + room.getStartTime() + "','" + room.getEndTime() + "')";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null, "Successfully Saved", "information", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void update(Room room) {

        try {
            //update query
            String query = "UPDATE room SET RoomNo='" + room.getRoomNo() + "',Type='" + room.getType() + "',Size='" + room.getSize() + "',Status='" + room.getStatus() + "'," +
                    "Reason='" + room.getReason() + "',FromDate='" + room.getFromDate() + "',ToDate='" + room.getToDate() + "',StartTime='" + room.getStartTime() + "'," +
                    "EndTime='" + room.getEndTime() + "' WHERE RoomNo = '" + room.getRoomNo() + "'";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null, "Successfully Updated", "information", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Room room) {

        try {
            //delete query
            String query = "DELETE FROM `room` WHERE RoomNo = '" + room.getRoomNo() + "'";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null, "Successfully Deleted", "information", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public ArrayList<Room> list() {

        //create new Object in ArrayList
        ArrayList<Room> viewList = new ArrayList<>();


        try {
            //view all details
            String query = "SELECT * FROM room ";

            //set query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            //create new object
            Room roomView;

            //retrieve data row by row
            while (resultSet.next()) {
                roomView = new Room(resultSet.getString("RoomNo"), resultSet.getString("Type"), resultSet.getInt("Size"),
                        resultSet.getString("Status"), resultSet.getString("Reason"), resultSet.getString("StartTime"), resultSet.getString("EndTime"));

                viewList.add(roomView);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return viewList;
    }

    @Override
    public ArrayList<Room> viewRoom() {
        //create new Object in ArrayList
        ArrayList<Room> viewList = new ArrayList<>();


        try {
            //view all details
            String query = "SELECT RoomNo FROM room";

            //set query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            //create new object
            Room roomView;

            //retrieve data row by row
            while (resultSet.next()) {
                roomView = new Room(resultSet.getString("RoomNo"));

                viewList.add(roomView);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return viewList;
    }


    //search data using Room No
    @Override
    public Room get(String RoomNo) {

        //create object
        Room room = null;

        try {
            //search query via room no
            String query = "SELECT * FROM room WHERE RoomNo = '" + RoomNo + "'";

            //set query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            try {
                    if (resultSet.isBeforeFirst()) {
                            try{
                                    while (resultSet.next()){
                                        String roomNo = resultSet.getString("RoomNo");
                                        String 	Type = resultSet.getString("Type");
                                        Integer Size = resultSet.getInt("Size");
                                        String Status = resultSet.getString("Status");
                                        String Reason = resultSet.getString("Reason");
                                        Date FromDate = resultSet.getDate("FromDate");
                                        Date ToDate = resultSet.getDate("ToDate");
                                        String StartTime = resultSet.getString("StartTime");
                                        String EndTime = resultSet.getString("EndTime");

                                        //pass values to model class constructor
                                        room = new Room(roomNo,Type,Size,Status,Reason,FromDate,ToDate,StartTime,EndTime);

                                    }

                            }catch (SQLException sqlException){

                            }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Sorry,No Data Matched", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }

            } catch (SQLException sqlException) {

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return room;
    }
}
