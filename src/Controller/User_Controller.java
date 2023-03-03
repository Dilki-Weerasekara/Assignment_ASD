package Controller;

import Model.User;
import View.Dashboard_Clerk;
import View.Dashboard_Manager;

import javax.swing.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;


public class User_Controller implements User_Interface {

    Connection con;

    //get database connection
    public User_Controller() throws Exception{
        this.con = Database.Db_Connection.getDb_Connection();
    }

    @Override
    public void save(User user) {

        try{
            //insert query
            String query = "INSERT INTO user(User_id, Name, Position, Email, Password) " +
                    "VALUES ('"+user.getUser_id()+"','"+user.getName()+"','"+user.getPosition()+"','"+user.getEmail()+"','"+user.getPassword()+"')";

            //set query
            Statement statement = con.createStatement();
            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null,"Successfully Registered","information",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void update(User user) {

        try{
            //update query
            String query = "UPDATE user SET Password ='"+user.getPassword()+"' WHERE User_id = '"+user.getUser_id()+"'";

            //set query
            Statement statement = con.createStatement();

            //execute query
            statement.execute(query);

            //Show message dialog
            JOptionPane.showMessageDialog(null,"Successfully Updated","information",JOptionPane.INFORMATION_MESSAGE);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void login(User user){
        try{
            //select query
            String query = "SELECT * FROM `user` WHERE  Email = '"+user.getEmail()+"' AND Password = '"+user.getPassword()+"' ";

            //set query
            PreparedStatement preparedStatement = con.prepareStatement(query);

            //execute query
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()){

                //check position vise
                if (resultSet.getString("Position").equals("Manager")){
                    Dashboard_Manager dashboard_manager = new Dashboard_Manager();
                    dashboard_manager.setVisible(true);
                } else {
                    Dashboard_Clerk dashboard_clerk = new Dashboard_Clerk();
                    dashboard_clerk.setVisible(true);
                }
            }




        }catch(Exception e ){
            e.printStackTrace();
        }
    }
}
