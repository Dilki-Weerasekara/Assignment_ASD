package Controller;

import Model.Room;

import java.util.List;

public interface Room_Interface {
    public void save (Room room);
    public void update (Room room);
    public void delete(Room room);
    public List<Room> list();
    public Room get(int roomNo);
}
