package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    public void type(By locator, String text){
        try{
            driver.findElement(locator).sendKeys(text);
        }catch(InvalidElementStateException e){
            throw new RuntimeException("Unable to type "+ locator, e);
        }
    }

    public void click(By locator){
        try{
            driver.findElement(locator).click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public String getText(By locator){
        try{
            // Bloque 1
            return driver.findElement(locator).getText();
        }catch(NoSuchElementException e){
            // Bloque 2
            return null;
        }
    }

    public void hardWait(int millis) throws InterruptedException {
        Thread.sleep(millis);
    }

    public boolean isDisplayed(By locator){
        try{
            return driver.findElement(locator).isDisplayed();
        }catch(NoSuchElementException e){
            return false;
        }
    }

}
