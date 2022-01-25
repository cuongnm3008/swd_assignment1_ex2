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

    Book getBookById(int bookId);

    void addBook(Book book);

    boolean updateBook(Book book);

    boolean deleteBook(String id);

}
