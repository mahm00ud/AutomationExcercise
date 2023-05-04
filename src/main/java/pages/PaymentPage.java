package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PaymentPage {
    WebDriver driver;

    private By nameOnCardField = By.name("name_on_card");
    private By cardNumberField = By.name("card_number");
    private By cvcField = By.name("cvc");
    private By expiryMonthField = By.name("expiry_month");
    private By expiryYearField = By.name("expiry_year");
    private By payBtn = By.id("submit");

    private By confirmationMsgForOrder = By.cssSelector("[class=\"row\"] p");
    private By downloadInvoiceBtn = By.cssSelector("[href*=\"/download_invoice/\"]");

    public PaymentPage(WebDriver driver) {
        this.driver = driver;
    }

    public void payOrder(String Name, String CardNumber, String cvc, String Month, String Year){
        driver.findElement(nameOnCardField).sendKeys(Name);
        driver.findElement(cardNumberField).sendKeys(CardNumber);
        driver.findElement(cvcField).sendKeys(cvc);
        driver.findElement(expiryMonthField).sendKeys(Month);
        driver.findElement(expiryYearField).sendKeys(Year);

        driver.findElement(payBtn).click();
    }


    public String getConfirmationMsgForPay(){
        return driver.findElement(RelativeLocator.with(confirmationMsgForOrder).above(downloadInvoiceBtn)).getText();
    }

}
