package Controller;

import Model.Room;

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
    public List<Room> list();

    //search specific data
    public Room get(String RoomNo);
}

