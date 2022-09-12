package NopCommerce.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CustomerPage {
    WebDriver driver;
    WebDriverWait wait;

    By email = By.xpath("//input[@id='SearchEmail']");
    By searchButton = By.xpath("//button[@id='search-customers']");
    By verifyEmail =By.xpath("//td[text()='victoria_victoria@nopCommerce.com']");
    public CustomerPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void customer() {
        driver.findElement(email).sendKeys("victoria_victoria@nopCommerce.com");
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyEmail));
        String actual = driver.findElement(verifyEmail).getText();
        Assert.isTrue(actual.equals("victoria_victoria@nopCommerce.com"), "Expected result does not match with actual result");
    }
}
