package AppManager;

import org.openqa.selenium.WebDriver;

public class CustomerHelper extends HelperBase {

    private static String url = "https://www.phptravels.net/admin/accounts/customers/edit";

    public CustomerHelper(WebDriver wd) {
        super(wd);
    }

    public String getUrl() {
        return url;
    }
}
