package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

public class CheckoutPage {
    WebDriver driver;

    private By placeOrderBtn = By.cssSelector("[href=\"/payment\"]");

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnPlaceOrder(){
        WebElement webElement =driver.findElement(placeOrderBtn);
        forceClick(webElement);
    }

    public void forceClick(WebElement webElement){
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", webElement);
    }
}
