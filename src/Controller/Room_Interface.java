package Controller;

import Model.Room;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public interface Room_Interface {

    //create crud operations

    //save details
    public void save (Room room);

    //update details
    public void update (Room room);

    //delete details
    public void delete(Room room);

    //view all details
    public ArrayList<Room> list();

    public ArrayList<Room> viewRoom();

    //search specific data
    public Room get(String RoomNo);
}

