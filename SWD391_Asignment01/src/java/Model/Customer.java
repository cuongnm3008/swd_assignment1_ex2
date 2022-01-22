/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class Customer {
    protected String username;
    protected String password;
    protected int roleId;
    protected int id;
    protected String name;
    protected String email;
    protected String phone;

    

    public Customer() {
        
    }
    
    public Customer(String username, String password, int roleId, int id, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    
    public Customer(String username, String password, int roleId, String name, String email, String phone) {
        this.username = username;
        this.password = password;
        this.roleId = roleId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    


   
    
}
