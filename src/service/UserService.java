package service;

import domains.User;
import utils.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by msb on 8/25/2016.
 */
public class UserService {

    public User getUser(String username, String password) {
        User user = null;
        try {
        String query = "select * from user where username=? and password=?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> getUserList() {
        List<User> userList = new ArrayList<User>();
        try {
            String query = "select * from user";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setRole(rs.getString("role"));
                userList.add(user);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }
    public static int storeUser(User user){
        int status = 0;
        try {
            String query = "insert into user(username, password,role) values (?,?,?)";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            //Parameters starts with 1
            pstm.setString(1, user.getName());
            pstm.setString(2,user.getPassword());
            pstm.setString(3,user.getRole());
            status = pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
    public static int deleteUser(int userId){
        int status = 0;
        try{
            String query = "delete from user where id = ?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setInt(1,userId);
            status = pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }

    public User editUserById(int id){
        User u = new User();
        String query = "select * from user where id =?";
        PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
        try {
            pstm.setInt(1,id);
            ResultSet rs = pstm.executeQuery();
            while(rs.next()){
                u.setId(rs.getInt("id"));
                u.setName(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    public static int updateUser(User user){
        int status = 0;
        try{
            String query = "update user set username = ? , password = ?,role = ? where id = ?";
            PreparedStatement pstm = new DatabaseConnection().getPreparedStatement(query);
            pstm.setString(1, user.getName());
            pstm.setString(2, user.getPassword());
            pstm.setString(3, user.getRole());
            pstm.setInt(4, user.getId());
            status = pstm.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return status;
    }
}
