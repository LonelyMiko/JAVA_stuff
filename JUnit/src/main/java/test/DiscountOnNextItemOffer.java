package test;

public class DiscountOnNextItemOffer implements IOffer {
    private double discountPercentage;

    public double getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public DiscountOnNextItemOffer(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public void applyOffer(Product product) {
        int totalQuantity = product.getQuantity();
        double unitPrice = product.getTotalPrice() / product.getQuantity();
        while (totalQuantity > 1)
        {
            double price = product.getTotalPrice();
            product.setTotalPrice(price - (unitPrice/ (100 / discountPercentage)));
            totalQuantity-= 2;
        }
    }


}
