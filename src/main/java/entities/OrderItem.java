package entities;

public class OrderItem {

    private Product product = new Product();
    private Double price;
    private Integer quantity;


    public OrderItem(){
    }

    public OrderItem(Product product, double price, int quantity) {
        this.product = product;
        this.price = price;
        this.quantity = quantity;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public double subTotal (){
         return quantity * price;
    }

    @Override
    public String toString() {
        return product+", $"+price+", Quantity:"+quantity+" SubTotal: $"+subTotal();
    }
}
