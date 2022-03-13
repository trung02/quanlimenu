/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javaapplication1.JDBCConnection;

/**
 *
 * @author trunghuynh
 */
public class user {
    private String userName;
    private String password;
    
    
    public user(){
        
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
  
    public void userPassword (user a) {
        Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "select userName,password from user where userName = ?";
            try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getUserName());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                password = rs.getString("password");
                userName = rs.getString("userName");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void addAccount(user a){
        Connection connection = JDBCConnection.getJDBCConnection();
        String sql = "insert into user (userName,password) values (?,?)";
            try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getUserName());
            preparedStatement.setString(2, a.getPassword());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
