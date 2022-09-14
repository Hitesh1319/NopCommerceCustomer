package NopCommerce.Pages;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;
    public static String path;
    By email = By.xpath("//input[@value='admin@yourstore.com']");
    By password = By.xpath("//input[@class='password']");
    By submit = By.xpath("//div[@class='buttons']//button[@class='button-1 login-button']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void login() throws IOException {
        path = System.getProperty("user.dir") + "//src//main//java//NopCommerce//Reports//LoginCredential.xlsx";
        FileInputStream prop1 = null;
        try {
            prop1 = new FileInputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        XSSFWorkbook wb = new XSSFWorkbook(prop1);
        XSSFSheet sheet = wb.getSheet("Sheet1");
        String username = sheet.getRow(1).getCell(0).getStringCellValue();
        String pwd = sheet.getRow(1).getCell(1).getStringCellValue();
        driver.findElement(email).clear();
        driver.findElement(email).sendKeys(username);
        driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pwd);
        wait.until(ExpectedConditions.elementToBeClickable(submit));
        driver.findElement(submit).click();
    }
}

