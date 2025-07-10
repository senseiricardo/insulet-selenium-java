package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private final By checkoutBtn = By.xpath("//*[text()='CHECKOUT']");
    private final By continueBtn = By.xpath("//*[@value='CONTINUE']");
    private final By errorMessagesCheckout = By.cssSelector("h3[data-test=error]");
    private final By firstNameForm = By.id("first-name");
    private final By lastNameForm = By.id("last-name");
    private final By postalCodeForm = By.id("postal-code");
    private final By finishBtn = By.xpath("//*[text()='FINISH']");
    private final By successMessage = By.cssSelector("h2[class=complete-header]");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void cartToCheckOut() throws InterruptedException {
        click(checkoutBtn);
        hardWait(1000);
        waitForElementPresent(firstNameForm);
    }

    public void fillOutForm(String firstname, String lastname, String postal){
        fillOutForm(firstname, lastname,postal, true);
    }

    public void fillOutForm(String firstname, String lastname, String postal, boolean clickContinue){
        type(firstNameForm, firstname);
        type(lastNameForm, lastname);
        type(postalCodeForm, postal);
        if(clickContinue){
            click(continueBtn);
        }
    }

    public String getCheckoutErrorMessages(){
        return getText(errorMessagesCheckout);
    }

    public void clickFinish(){
        click(finishBtn);
    }

    public String getSuccessOrderMessage() throws InterruptedException {
        hardWait(2000);
        return getText(successMessage);
    }
}
