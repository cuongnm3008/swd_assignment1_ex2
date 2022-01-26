package Model;

import java.sql.Date;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class Cart {

    int id;
    int quantity;
    int customerId;
    int bookId;
    float totalPrice;
    String description;
    Date dateCreated;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
    public Cart(int id, int quantity, int customerId, int bookId, float totalPrice, Date dateCreated) {
        this.id = id;
        this.quantity = quantity;
        this.customerId = customerId;
        this.bookId = bookId;
        this.totalPrice = totalPrice;
        this.dateCreated = dateCreated;
    }

    
    public Cart(int quantity, int customerId, int bookId, float totalPrice,String description) {
        this.quantity = quantity;
        this.customerId = customerId;
        this.bookId = bookId;
        this.totalPrice = totalPrice;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    
    
    
}
