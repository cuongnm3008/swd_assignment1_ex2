/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import DAO.ICartDAO;
import DBContext.DBContext;
import Model.Cart;
import Model.CartItemViewModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class CartDAO implements ICartDAO {

    // Khai báo các thành phần xử lý DB
    Connection cnn;// Kết nối CSDL
    PreparedStatement ps; // Thực hiện câu lệnh SQL
    ResultSet rs; // Lưu trữ và xử lý dư liệu
    DBContext db = new DBContext();
    
    private static final String SELECT_CART_BY_CUSTOMERID = "SELECT c.Id,b.Title,b.Author,b.Publisher,c.TotalPrice,c.Quantity FROM dbo.Cart AS c JOIN dbo.Book AS b ON b.Id = c.BookId WHERE c.CustomerId = ?";
    
    @Override
    public void addItemToCart(Cart cart) {
        try {
            String sqlQuery = "INSERT INTO dbo.Cart(CustomerId,BookId,Quantity,TotalPrice)VALUES(?,?,?,?)";
            cnn = new DBContext().getConnection();
            ps = cnn.prepareStatement(sqlQuery);
            ps.setInt(1, cart.getCustomerId());
            ps.setInt(2, cart.getBookId());
            ps.setInt(3, cart.getQuantity());
            ps.setFloat(4, cart.getTotalPrice());
            ps.executeUpdate();
        } catch (Exception e) {
            try {
                throw e;
            } catch (Exception ex) {
                Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public int getTotalItemOnCartByCustomerID(int customerid) {
        // Step 1: Establishing a Connection
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT SUM(Quantity) FROM dbo.Cart WHERE CustomerId = ?");) {
            preparedStatement.setInt(1, customerid);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            int total = 0;
            while (rs.next()) {
                total = rs.getInt(1);
            }
            return total;
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    
    @Override
    public List<CartItemViewModel> getAllCartItems(int customerid) {
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_CART_BY_CUSTOMERID);) 
        {
            preparedStatement.setInt(1, customerid);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();
            // Step 4: Process the ResultSet object.
            List<CartItemViewModel> listItem = new ArrayList<>();
            while (rs.next()) {
                int cartId = rs.getInt(1);
                String bookName = rs.getString(2);
                String author = rs.getString(3);
                String publisher = rs.getString(4);
                float totalPrice = rs.getFloat(5);
                int quantity = rs.getInt(6);
                listItem.add(new CartItemViewModel(cartId, bookName, author, publisher, totalPrice, quantity));
            }
            return listItem;
        } catch (Exception ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
