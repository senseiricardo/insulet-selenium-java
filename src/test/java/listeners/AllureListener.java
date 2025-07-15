package listeners;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import pom.BaseTests;

public class AllureListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Object testClass = result.getInstance();
        if (testClass instanceof BaseTests) {
            WebDriver driver = ((BaseTests) testClass).getDriver();
            if (driver != null) {
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);

                // Esta es la clave para que Allure lo vea como PNG y lo nombre correctamente
                Allure.getLifecycle().addAttachment(
                        "Screenshot on failure",
                        "image/png",
                        "png", // <-- esto le dice que es un archivo .png
                        screenshot
                );
                System.out.println("✅ Screenshot registrado correctamente con tipo PNG.");
            }
        }
    }
}
