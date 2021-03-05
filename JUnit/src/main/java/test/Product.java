package test;

public class Product {
    private String produceName;
    private int quantity;
    private double totalPrice;

    public Product(String produceName, int quantity, double totalPrice) {
        this.produceName = produceName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public String getProduceName() {
        return produceName;
    }

    public void setProduceName(String produceName) {
        this.produceName = produceName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
