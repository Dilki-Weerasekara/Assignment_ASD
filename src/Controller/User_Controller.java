package Controller;

import Model.User;

import java.sql.Connection;
import java.util.List;

public class User_Controller implements User_Interface {

    Connection con;

    //get database connection
    public User_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public List<User> list() {
        return null;
    }

    @Override
    public User get(int User_id) {
        return null;
    }
}
