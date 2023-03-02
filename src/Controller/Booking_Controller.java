package Controller;

import Model.Booking;

import java.sql.*;
import java.util.ArrayList;
import javax.swing.*;


public class Booking_Controller implements Booking_Interface {

    Connection con;

    //get database connection
    public Booking_Controller() throws Exception {
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Booking booking) {

        try {

            //insert query
            String query = "INSERT INTO booking (Booking_id, FromDate, ToDate, StartTime, EndTime, " +
                    "Occasion, Period, Client, ContactNo, Notes, RoomNo) " +
                    "VALUES ('" + booking.getBooking_id() + "','" + booking.getFromDate() + "','" + booking.getToDate() + "','" + booking.getStartTime() + "','" + booking.getEndTime() + "','" + booking.getOccasion() + "'," +
                    "'" + booking.getPeriod() + "','" + booking.getClient() + "','" + booking.getContactNo() + "','" + booking.getNotes() + "','" + booking.getRoomNo() + "')";

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
    public void update(Booking booking) {
        try {

            //update query
            String query = "UPDATE booking SET Booking_id='" + booking.getBooking_id() + "',FromDate='" + booking.getFromDate() + "',ToDate='" + booking.getToDate() + "',StartTime='" + booking.getStartTime() + "'," +
                    "EndTime='" + booking.getEndTime() + "',Occasion='" + booking.getOccasion() + "',Period='" + booking.getPeriod() + "',Client='" + booking.getClient() + "',ContactNo='" + booking.getContactNo() + "'," +
                    "Notes='" + booking.getNotes() + "',RoomNo='" + booking.getRoomNo() + "' WHERE Booking_id='" + booking.getBooking_id() + "'";

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
    public void delete(Booking booking) {

        try {
            //delete query
            String query = "DELETE FROM booking WHERE Booking_id='" + booking.getBooking_id() + "'";

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
    public ArrayList<Booking> list() {

        //create new object in arrayList
        ArrayList<Booking> viewList = new ArrayList<>();

        try {
            //view all details query
            String query = "SELECT * FROM booking ";

            //set query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            Booking bookingView;

            while (resultSet.next()) {

                bookingView = new Booking(resultSet.getInt("Booking_id "), resultSet.getDate("FromDate"),
                        resultSet.getDate("ToDate"), resultSet.getString("StartTime"), resultSet.getString("EndTime"),
                        resultSet.getString("Occasion"), resultSet.getString("Period"), resultSet.getString("Client"),
                        resultSet.getInt("ContactNo"), resultSet.getString("Notes"), resultSet.getString("RoomNo"));

                viewList.add(bookingView);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return viewList;
    }

    // search using ID
    @Override
    public Booking get(int Booking_id) {

        Booking booking = null;
        try {
            //search data using ID
            String query = "SELECT * FROM booking WHERE Booking_id = " + Booking_id + "";

            //set the query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            try{
                    if(resultSet.isBeforeFirst()){
                            try{
                                    while (resultSet.next()){
                                            int booking_id = resultSet.getInt("Booking_id");
                                            Date FromDate = resultSet.getDate("FromDate");
                                            Date ToDate = resultSet.getDate("ToDate");
                                            String StartTime = resultSet.getString("StartTime");
                                            String EndTime = resultSet.getString("EndTime");
                                            String Occasion = resultSet.getString("Occasion");
                                            String Period = resultSet.getString("Period");
                                            String 	Client = resultSet.getString("Client");
                                            Integer ContactNo = resultSet.getInt("ContactNo");
                                            String Notes = resultSet.getString("Notes");
                                            String RoomNo = resultSet.getString("RoomNo");

                                            booking = new Booking(booking_id,FromDate,ToDate,StartTime,EndTime,Occasion,Period,Client,ContactNo,Notes,RoomNo);
                                    }
                            }catch (SQLException sqlException){

                            }
                    }else{
                        JOptionPane.showMessageDialog(null, "Sorry,No Data Matched", "Information", JOptionPane.INFORMATION_MESSAGE);
                    }
            }catch(SQLException sqlException){

            }

        } catch(Exception e){
           e.printStackTrace();
        }

        return booking;
    }
}
