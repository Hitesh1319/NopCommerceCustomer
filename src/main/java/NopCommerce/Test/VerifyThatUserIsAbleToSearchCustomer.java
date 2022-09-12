package NopCommerce.Test;

import org.testng.annotations.Test;

public class VerifyThatUserIsAbleToSearchCustomer extends BaseClass{
    @Test
    public void customerSearch(){
        pageFactory.getLoginPage().login();
        pageFactory.getMenu().menu();
        pageFactory.getCustomerPage().customer();
        pageFactory.getLogoutPage().logout();
    }
}
