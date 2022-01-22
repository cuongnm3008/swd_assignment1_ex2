/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Implement;

import Model.Book;
import java.util.ArrayList;
import DAO.IBookDAO;
import DBContext.DBContext;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class BookDAO implements IBookDAO{
     private static final String SELECT_ALL_BOOKS = "select * from book";
   
    @Override
    public void addBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateBook(Book book) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteBook(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Book> selectAllBooks() {
         // using try-with-resources to avoid closing resources (boiler plate code)
        List<Book> books = new ArrayList<>();
        // Step 1: Establishing a Connection
        try (Connection connection = new DBContext().getConnection();
                // Step 2:Create a statement using connection object
                PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKS);) {
            System.out.println(preparedStatement);
            // Step 3: Execute the query or update query
            ResultSet rs = preparedStatement.executeQuery();

            // Step 4: Process the ResultSet object.
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String description = rs.getString("description");
                float price = rs.getFloat("price");
                books.add(new Book(id, title, author, publisher,description,price));
            }
        } catch (Exception ex) { 
             Logger.getLogger(BookDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        return books;
    }

 
}
