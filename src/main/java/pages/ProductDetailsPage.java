package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductDetailsPage {
    WebDriver driver;


    private By addToCartButton = By.cssSelector("button[class=\"btn btn-default cart\"]");
    private By viewCartBtn = By.cssSelector("p>[href=\"/view_cart\"]");
    private By addedToCartMsg = By.cssSelector("h4[class=\"modal-title w-100\"]");
    private By productName = By.cssSelector("[class=\"product-information\"] > h2");

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void addToCart(){
        driver.findElement(addToCartButton).click();
    }

    public void viewCart(){
        driver.findElement(viewCartBtn).click();
    }

    public boolean isSuccessAddToCartMsgDisplayed(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.textToBePresentInElementLocated(addedToCartMsg,"Added!"));
        return driver.findElement(addedToCartMsg).isDisplayed();
    }

    public String getProductName(){
        return driver.findElement(productName).getText();
    }

}
