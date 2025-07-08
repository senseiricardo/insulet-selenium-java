package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.InventoryPage;
import pages.LoginPage;
import utils.DriverFactory;

public class BaseTests {

    private WebDriver driver;
    LoginPage loginPage;
    InventoryPage invPage;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.initializeDriver();
        loginPage = new LoginPage(driver);
        invPage = new InventoryPage(driver);

        DriverFactory.launchBrowser("https://www.saucedemo.com/v1/index.html");
    }

    @AfterMethod
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
