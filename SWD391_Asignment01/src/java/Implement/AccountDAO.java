/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import DAO.IAccountDAO;
import DBContext.DBContext;
import Model.Account;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class AccountDAO implements IAccountDAO{
     // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    @Override
    public void createAccount(String username, String password) {
        try {
            String sqlQuery = "INSERT INTO dbo.Account (Username,Password,RoleId)VALUES(?,?,1)";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public int getIdAccount(String Username) {  
        try {
            String sqlQuery = "SELECT * FROM dbo.Account WHERE Username = ? ";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, Username);
            rs = ps.executeQuery();
            Account acc = null;
            while (rs.next()) {
            return rs.getInt(1);
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

//    @Override
//    public boolean checkAccountExist(String username, String password) {
//        try {
//            String sqlQuery = "SELECT * FROM dbo.Account WHERE Username = ? AND Password = ?";
//            cnn = new DBContext().getConnection();
//            ps = cnn.prepareStatement(sqlQuery);
//            ps.setString(1, username);
//            ps.setString(1, password);
//            rs = ps.executeQuery();
//            while (rs.next()) {
//                String username;
//                String password ; 
//                
//            }
//        } catch (Exception ex) {
//            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }

    @Override
    public Account getAccountByUsername(String username) {
         try {
            String sqlQuery = "SELECT * FROM dbo.Account WHERE Username = ? ";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(2), rs.getString(3));
            }
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
