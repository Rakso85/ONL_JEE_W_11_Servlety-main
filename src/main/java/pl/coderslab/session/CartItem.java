package pl.coderslab.session;

public class CartItem {

    private String name;
    private Integer quantity;
    private Double price;

    public CartItem(String name, Integer quantity, Double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Double getPrice() {
        return price;
    }
}
