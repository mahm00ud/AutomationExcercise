package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {

    WebDriver driver;

    private By searchBar =By.id("search_product");
    private By searchBtn = By.id("submit_search");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchProduct(String searchKeyword){
        driver.findElement(searchBar).sendKeys(searchKeyword);
        driver.findElement(searchBtn).click();
    }
}
