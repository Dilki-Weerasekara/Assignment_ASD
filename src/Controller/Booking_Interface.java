package Controller;
import Model.Booking;

import java.awt.print.Book;
import java.util.List;

public interface Booking_Interface {

    //create crud operations

    //save details
    public void save(Booking booking);

    //update details
    public void update(Booking booking);

    //delete details
    public void delete(Booking booking);

    //view all details
    public List<Booking> list();

    //search specific data
    public Booking get(int Booking_id);

}
