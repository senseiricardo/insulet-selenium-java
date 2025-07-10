package pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTests extends BaseTests{

    @Test
    public void tc08() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        invPage.clickAnyAddToCart();
        invPage.clickCart();
        checkoutPage.cartToCheckOut();
        //TODO: Mejorar la respuesta/Logica de este metodo
        checkoutPage.fillOutForm("", "", "");
        Assert.assertTrue(checkoutPage.getCheckoutErrorMessages().contains("First Name is required"));
    }

    @Test
    public void tc09() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        invPage.clickAnyAddToCart();
        invPage.clickCart();
        checkoutPage.cartToCheckOut();
        checkoutPage.fillOutForm("Ricardo", "Avalos", "898989");
        checkoutPage.clickFinish();
        Assert.assertEquals(checkoutPage.getSuccessOrderMessage(), "THANK YOU FOR YOUR ORDER");

    }
}
