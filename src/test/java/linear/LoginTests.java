package linear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.HashMap;
import java.util.Map;

public class LoginTests {

    private static WebDriver driver;

    /*
    Annotations:

    BeforeClass
    AfterClass

    BeforeMethod
    AfterMethod

    BeforeTest
    AfterTest

    BeforeSuite
    AfterSuite

    BeforeGroup
    After Group
     */

    @BeforeClass
    public void beforeClass(){
        System.out.println("Soy el Before Class");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("Soy el After Class");
    }

    @BeforeMethod
    public void setup(){
        System.out.println("Soy el Before Test");
        // Solucion!!

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
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("Soy el After Test");
        driver.quit();
    }



    @Test
    public void tc01Login(){
        // Good practices
        /*
        1- Correr la prueba manual
        2- ¿Depende de datos? - Si (¿Puedo generarlos?) Si (No puedo generarlos) - Riesgo (Estatico) -
        No candidato a automatizacion
        3- Obtencion de elementos
        username: id=user-name
        password: id=password
        boton login: id=login-button
        Products: class="product_label"
        4- Scripting
         */

         // Launch browser
        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Obtener el texto
        String actualValue = driver.findElement(By.className("product_label")).getText();

        // Validación
        Assert.assertEquals(actualValue, "Products", "User is not logged correctly, please verify");
    }

    @Test
    public void tc02Login(){

        // Elementos
        // CSS:   h3[data-test=error]
        // XPATH: //h3[@data-test='error']

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Validar Mensaje de error
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        Assert.assertTrue(errorMessage.contains("locked out"), "Error message is not valid");
    }

    @Test
    public void tc03LoginIncorrectUser(){

        // Elementos
        // CSS:   h3[data-test=error]
        // XPATH: //h3[@data-test='error']

        driver.findElement(By.id("user-name")).sendKeys("incorrect_password"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Validar Mensaje de error
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertTrue(errorMessage.contains("Username and password do not match any user in this service"), "Error message is not valid");
    }

    @Test
    public void tc04LoginEmptyValues(){

        // Elementos
        // CSS:   h3[data-test=error]
        // XPATH: //h3[@data-test='error']

        driver.findElement(By.id("login-button")).click(); // Click login

        // Validar Mensaje de error
        String errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorMessage, "Epic sadface: Username is required", "Error message is invalid ");

    }

    @Test
    public void tc05LoginLogout() throws InterruptedException {

        // Elementos
        // XPATH://button[text()='Open Menu']
        // ID: logout_sidebar_link

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Flujo y validacion
        driver.findElement(By.xpath("//button[text()='Open Menu']")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("logout_sidebar_link")).click();

        /*
        Img sea visible
        Encabezado
        Formulario
         */

        String actualLoginURL = driver.getCurrentUrl();
        // 1 validacion
        Assert.assertEquals(actualLoginURL, "https://www.saucedemo.com/v1/index.html");

        // 2 validacion
        boolean actualValue = driver.findElement(By.xpath("//div[@class='login_logo']")).isDisplayed();
        Assert.assertTrue(actualValue, "Header SWAGLABS is not displayed");

    }
}
