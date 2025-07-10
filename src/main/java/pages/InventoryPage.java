package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BasePage{

    private final By productsLabel = By.className("product_label");
    private final By openMenu = By.xpath("//button[text()='Open Menu']");
    private final By logoutBtn = By.id("logout_sidebar_link");
    private final By btnAddToCart = By.xpath("//button[text()='ADD TO CART']");
    private final By cartBadgeNumber = By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']");
    private final By productSort = By.className("product_sort_container");
    private final By cart = By.id("shopping_cart_container");

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

    public void clickAnyAddToCart(){
        click(btnAddToCart);
    }

    /*
    Description: Metodo para obtener el badge number
    @params: val1: es el parametro que recibe blabla
     */
    public String getCartBadgeNumber(){
        return getText(cartBadgeNumber);
    }

    public void clickCart(){
        waitForElementPresent(productSort);
        click(cart);
    }
}
