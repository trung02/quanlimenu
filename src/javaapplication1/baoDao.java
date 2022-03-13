/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import manager.bao;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author trunghuynh
 */
public class baoDao {

//    public static void UpdateBao(String idB) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    public static void deleteBao(String a) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    
    public List<bao> getALLBao(){
            List<bao> listBao = new ArrayList<bao>();

            Connection connection = JDBCConnection.getJDBCConnection();
            String sql = "select * from bao";
            try {
            PreparedStatement preparedStatement= connection.prepareStatement(sql);

            //preparedStatement.setInt(1,5);

            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                bao a = new bao();

                a.setIdB(rs.getString("IdB"));
                a.setNxb(rs.getString("Nxb"));
                a.setNgay(rs.getString("NgayPhatHanh"));
                a.setSo(rs.getString("SoBanPhatHanh"));

                listBao.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
            return listBao;
    }
//    public static void selectRecords() {
//        Connection connection = JDBCConnection.getJDBCConnection();
//        
//        String sql = "select * from bao ";
//         
//        try {
//            PreparedStatement preparedStatement= connection.prepareStatement(sql);
//            
//            //preparedStatement.setInt(1,5);
//            
//            ResultSet rs = preparedStatement.executeQuery();
//            while(rs.next()){
//                System.out.println(rs.getInt("idB") + rs.getString("ngayPhatHanh")+ rs.getString("nxb")+ rs.getInt("soBanPhatHanh"));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    
    public static void insertBao(bao a){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "insert into bao (idB,ngayPhatHanh,nxb,soBanPhatHanh) values(?,?,?,?)";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getIdB());
            preparedStatement.setString(2, a.getNgay());
            preparedStatement.setString(3, a.getNxb());
            preparedStatement.setString(4, a.getSo());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void UpdateBao(bao a){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "update bao set ngayPhatHanh = ?,nxb = ?,soBanPhatHanh = ? where idB = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(4, a.getIdB());
            preparedStatement.setString(1, a.getNgay());
            preparedStatement.setString(2, a.getNxb());
            preparedStatement.setString(3, a.getSo());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void deleteBao(bao a){
        Connection connection = JDBCConnection.getJDBCConnection();
        
        String sql = "delete from bao where idB = ?";
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, a.getIdB());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
}
