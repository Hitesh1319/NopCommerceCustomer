package NopCommerce.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Dashboard {
    WebDriver driver;
    WebDriverWait wait;

    By orderMoreInfo = By.xpath("//a[@class='small-box-footer'and@href='/Admin/Order/List']");
    By registerCustomerMoreInfo = By.xpath("//a[@class='small-box-footer'and@href='/Admin/Customer/List']");
    By emailInput = By.xpath("//input[@id='SearchEmail']");
    By expandButton =By.xpath("(//div[contains(@class,'card-outline')]//div[@class='card-title']/i[contains(@class,'fa-chart')]/following::button)[1]");
    By firstName = By.xpath("//input[@id='SearchFirstName']");
    By lastName =By.xpath("//input[@id='SearchLastName']");
    By startDate = By.xpath("//input[@id='StartDate']");
    By endDate = By.xpath("//input[@id='EndDate']");
    By searchButton = By.xpath("//button[@id='search-orders']");
    By searchCustomer =By.xpath("//button[@id='search-customers']");
    By productVerify = By.xpath("//td[text()='Shipped']");
    By customerVerify = By.xpath("//td[text()='steve_gates@nopCommerce.com']");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void searchProduct() {
        wait.until(ExpectedConditions.elementToBeClickable(expandButton));
        driver.findElement(expandButton).click();
        wait.until(ExpectedConditions.elementToBeClickable(orderMoreInfo));
        driver.findElement(orderMoreInfo).click();
        driver.findElement(startDate).sendKeys("03/13/2017");
        driver.findElement(endDate).sendKeys("03/13/2017");
        driver.findElement(searchButton).click();
        String actual = driver.findElement(productVerify).getText();
        Assert.isTrue(actual.equals("Shipped"), "Expected result does not match with actual result");
    }

    public void registeredCustomers() {
        wait.until(ExpectedConditions.elementToBeClickable(registerCustomerMoreInfo));
        driver.findElement(registerCustomerMoreInfo).click();
        driver.findElement(emailInput).sendKeys("steve_gates@nopCommerce.com");
        driver.findElement(firstName).sendKeys("Steve");
        driver.findElement(lastName).sendKeys("Gates");
        wait.until(ExpectedConditions.elementToBeClickable(searchCustomer));
        driver.findElement(searchCustomer).click();
        String actual = driver.findElement(customerVerify).getText();
        Assert.isTrue(actual.equals("steve_gates@nopCommerce.com"), "Expected result does not match with actual result");
    }
}
