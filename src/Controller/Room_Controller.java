package Controller;
import Model.Room;
import java.sql.Connection;
import java.util.List;

public class Room_Controller implements Room_Interface{
    Connection con;

    //get database connection
    public Room_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(Room room) {

    }

    @Override
    public void update(Room room) {

    }

    @Override
    public void delete(Room room) {

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
