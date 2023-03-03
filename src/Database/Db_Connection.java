package Database;
import java.sql.Connection;
import java.sql.DriverManager;


//Start Database Connection
public class Db_Connection {
    public static Connection getDb_Connection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection db = DriverManager.getConnection("jdbc:mysql://localhost/new_booking_system", "root", "");
        return db;
    }

    //check the Database connection
    public static void main(String[] args) {
        try {
            Connection con = Db_Connection.getDb_Connection();
            if (con != null) {
                System.out.println("connection successful");
            } else {
                System.out.println("connection unsuccessful");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
