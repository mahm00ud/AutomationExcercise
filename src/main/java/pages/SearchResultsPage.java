package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;

public class SearchResultsPage {

    WebDriver driver;

    private By searchResults =By.className("single-products");
    private By addToCartBtn = By.className("add-to-cart");
    private By viewProductBtn = By.cssSelector("[href*=\"/product_details\"]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement addProductToCartWithIndex(int index){
        List<WebElement> products = driver.findElements(searchResults);
        return products.get(index);
    }

    public void viewProductWithIndex(int productOrder){
        hoverOverProducts(driver.findElement(viewProductBtn));
        WebElement webElement =driver.findElement(RelativeLocator.with(viewProductBtn).below(addProductToCartWithIndex(productOrder)));
        forceClick(webElement);
    }

    public void forceClick(WebElement webElement){
        JavascriptExecutor j = (JavascriptExecutor) driver;
        j.executeScript("arguments[0].click();", webElement);
    }

    public void hoverOverProducts(WebElement webElement){
        Actions actions = new Actions(driver);
        actions.scrollToElement(webElement).build();

    }

}
