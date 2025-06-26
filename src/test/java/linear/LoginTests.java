package linear;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests {

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

        // Dependencia WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html"); // Launch browser

        driver.findElement(By.id("user-name")).sendKeys("standard_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Obtener el texto
        String actualValue = driver.findElement(By.className("product_label")).getText();

        // Validación
        Assert.assertEquals(actualValue, "Products", "User is not logged correctly, please verify");

        // Close driver
        driver.quit();
    }

    @Test
    public void tc02Login(){

        // Elementos
        // CSS:   h3[data-test=error]
        // XPATH: //h3[@data-test='error']

        // Dependencia WebDriverManager
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/v1/index.html"); // Launch browser

        driver.findElement(By.id("user-name")).sendKeys("locked_out_user"); // enter username
        driver.findElement(By.id("password")).sendKeys("secret_sauce"); // enter password
        driver.findElement(By.id("login-button")).click(); // Click login

        // Validar Mensaje de error
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test=error]")).getText();
        Assert.assertTrue(errorMessage.contains("locked out"), "Error message is not valid");

        driver.quit();
    }
}
