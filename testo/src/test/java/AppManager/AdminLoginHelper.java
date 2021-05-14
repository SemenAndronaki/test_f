package AppManager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.awaitility.Awaitility.await;

public class AdminLoginHelper extends HelperBase {


    public AdminLoginHelper(WebDriver wd) {
        super(wd);
    }

    public AdminLoginHelper fillLoginForm(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        return this;
    }

    public void login(User user) {
        fillLoginForm(user);
        clickLogInButton();
        await().until(() ->getCurrentUrl().equals(new AdminHelper(wd).getUrl()));
    }

    public void fillEmail(String email) {
        clickEmailForm();
        type(email, By.name("email"));
    }

    public void fillPassword(String password) {
        clickPasswordForm();
        type(password, By.name("password"));
    }

    public void clickEmailForm() {
        click(By.name("email"));
    }

    public void clickPasswordForm() {
        click(By.name("password"));
    }

    public void clickLogInButton() {
        click(By.xpath("//button[@type=\"submit\"]"));
    }
}
