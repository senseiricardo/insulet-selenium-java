package pom;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DriverFactory;
import utils.UserData;

public class LoginTests extends BaseTests{

    @Test
    public void tc01(){
        loginPage.login(UserData.getUsername("standard"), UserData.getPassword("standard"));
        Assert.assertEquals(invPage.getProductLabel(), "Products");
    }

    @Test
    public void tc02(){
        loginPage.login(UserData.getUsername("locked"), UserData.getPassword("locked"));
        Assert.assertTrue(loginPage.getLoginErrorMessages().contains("locked out"), "\"Error message is not valid\"");
    }

    @Test
    public void tc03(){
        loginPage.login(UserData.getUsername("incorrect"), UserData.getPassword("incorrect"));
        Assert.assertTrue(loginPage.getLoginErrorMessages().contains("Username and password do not match any user in this service"));
    }

    @Test
    public void tc04(){
        loginPage.login("", "");
        Assert.assertEquals(loginPage.getLoginErrorMessages(), "Epic sadface: Username is required");
    }

    @Test
    public void tc010() throws InterruptedException {
        loginPage.login(UserData.getUsername("standard"), UserData.getPassword("standard"));
        invPage.logout();
        Assert.assertEquals(DriverFactory.getCurrentUrl(), "https://www.saucedemo.com/v1/index.html", "Validation 1: URL");
        Assert.assertTrue(loginPage.validateLogoutSuccessfully(), "Validation 2: Header SWAGLABS is not displayed");
    }
}
