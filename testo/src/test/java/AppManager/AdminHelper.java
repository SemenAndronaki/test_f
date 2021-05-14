package AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.awaitility.Awaitility.await;

public class AdminHelper extends HelperBase {

    private static String url = "https://www.phptravels.net/admin";

    public AdminHelper(WebDriver wd) {
        super(wd);
    }

    public String getUrl() {
        return url;
    }

    public AdminHelper goToCustomerList() {
        click(By.xpath("//*[@id=\"social-sidebar-menu\"]/li[5]/a"));
        click(By.xpath("//*[@id=\"ACCOUNTS\"]/li[3]/a"));
        return this;
    }

    public AdminHelper searchCustomer(String email) {
        click(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[3]/a"));
        type(email, By.xpath("//input[@name=\"phrase\"]"));
        click(By.xpath("//*[@id=\"content\"]/div[2]/div[2]/div/div/div[1]/div[3]/span[1]/span/a"));
        return this;
    }

    public CustomerHelper clickEditCustomer(String email) {
        String locator = String.format("//a[@href=\"mailto:%s\"]/../../td/span/a[1]", email);
        click(By.xpath(locator));

        CustomerHelper customerHelper =  new CustomerHelper(wd);
        await().until(() -> getCurrentUrl().equals(customerHelper.getUrl()));
        return customerHelper;
    }
}
