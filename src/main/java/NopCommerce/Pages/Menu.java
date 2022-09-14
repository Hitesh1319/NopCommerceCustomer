package NopCommerce.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class Menu {
    WebDriver driver;
    WebDriverWait wait;

    By customer = By.linkText("Customers");
    By customerDrop = By.xpath("(//a[@href='/Admin/Customer/List'])[1]");
    By vendors = By.linkText("Vendors");

    public Menu(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void menu() {
        driver.findElement(customer).click();
        wait.until(ExpectedConditions.elementToBeClickable(customerDrop));
        driver.findElement(customerDrop).click();
    }

    public void menuVendor() {
        driver.findElement(customer).click();
        wait.until(ExpectedConditions.elementToBeClickable(vendors));
        driver.findElement(vendors).click();
    }
}
