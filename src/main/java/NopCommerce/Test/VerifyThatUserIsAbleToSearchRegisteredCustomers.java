package NopCommerce.Test;

import org.testng.annotations.Test;

import java.io.IOException;

public class VerifyThatUserIsAbleToSearchRegisteredCustomers extends BaseClass {
    @Test
    public void searchRegisteredCustomers() throws IOException {
        pageFactory.getLoginPage().login();
        pageFactory.getDashboard().registeredCustomers();
        pageFactory.getLogoutPage().logout();
    }
}
