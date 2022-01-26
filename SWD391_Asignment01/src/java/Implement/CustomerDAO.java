package Implement;

import Model.Customer;
import DAO.ICustomerDAO;
import DBContext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class CustomerDAO implements ICustomerDAO {

    // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();

    @Override
    public Customer findCustomerbyUserNameAndPassword(String username, String password) {
        try {
            String sqlQuery = "SELECT a.Username,a.Password,a.RoleId,c.Id,c.AccountId,c.Fullname,c.Email,c.Phone \n"
                    + "FROM dbo.Account AS a JOIN dbo.Customer AS c ON c.AccountId = a.Id\n"
                    + "WHERE a.Username = ? AND a.Password = ?";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setString(1, username);
            ps.setString(2, password);
            rs = ps.executeQuery();
            Customer user = null;
            while (rs.next()) {
                user = new Customer(rs.getString(1),
                        rs.getString(2),
                        rs.getInt(3),
                        rs.getInt(4),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8));
            }
            return user;
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public Customer findByUserName(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
      @Override
    public void addcustomer(Customer customer) {
        try {
            String sqlQuery = "INSERT INTO dbo.Customer (AccountId,Email,Fullname,Phone) VALUES(?,?,?,?)";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, customer.getAccountId());
            ps.setString(2, customer.getEmail());
            ps.setString(3, customer.getFullname());
            ps.setString(4, customer.getPhone());
            rs = ps.executeQuery();
        } catch (Exception ex) {
            Logger.getLogger(CustomerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

}
