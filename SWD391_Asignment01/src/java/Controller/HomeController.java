package Controller;

import DAO.IAccountDAO;
import Implement.BookDAO;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import DAO.IBookDAO;
import DAO.ICartDAO;
import DAO.ICustomerDAO;
import Implement.AccountDAO;
import Implement.CartDAO;
import Implement.CustomerDAO;
import Model.Book;
import Model.Customer;
import Model.Cart;
import Ultil.SessionUltil;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nguyen Manh Cuong
 */
@WebServlet(name = "HomeController", urlPatterns = {"/home", "/login", "/register", "/logout", "/add-to-cart"})
public class HomeController extends HttpServlet {

    IBookDAO _bookService;
    ICustomerDAO _customerService;
    ICartDAO _cartService;
    IAccountDAO _accService;
    private static final long serialVersionUID = 1L;

    @Override
    public void init() {
        _bookService = new BookDAO();
        _customerService = new CustomerDAO();
        _cartService = new CartDAO();
        _accService = new AccountDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/login":
                    String message = "";
                    if (request.getParameterMap().containsKey("message")) {
                        message = request.getParameter("message");
                        request.setAttribute("message", message);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
                        dispatcher.forward(request, response);
                        return;
                    }
                    RequestDispatcher dispatcher = request.getRequestDispatcher("views/login.jsp");
                    dispatcher.forward(request, response);
                    break;
                case "/register":
                    register(request, response);
                    break;
                case "/logout":
                    SessionUltil.getInstance().removeValue(request, "USERMODEL");
                    response.sendRedirect(request.getContextPath() + "/home"); // logout success
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex
            );

        }
    }

    private void listBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {
        Customer user = (Customer) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (user != null) {
            int totalItem = _cartService.getTotalItemOnCartByCustomerID(user.getId());
            request.setAttribute("totalItem", totalItem);
        }
        List<Book> listBook = _bookService.selectAllBooks();
        request.setAttribute("listBook", listBook);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/home.jsp");
        dispatcher.forward(request, response);
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {
        String username = "", password = "";
        String urlSend = "";
        if (request.getParameterMap().containsKey("username")) {
            username = request.getParameter("username");
        }
        if (request.getParameterMap().containsKey("password")) {
            password = request.getParameter("password");
        }
        Customer customer = _customerService.findCustomerbyUserNameAndPassword(username, password);
        if (customer != null) {
            // login successfull => push on session
            SessionUltil.getInstance().pushValue(request, "USERMODEL", customer);
            urlSend = request.getContextPath() + "/home";
        } else {
            urlSend = request.getContextPath() + "/login?message=Login fail";
        }
        response.sendRedirect(urlSend);
    }

    private void register(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/register.jsp");
        dispatcher.forward(request, response);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {
        Customer user = (Customer) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        }
        int bookID = 0;
        float totalPrice = 0;
        if (request.getParameterMap().containsKey("bookId")) {
            bookID = Integer.parseInt(request.getParameter("bookId"));
        }
        if (request.getParameterMap().containsKey("price")) {
            totalPrice = Float.parseFloat(request.getParameter("price"));
        }

        Cart cartItem = _cartService.getCartItem(user.getId(), bookID);
        if (cartItem != null) {
//            int cartId = cartItem.getId();
            int customerId = cartItem.getCustomerId();
            int quantity = cartItem.getQuantity() + 1;
            Book bookProduct = _bookService.getBookById(bookID);
            totalPrice = quantity * bookProduct.getPrice();
            boolean result = _cartService.updateCart(quantity, totalPrice, customerId, bookID);
        } else {
            _cartService.addItemToCart(new Cart(1, user.getId(), bookID, totalPrice));
        }
        response.sendRedirect(request.getContextPath() + "/home");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/login":
                    login(request, response);
                    break;
                case "/register":
                    checkregister(request, response);
                    break;
                case "/add-to-cart":
                    addToCart(request, response);
                    break;
                default:
                    listBook(request, response);
                    break;
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex
            );
        }
    }

    private void checkregister(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = "", password = "", fullname = "", email = "", phone = "";
        if (request.getParameterMap().containsKey("username")) {
            username = request.getParameter("username");
        }
        if (request.getParameterMap().containsKey("password")) {
            password = request.getParameter("password");
        }
        if (request.getParameterMap().containsKey("fullname")) {
            fullname = request.getParameter("fullname");
        }
        if (request.getParameterMap().containsKey("email")) {
            email = request.getParameter("email");
        }
        if (request.getParameterMap().containsKey("phone")) {
            phone = request.getParameter("phone");
        }
        _accService.createAccount(username, password);
        int idAccount = _accService.getIdAccount(username);  
        if (idAccount != -1) {
            _customerService.addcustomer(new Customer(idAccount, email, phone, fullname));
            // login successfull => push on session
//     _customerService.findCustomerbyUserNameAndPassword(username, password);
            SessionUltil.getInstance().pushValue(request, "USERMODEL", _customerService.findCustomerbyUserNameAndPassword(username, password));
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("message", "Register failed");
             RequestDispatcher dispatcher = request.getRequestDispatcher("views/register.jsp");
        dispatcher.forward(request, response);
        }
//       response.sendRedirect(urlSend);
    }
}
