package pom;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InventoryTests extends BaseTests{

    @Test(groups = "smoke")
    public void tc05(){
        loginPage.login("standard_user", "secret_sauce");
        invPage.clickAnyAddToCart();
        Assert.assertEquals(invPage.getCartBadgeNumber(), "1");
    }
}
