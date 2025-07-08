package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;

public class LoginTests extends BaseTests{

    @Test
    public void tc01(){
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(invPage.getProductLabel(), "Products");
    }

    @Test
    public void tc02(){
        loginPage.login("locked_out_user", "secret_sauce");
        Assert.assertTrue(loginPage.getLoginErrorMessages().contains("locked out"), "\"Error message is not valid\"");
    }

    @Test
    public void tc03(){
        loginPage.login("incorrect_user", "secret_sauce");
        Assert.assertTrue(loginPage.getLoginErrorMessages().contains("Username and password do not match any user in this service"));
    }

    @Test
    public void tc04(){
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getLoginErrorMessages(), "Epic sadface: Username is required");
    }

    @Test
    public void tc05() throws InterruptedException {
        loginPage.login("standard_user", "secret_sauce");
        invPage.logout();
        Assert.assertEquals(DriverFactory.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html", "Validation 1: URL");
        Assert.assertTrue(loginPage.validateLogoutSuccessfully(), "Validation 2: Header SWAGLABS is not displayed");
    }
}
