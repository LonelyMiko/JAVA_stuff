package test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Product> productList = new ArrayList<>();
    private IOffer offer;
    public int getProductCount() {
        return productList.size();
    }

    public void addProduct(Product product)
    {
        if (offer != null)
        {
            offer.applyOffer(product);
        }
        productList.add(product);
    }
    public double getTotalCartValue()
    {
        double totalCartValue = 0.0d;
        if (productList.size() > 0 )
        {
            for (Product product : productList)
            {
                totalCartValue += product.getTotalPrice();
            }
        }
        return totalCartValue;
    }
    public void setOffer(IOffer offer) {
        this.offer = offer;
    }
    public Product getProductByName(String name)
    {
        if (productList.size() > 0)
        {
            for (Product product : productList)
            {
                if (product.getProduceName().equals(name))
                {
                    return product;
                }
            }
        }
        return null;
    }
}
