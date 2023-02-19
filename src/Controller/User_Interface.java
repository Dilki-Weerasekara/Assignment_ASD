package Controller;

import Model.User;
import java.util.List;

public interface User_Interface {

    //create crud operations

    //save details
    public void save(User user);

    //update details
    public void update(User user);

    //delete details
    public void delete(User user);

    //View all details
    public List<User> list();

    //search details
    public User get(int User_id);


}
