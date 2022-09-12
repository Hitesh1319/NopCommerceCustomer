package NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    By email = By.xpath("//input[@value='admin@yourstore.com']");
    By password = By.xpath("//input[@class='password']");
    By submit = By.xpath("//div[@class='buttons']//button[@class='button-1 login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() {
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys("admin@yourstore.com");
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys("admin");
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }
}

