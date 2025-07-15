package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.UserData;

public class SmokeTests extends BaseTests{

    @Test(groups = "smoke")
    public void tc01Smoke(){
        loginPage.login(UserData.getUsername("standard"), UserData.getPassword("standard"));
        Assert.assertEquals(invPage.getProductLabel(), "Products");
    }
}
