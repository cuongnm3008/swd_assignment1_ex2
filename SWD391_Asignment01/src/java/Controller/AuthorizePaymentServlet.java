package Controller;

import Model.OrderDetail;
import Ultil.PaypalServices;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Nguyen Manh Cuong
 */
@WebServlet(name = "AuthorizePaymentServlet", urlPatterns = {"/authorize_payment"})
public class AuthorizePaymentServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productName ="",quantity="",subtotal="",shipping="",totalPrice="",tax="";
        if (request.getParameterMap().containsKey("productName")) {
             productName = request.getParameter("productName");
        }
        if (request.getParameterMap().containsKey("quantity")) {
             quantity = request.getParameter("quantity");
        }
        if (request.getParameterMap().containsKey("subtotal")) {
             subtotal = request.getParameter("subtotal");
        }
        if (request.getParameterMap().containsKey("shipping")) {
             shipping = request.getParameter("shipping");
        }
        if (request.getParameterMap().containsKey("totalPrice")) {
             totalPrice = request.getParameter("totalPrice");
        }
        if (request.getParameterMap().containsKey("tax")) {
             tax = request.getParameter("tax");
        }
        OrderDetail orderDetail = new OrderDetail(productName, quantity, subtotal, tax, shipping, totalPrice);
        try {
            PaypalServices paymentServices = new PaypalServices();
            String approvalLink = paymentServices.authorizePayment(orderDetail);
            response.sendRedirect(approvalLink);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }
}
