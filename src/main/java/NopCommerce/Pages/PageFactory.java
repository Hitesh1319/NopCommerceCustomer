package NopCommerce.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    static WebDriver driver;
    private LoginPage loginPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }
}
