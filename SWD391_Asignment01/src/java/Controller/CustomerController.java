/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.ICartDAO;
import Implement.CartDAO;
import Model.CartItemViewModel;
import Model.Customer;
import Model.OrderDetail;
import Ultil.SessionUltil;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Manh Cuong
 */
@WebServlet(name = "CustomerController", urlPatterns = {"/customer", "/cart", "/checkout", "/payment"})
public class CustomerController extends HttpServlet {

    ICartDAO _cartService;

    @Override
    public void init() {
        _cartService = new CartDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/cart":
                    listItemOnCart(request, response);
                    break;
                case "/checkout":
                    checkout(request, response);
                    break;
                case "/payment":
                    paymentDetail(request, response);
                    break;
                default:
            }
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("error.jsp").forward(request, response);
        }
    }

    private void checkout(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
//        String productName = request.getParameter("product");
//        String quantity = request.getParameter("quantity");
//        String subtotal = request.getParameter("subtotal");
//        String shipping = request.getParameter("shipping");
//        String totalPrice = request.getParameter("totalPrice");
        String bookname = request.getParameter("bookname");
        String quantity = request.getParameter("quantity");
        String subtotal = request.getParameter("subtotal");
        String Tax = request.getParameter("VAT");
        String totalPrice = request.getParameter("totalPrice");
        OrderDetail orderDetail = new OrderDetail(bookname, quantity, subtotal,  Tax,"10", totalPrice);
        System.out.println(orderDetail.getProductName());
        request.setAttribute("MODEL", orderDetail);
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/checkout.jsp");
        dispatcher.forward(request, response);

    }

    private void paymentDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String bookname = "", address = "";
//        String quantity = "";
        String cardID = request.getParameter("cartId");
        CartItemViewModel cartItem = _cartService.findCartById(Integer.parseInt(cardID));
        if (request.getParameterMap().containsKey("bookname")) {
            bookname = request.getParameter("bookname");
        }
        if (request.getParameterMap().containsKey("address")) {
            address = request.getParameter("address");
        }
        if (request.getParameterMap().containsKey("subtotal")) {
            address = request.getParameter("subtotal");
        }
        int quantity = cartItem.getQuantity();
        float subtotal = cartItem.getTotalPrice();
        float VAT = (float) (subtotal * 0.1);
        float totalPrice = subtotal + VAT + 10;
        bookname = cartItem.getBookName();
        request.setAttribute("bookname", bookname);
        request.setAttribute("quantity", quantity);
        request.setAttribute("subtotal", subtotal);
        request.setAttribute("VAT", VAT);
        request.setAttribute("totalPrice", totalPrice);

        RequestDispatcher dispatcher = request.getRequestDispatcher("views/payment.jsp");
        dispatcher.forward(request, response);
    }

    private void listItemOnCart(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException, Exception {
        Customer user = (Customer) SessionUltil.getInstance().getValue(request, "USERMODEL");
        if (user != null) {
            int totalItem = _cartService.getTotalItemOnCartByCustomerID(user.getId());
            request.setAttribute("totalItem", totalItem);
            List<CartItemViewModel> listBook = _cartService.getAllCartItems(user.getId());
            request.setAttribute("listBook", listBook);
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("views/cart.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
        try {
            switch (action) {
                case "/checkout":
                    break;
                default:
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex
            );
        }
    }

}
