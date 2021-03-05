package test;

import org.junit.Assert;
import org.junit.Test;

public class ShhoppingCartAppTest {
    @Test
    public void testCreateEmptyShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Assert.assertEquals(0, cart.getProductCount());
    }

    @Test
    public void testAddSingleProductToShoppingCart() {
        ShoppingCart cart = new ShoppingCart();
        Product product = new Product("Gatsby hair cream", 1, 30.0);
        cart.addProduct(product);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(30.0, cart.getTotalCartValue(),0.0);
    }
    @Test
    public void addDifferentProductsToTheCart()
    {
        ShoppingCart cart = new ShoppingCart();
        Product gatsbyHairCream = new Product("Gatsby hair cream", 1, 30.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap",1,130);
        cart.addProduct(gatsbyHairCream);
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2,cart.getProductCount());
        Assert.assertEquals(160,cart.getTotalCartValue(),0.0);
    }
    @Test
    public void testAddMultipleQuantityOfAProductAndApplyOfferToCart()
    {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2,1);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsbyHairCream = new Product("Gatsby hair cream", 5, 150.0);
        cart.addProduct(gatsbyHairCream);
        Assert.assertEquals(1,cart.getProductCount());
        Assert.assertEquals(120.0,cart.getTotalCartValue(),0.0);
    }
    @Test
    public void addDifferentProductsAndAppyOfferToTheCart()
    {
        IOffer offer = new BuyXItemGetYItemFreeOffer(2,1);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsbyHairCream = new Product("Gatsby hair cream", 3, 90.0);
        Product bvlgiriSoap = new Product("Bvlgiri Soap",2,200.0);
        cart.addProduct(gatsbyHairCream);
        cart.addProduct(bvlgiriSoap);
        Assert.assertEquals(2,cart.getProductCount());
        Assert.assertEquals(260.0,cart.getTotalCartValue(),0.0);
    }
    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheCart()
    {
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsbyHairCream = new Product("Gatsby hair cream", 2, 60.0);
        cart.addProduct(gatsbyHairCream);
        Assert.assertEquals(1,cart.getProductCount());
        Assert.assertEquals(45.0, cart.getProductByName("Gatsby hair cream").getTotalPrice(),0.0);
        Assert.assertEquals(45.0,cart.getTotalCartValue(),0.0);
    }
    @Test
    public void testApplyBuyOneGetFiftyPercentDiscountOnNextOfferToTheMultipleProductsInCart(){
        IOffer offer = new DiscountOnNextItemOffer(50.0);
        ShoppingCart cart = new ShoppingCart();
        cart.setOffer(offer);
        Product gatsByCream = new Product("Gatsby hair cream", 5, 150.0);
        cart.addProduct(gatsByCream);
        Assert.assertEquals(1, cart.getProductCount());
        Assert.assertEquals(120.0, cart.getProductByName("Gatsby hair cream").getTotalPrice(),0.0);
        Assert.assertEquals(120.0, cart.getTotalCartValue(),0.0);
    }
}
