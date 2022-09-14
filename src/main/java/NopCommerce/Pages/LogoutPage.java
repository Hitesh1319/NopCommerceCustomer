package NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutPage {
    WebDriver driver;

    By logout = By.xpath("//a[text()='Logout']");

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
    }

    public void logout() {
        driver.findElement(logout).click();
    }
}
