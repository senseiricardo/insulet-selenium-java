package linear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import org.testng.annotations.*;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class CheckoutTests {

    private static WebDriver driver;

    @BeforeMethod
    public void setup(){

        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);

        driver.get("https://www.saucedemo.com/v1/index.html");

        // Implicit Wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    /*
    id: shopping_cart_container
    class: btn_action checkout_button
    id: first-name
    id: last-name
    id: postal-code
    value: CONTINUE
    //*[text()='FINISH']
    h2[class=complete-header]
     */

    @Test
    public void tc08CheckOut() throws InterruptedException {

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // EXPLICIT WAIT - Sync
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_sort_container")));

        // Seleccionar producto
        driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(0).click();

        // Click carrito
        driver.findElement(By.id("shopping_cart_container")).click();

        wait.until(ExpectedConditions.urlContains("cart.html")); // Explicit Wait

        // Click Checkout
        driver.findElement(By.xpath("//*[text()='CHECKOUT']")).click();

        // Click Continue
        driver.findElement(By.xpath("//*[@value='CONTINUE']")).click();

        // Validar el mensaje de error
        String errorMsg = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();

        Assert.assertTrue(errorMsg.contains("First Name is required"), "El mensaje de error no existe o es invalido");

    }

    @Test
    public void tc09Checkout() throws InterruptedException {

        // Login
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        Thread.sleep(5000);

        // Seleccionar producto
        driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(0).click();

        // Click carrito
        driver.findElement(By.id("shopping_cart_container")).click();

        // Click Checkout
        driver.findElement(By.xpath("//*[text()='CHECKOUT']")).click();

        // Llenar la forma
        driver.findElement(By.id("first-name")).sendKeys("Automation");
        driver.findElement(By.id("last-name")).sendKeys("Testing");
        driver.findElement(By.id("postal-code")).sendKeys("123456");

        Thread.sleep(1000);

        // Click Continue
        driver.findElement(By.xpath("//*[@value='CONTINUE']")).click();

        // EXPLICIT WAIT - Continua hasta que el boton CONTINUE no exista
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        //wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//*[@value='CONTINUE']")));

        // Click Finish
        driver.findElement(By.xpath("//*[text()='FINISH']")).click();

        // Validacion final

        String message = driver.findElement(By.cssSelector("h2[class=complete-header]")).getText();

        // FLUENT WAIT
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(15)) // Tiempo maximo total
                .pollingEvery(Duration.ofSeconds(1)) // Revision cada <1 seg>
                .ignoring(NoSuchElementException.class);

        fluentWait.until(driver -> driver.findElement(By.cssSelector("h2[class=complete-header]")));

        Assert.assertEquals(message, "THANK YOU FOR YOUR ORDER");


    }
}
