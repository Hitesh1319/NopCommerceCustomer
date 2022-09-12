package NopCommerce.Pages;

import org.openqa.selenium.WebDriver;

public class PageFactory {
    static WebDriver driver;
    private LoginPage loginPage;
    private Menu menu;
    private CustomerPage customerPage;
    private LogoutPage logoutPage;
    private VendorsPage vendorsPage;

    public PageFactory(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage(driver);
        }
        return loginPage;
    }

    public Menu getMenu() {
        if (menu == null) {
            menu = new Menu(driver);
        }
        return menu;
    }

    public CustomerPage getCustomerPage() {
        if (customerPage == null) {
            customerPage = new CustomerPage(driver);
        }
        return customerPage;
    }

    public LogoutPage getLogoutPage() {
        if (logoutPage == null) {
            logoutPage = new LogoutPage(driver);
        }
        return logoutPage;
    }

    public VendorsPage getVendorsPage() {
        if (vendorsPage == null) {
            vendorsPage = new VendorsPage(driver);
        }
        return vendorsPage;
    }
}
