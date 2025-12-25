package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;
import pages.ProductsPage;

public class LoginTests extends BaseTest {

    @Test
    public void successfulLogin() {
        LoginPage loginPage = new LoginPage(page);
        ProductsPage productsPage =
                loginPage.loginAs("standard_user", "secret_sauce");

        // login sonrası product page açıldı mı?
        Assert.assertTrue(productsPage.isOpenPage());
    }

    @Test
    public void failedLogin() {
        LoginPage loginPage = new LoginPage(page);

        loginPage.fillPassword("locked_out_user")
                 .fillPassword("secret_sauce")
                 .clickLoginBtnFail();

        Assert.assertTrue(loginPage.isErrorMessageVisible());
    }

}
