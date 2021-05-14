package AppManager;

import org.openqa.selenium.WebDriver;

public class AccountHelper extends HelperBase {

    public AccountHelper(WebDriver wd) {
        super(wd);
    }

    private static String url = "https://www.phptravels.net/account/";

    public String getUrl() {
        return url;
    }
}
