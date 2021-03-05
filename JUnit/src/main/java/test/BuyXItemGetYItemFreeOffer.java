package test;

public class BuyXItemGetYItemFreeOffer implements IOffer{
    private int XItem;
    private int YItem;

    public int getXItem() {
        return XItem;
    }

    public void setXItem(int XItem) {
        this.XItem = XItem;
    }

    public int getYItem() {
        return YItem;
    }

    public void setYItem(int YItem) {
        this.YItem = YItem;
    }

    public BuyXItemGetYItemFreeOffer(int XItem, int YItem) {
        this.XItem = XItem;
        this.YItem = YItem;
    }

    @Override
    public void applyOffer(Product product) {
        if (product.getQuantity() >= XItem)
        {
            int freeProductQuantity = product.getQuantity() / (XItem + YItem);
            double unitPrice = product.getTotalPrice() / product.getQuantity();
            double discount = unitPrice * freeProductQuantity;
            product.setTotalPrice(product.getTotalPrice() - discount);
        }
    }
}
