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
@WebServlet(name = "CustomerController", urlPatterns = {"/customer","/cart"})
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
                    listItemOnCart(request,response);
                    break;
                default:
                   
                   
            }
        } catch (Exception ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex
            );
           
        }
        
        
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
       
    }
}
