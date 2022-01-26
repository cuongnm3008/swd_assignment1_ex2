/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Model.Account;

/**
 *
 * @author Nguyen Manh Cuong
 */
public interface IAccountDAO {
     void createAccount (String Username, String Password);
    
    int getIdAccount(String Username);
   
    Account getAccountByUsername(String username);
}
