package NopCommerce.Test;

import org.testng.annotations.Test;
import java.io.IOException;

public class VerifyThatUserIsAbleToSearchProduct extends BaseClass {
    @Test
    public void searchProduct() throws IOException {
        pageFactory.getLoginPage().login();
        pageFactory.getDashboard().searchProduct();
        pageFactory.getLogoutPage().logout();
    }
}
