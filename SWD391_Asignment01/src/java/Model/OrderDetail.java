package Model;

/**
 *
 * @author Nguyen Manh Cuong
 */
public class OrderDetail {

    private String productName;
    private String quantity;
    private String subtotal;
    private String tax;
    private String shipping;
    private String totalPrice;

    public OrderDetail(String productName, String quantity, String subtotal, String tax, String shipping, String totalPrice) {
        this.productName = productName;
        this.quantity = quantity;
        this.subtotal = subtotal;
        this.tax = tax;
        this.shipping = shipping;
        this.totalPrice = totalPrice;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(String subtotal) {
        this.subtotal = subtotal;
    }

    public String getTax() {
        return tax;
    }

    public void setTax(String tax) {
        this.tax = tax;
    }

    public String getShipping() {
        return shipping;
    }

    public void setShipping(String shipping) {
        this.shipping = shipping;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

  
}
