package Model;

public class User {

    //define the variables
    int User_id;
    String Name;
    String Position;
    String Email;
    String Password;

    //add Main Constructor
    public User () {

    }
    public User(int user_id, String name, String position, String email, String password) {
        User_id = user_id;
        Name = name;
        Position = position;
        Email = email;
        Password = password;
    }

    //set Getters and Setters

    public int getUser_id() {
        return User_id;
    }

    public void setUser_id(int user_id) {
        User_id = user_id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
