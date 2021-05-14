package AppManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

    public NavigationHelper(WebDriver wd) {
        super(wd);
    }

    public RegisterHelper goToRegisterPage() {
        clickAccountDropdown();
        clickSignUpButton();
        return new RegisterHelper(wd);
    }

    public LoginHelper goToLoginPage() {
        clickAccountDropdown();
        clickLoginButton();
        return new LoginHelper(wd);
    }

    public NavigationHelper logout() {
        clickAccountDropdown();
        clickLogOutButton();
        return this;
    }

    public void clickAccountDropdown() {
        click(By.xpath("*//div[@class=\"dropdown dropdown-login dropdown-tab\"]/a"));
    }

    public void clickSignUpButton() {
        click(By.xpath("*//a[@href = 'https://www.phptravels.net/register']"));
    }

    private void clickLoginButton() {
        click(By.xpath("//a[@href=\"https://www.phptravels.net/login\"]"));
    }


    public void clickLogOutButton() {
        click(By.xpath("*//a[@href = 'https://www.phptravels.net/account/logout/']"));
    }
}
