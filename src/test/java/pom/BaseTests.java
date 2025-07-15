package pom;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.CheckoutPage;
import pages.InventoryPage;
import pages.LoginPage;
import utils.ConfigReader;
import utils.DriverFactory;

@Listeners({io.qameta.allure.testng.AllureTestNg.class})
public class BaseTests {

    private WebDriver driver;
    LoginPage loginPage;
    InventoryPage invPage;
    CheckoutPage checkoutPage;

    public WebDriver getDriver(){
        return driver;
    }

    @BeforeMethod(alwaysRun = true)
    public void setup(){
        driver = DriverFactory.initializeDriver();
        loginPage = new LoginPage(driver);
        invPage = new InventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);

        DriverFactory.launchBrowser(ConfigReader.get("baseUrl"));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(){
        if(driver != null){
            driver.quit();
        }
    }

}
