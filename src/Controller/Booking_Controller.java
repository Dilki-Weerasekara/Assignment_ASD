package Controller;

import Model.Booking;

import java.sql.Connection;
import java.util.List;

public class Booking_Controller implements Booking_Interface {

    Connection con;

    //get database connection
    public Booking_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Booking booking) {

    }

    @Override
    public void update(Booking booking) {

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
