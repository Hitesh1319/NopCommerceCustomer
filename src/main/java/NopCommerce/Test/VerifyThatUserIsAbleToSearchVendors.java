package NopCommerce.Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyThatUserIsAbleToSearchVendors extends BaseClass {
    @Test
    public void vendorSearch() throws IOException {
        pageFactory.getLoginPage().login();
        pageFactory.getMenu().menuVendor();
        pageFactory.getVendorsPage().vendor();
        pageFactory.getLogoutPage().logout();
    }
}
