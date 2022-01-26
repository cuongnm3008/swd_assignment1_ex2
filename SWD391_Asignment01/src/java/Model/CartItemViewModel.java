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
public class CartItemViewModel {
    int cartId;
    String bookName; 
    String author; 
    String publisher;
    float totalPrice;
    int quantity;
    String fullname;
    String title;

    public CartItemViewModel(int cartId, String bookName, float totalPrice, int quantity, String fullname) {
        this.cartId = cartId;
        this.bookName = bookName;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
        this.fullname = fullname;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public CartItemViewModel(int cartId, String bookName, String author, String publisher, float totalPrice, int quantity) {
        this.cartId = cartId;
        this.bookName = bookName;
        this.author = author;
        this.publisher = publisher;
        this.totalPrice = totalPrice;
        this.quantity = quantity;
    }

    public int getCartId() {
        return cartId;
    }

    public void setCartId(int cartId) {
        this.cartId = cartId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

  
    
    
    
}
