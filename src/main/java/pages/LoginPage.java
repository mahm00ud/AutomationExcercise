package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;

    private By emailField = By.name("email");
    private By passwordField = By.name("password");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String email, String password){
        driver.findElement(emailField).sendKeys(email);
        driver.findElement(passwordField).sendKeys(password + Keys.ENTER);

    }
}
