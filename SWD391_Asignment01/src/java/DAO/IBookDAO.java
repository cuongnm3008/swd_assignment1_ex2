package DAO;
import Model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nguyen Manh Cuong
 */
public interface IBookDAO {
    
   List<Book> selectAllBooks();
    
   void addBook(Book book);
    
   boolean updateBook(Book book);
   
   boolean deleteBook(String id); 
}
