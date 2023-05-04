package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver;

    private By productsTopMenu = By.cssSelector("a[href=\"/products\"]");
    private By loginTopMenu = By.cssSelector("[href=\"/login\"]");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnProducts(){
        driver.findElement(productsTopMenu).click();
    }
    public void clickOnLoginBtn(){
        driver.findElement(loginTopMenu).click();
    }

}
