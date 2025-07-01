package linear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class InventoryTests {

    @Test
    public void tc05AddToCart(){
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-blink-features=AutomationControlled");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/index.html");

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(2).click();

        String cartBadgeNumber = driver.findElement(By.xpath("//span[@class=\"fa-layers-counter shopping_cart_badge\"]")).getText();
        Assert.assertEquals(cartBadgeNumber, "1", "Cart badge number is invalid");

        driver.quit();
    }
}
