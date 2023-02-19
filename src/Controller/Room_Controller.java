package Controller;
import Model.Room;
import java.sql.Connection;

public class Room_Controller {
    Connection con;

    //get database connection
    public Room_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }


}
