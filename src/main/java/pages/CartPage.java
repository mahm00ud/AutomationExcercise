package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;

    private By proceedCheckoutBtn = By.cssSelector("a[class=\"btn btn-default check_out\"]");
    private By productNameInCart = By.cssSelector("h4> a[href*=\"/product_details/\"]");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCheckOut(){
        driver.findElement(proceedCheckoutBtn).click();
    }

    public String getProductNameInCart(){
        return driver.findElement(productNameInCart).getText();
    }
}
