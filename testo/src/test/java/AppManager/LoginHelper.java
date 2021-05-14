package AppManager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.awaitility.Awaitility.await;
import static org.awaitility.Awaitility.reset;

public class LoginHelper extends HelperBase {


    public LoginHelper(WebDriver wd) {
        super(wd);
    }

    public LoginHelper fillLoginForm(User user) {
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        return this;
    }

    public void login(User user) {
        fillLoginForm(user);
        clickLogInButton();
        await().until(() -> getCurrentUrl().equals(new AccountHelper(wd).getUrl()));
    }

    public void fillEmail(String email) {
        clickEmailForm();
        type(email, By.name("username"));
    }

    public void fillPassword(String password) {
        clickPasswordForm();
        type(password, By.name("password"));
    }

    public void clickEmailForm() {
        click(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[1]/label/span"));
    }

    public void clickPasswordForm() {
        click(By.xpath("//*[@id=\"loginfrm\"]/div[3]/div[2]/label/span"));
    }

    public void clickLogInButton() {
        click(By.xpath("//*[@id=\"loginfrm\"]/button"));
    }

    public RegisterHelper clickSignUpButton() {
        click(By.xpath("//*[@id=\"loginfrm\"]/div[4]/div[1]/a"));
        return new RegisterHelper(wd);
    }

    public LoginHelper clickResetPasswordButton() {
        click(By.xpath("//*[@id=\"loginfrm\"]/div[4]/div[3]/a"));
        return this;
    }

    public LoginHelper fillEmailToResetForm(String email) {
        click(By.id("resetemail"));
        type(email, By.id("resetemail"));
        return this;
    }

    public void clickResetOnResetForm() {
        click(By.xpath("//*[@id=\"passresetfrm\"]/div[2]/span/button"));
    }

    public String getResetEmailStatusText() {
        return (wd.findElement(By.xpath("//*[@id=\"passresetfrm\"]/div[1]/div"))).getText();
    }

    public String getErrorText() {
        return (wd.findElement(By.xpath("//div[@class=\"alert alert-danger\"]"))).getText();
    }
}
