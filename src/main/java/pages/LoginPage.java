package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    // Objects
    private final By usernameField = By.id("user-name");
    private final By passwordField = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By loginErrorMessage = By.cssSelector("h3[data-test=error]");
    private final By loginHeader = By.xpath("//div[@class='login_logo']");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public void login(String username, String password){
        type(usernameField, username);
        type(passwordField, password);
        click(loginBtn);
    }

    public String getLoginErrorMessages(){
        return getText(loginErrorMessage);
    }

    public boolean validateLogoutSuccessfully(){
        return isDisplayed(loginHeader);
    }
}
