/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Customer;

/**
 *
 * @author Nguyen Manh Cuong
 */
public interface ICustomerDAO {

    Customer findCustomerbyUserNameAndPassword(String email, String password);

    Customer findByUserName(String username);

    void addcustomer(Customer customer);

}
