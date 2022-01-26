
package Controller;

import DAO.ICartDAO;
import Implement.CartDAO;
import Ultil.PaypalServices;
import Ultil.SessionUltil;
import com.paypal.api.payments.PayerInfo;
import com.paypal.api.payments.Payment;
import com.paypal.api.payments.Transaction;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nguyen Manh Cuong
 */
@WebServlet(name = "ExecutePaymentServlet", urlPatterns = {"/execute_payment"})
public class ExecutePaymentServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    ICartDAO _cartService;
    
     @Override
    public void init() {
       _cartService = new CartDAO();
    }
    
    public ExecutePaymentServlet() {
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paymentId = request.getParameter("paymentId");
        String payerId = request.getParameter("PayerID");
        try {
            PaypalServices paymentServices = new PaypalServices();
            Payment payment = paymentServices.executePayment(paymentId, payerId);
            PayerInfo payerInfo = payment.getPayer().getPayerInfo();
            Transaction transaction = payment.getTransactions().get(0);
            request.setAttribute("payer", payerInfo);
            request.setAttribute("transaction", transaction);   
            
            //update bản ghi trong cart
            String cartIString = (String) SessionUltil.getInstance().getValue(request, "CARTID");
            int cartID = Integer.parseInt(cartIString);
            boolean check = _cartService.updateStateOnCart("Paid", cartID);
            if (check==true) {
                SessionUltil.getInstance().removeValue(request, "CARTID");
            }
            request.getRequestDispatcher("views/receipt.jsp").forward(request, response);
        } catch (Exception ex) {
            request.setAttribute("errorMessage", ex.getMessage());
            request.getRequestDispatcher("views/error.jsp").forward(request, response);
        }
    }
 
}
