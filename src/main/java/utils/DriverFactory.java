package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> driverThread = new ThreadLocal<>();

    public static WebDriver getDriver(){
        return driverThread.get();
    }

    public static WebDriver initializeDriver(){
        //WebDriverManager.chromedriver().setup();

        // Solucion de la ventana emergente de Google Chrome de los passwords
        ChromeOptions options = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--disable-blink-features=AutomationControlled");

        driver = new ChromeDriver(options);
        driverThread.set(driver);
        return getDriver();
    }

    public static void launchBrowser(String url){
        getDriver().get(url);
    }

    public static String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
}
