package NopCommerce.Test;

import org.testng.annotations.Test;

public class VerifyThatUserIsAbleToSearchVendors extends BaseClass {
    @Test
    public void vendorSearch() {
        pageFactory.getLoginPage().login();
        pageFactory.getMenu().menuVendor();
        pageFactory.getVendorsPage().vendor();
        pageFactory.getLogoutPage().logout();
    }
}
