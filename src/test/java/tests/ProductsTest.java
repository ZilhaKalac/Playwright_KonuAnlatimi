package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductsTest extends BaseTest {

    @Test
    public void addProductToCart() {
        ProductsPage productsPage = new LoginPage(page)
                .loginAs("standard_user", "secret_sauce");
        Assert.assertTrue(productsPage.isOpenPage());

        productsPage.addProductToCart(1);
        productsPage.addProductToCart(3);
        Assert.assertEquals(productsPage.getCartBadgeCount(), 2);

    }
    @Test
    public void productCountshouldBe6() {
        ProductsPage productsPage = new LoginPage(page)
                .loginAs("standard_user", "secret_sauce");

        Assert.assertTrue(productsPage.isOpenPage());

        // burada kaç eleman eklediysek kart içerisine, o sayıda eleman silebilirz
        productsPage.addProductToCart(2);
        CartPage cartPage = productsPage.clickCartIcon();
        Assert.assertTrue(cartPage.isOpenPage());
        cartPage.removeItem(1);

        Assert.assertEquals(cartPage.getCartItemCount(), 6);
    }
}
