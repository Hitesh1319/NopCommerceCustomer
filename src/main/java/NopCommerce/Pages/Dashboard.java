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
    By startDate = By.xpath("//input[@id='StartDate']");
    By endDate = By.xpath("//input[@id='EndDate']");
    By searchButton = By.xpath("//button[@id='search-orders']");
    By productVerify = By.xpath("//td[text()='Shipped']");

    public Dashboard(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void dashboard() {
        wait.until(ExpectedConditions.elementToBeClickable(orderMoreInfo));
        driver.findElement(orderMoreInfo).click();
        driver.findElement(startDate).sendKeys("03/13/2017");
        driver.findElement(endDate).sendKeys("03/13/2017");
        driver.findElement(searchButton).click();
        String actual = driver.findElement(productVerify).getText();
        Assert.isTrue(actual.equals("Shipped"), "Expected result does not match with actual result");
    }
}
