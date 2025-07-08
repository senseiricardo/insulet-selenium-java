package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private final By productsLabel = By.className("product_label");
    private final By openMenu = By.xpath("//button[text()='Open Menu']");
    private final By logoutBtn = By.id("logout_sidebar_link");

    public InventoryPage(WebDriver driver) {
        super(driver);
    }

    public String getProductLabel(){
        return getText(productsLabel);
    }

    public void logout() throws InterruptedException {
        click(openMenu);
        hardWait(1000);
        click(logoutBtn);
    }
}
