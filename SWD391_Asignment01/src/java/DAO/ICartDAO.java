/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;
import Model.Cart;
import Model.CartItemViewModel;
import java.util.List;

/**
 *
 * @author Nguyen Manh Cuong
 */
public interface ICartDAO {
    void addItemToCart(Cart shipCart);
    int getTotalItemOnCartByCustomerID(int customerId);
    List<CartItemViewModel> getAllCartItems(int customerid);
}
