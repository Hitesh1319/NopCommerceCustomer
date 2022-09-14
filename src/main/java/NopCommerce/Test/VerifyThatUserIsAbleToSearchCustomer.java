package NopCommerce.Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyThatUserIsAbleToSearchCustomer extends BaseClass{
    @Test
    public void customerSearch() throws IOException {
        pageFactory.getLoginPage().login();
        pageFactory.getMenu().menu();
        pageFactory.getCustomerPage().customer();
        pageFactory.getLogoutPage().logout();
    }
}
