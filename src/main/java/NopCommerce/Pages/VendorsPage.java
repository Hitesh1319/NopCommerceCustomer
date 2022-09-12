package NopCommerce.Pages;

import net.jodah.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class VendorsPage {

    WebDriver driver;
    WebDriverWait wait;

    By vendorName = By.xpath("//input[@id='SearchName']");
    By vendorEmail =By.xpath("//input[@id='SearchEmail']");
    By searchButton = By.xpath("//button[@id='search-vendors']");
    By verifyVendor =By.xpath("//td[text()='Vendor 1']");

    public VendorsPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void vendor() {
        driver.findElement(vendorName).sendKeys("Vendor 1");
        driver.findElement(vendorEmail).sendKeys("vendor1email@gmail.com");
        driver.findElement(searchButton).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(verifyVendor));
        String actual = driver.findElement(verifyVendor).getText();
        Assert.isTrue(actual.equals("Vendor 1"), "Expected result does not match with actual result");
    }
}
