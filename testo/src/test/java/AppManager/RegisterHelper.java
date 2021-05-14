package AppManager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.awaitility.Awaitility.await;

public class RegisterHelper extends HelperBase {

    private static String url = "https://www.phptravels.net/register";

    public RegisterHelper(WebDriver wd) {
        super(wd);
    }

    public void clickFirstNameForm() {
        click(By.xpath("//form[@id='headersignupform']/div[3]/div/div/label/span"));
    }

    public String getUrl() {
        return url;
    }

    public void clickLastNameForm() {
        click(By.xpath("//form[@id='headersignupform']/div[3]/div[2]/div/label/span"));
    }

    public void clickPhoneForm() {
        click(By.xpath("//form[@id='headersignupform']/div[4]/label/span"));
    }

    public void clickEmailForm() {
        click(By.xpath("//form[@id='headersignupform']/div[5]/label/span"));
    }

    public void clickPasswordForm() {
        click(By.xpath("//form[@id='headersignupform']/div[6]/label/span"));
    }

    public void clickConfirmPasswordForm() {
        click(By.xpath("//form[@id='headersignupform']/div[7]/label/span"));
    }

    public void clickSubmitButton() {
        click(By.xpath("//button[@type='submit']"));
    }

    public void fillFirstName(String firstName) {
        clickFirstNameForm();
        type(firstName, By.name("firstname"));
    }

    public void fillLastName(String lastName) {
        clickLastNameForm();
        type(lastName, By.name("lastname"));
    }

    public void fillPhone(String phone) {
        clickPhoneForm();
        type(phone, By.name("phone"));
    }

    public void fillEmail(String email) {
        clickEmailForm();
        type(email, By.name("email"));
    }

    public void fillPassword(String password) {
        clickPasswordForm();
        type(password, By.name("password"));
    }

    public void fillConfirmPassword(String confirmPassword) {
        clickConfirmPasswordForm();
        type(confirmPassword, By.name("confirmpassword"));
    }

    public RegisterHelper fillRegisterForm(User user) {
        fillFirstName(user.getFirstName());
        fillLastName(user.getLastName());
        fillPhone(user.getPhone());
        fillEmail(user.getEmail());
        fillPassword(user.getPassword());
        fillConfirmPassword(user.getConfirmPassword());
        return this;
    }

    public void register(User user) {
        fillRegisterForm(user);
        clickSubmitButton();
        await().until(() -> getCurrentUrl().equals(new AccountHelper(wd).getUrl()));
    }

    public String getErrorText() {
        return (wd.findElement(By.xpath("*//div[@class=\"alert alert-danger\"]"))).getText();
    }

}
