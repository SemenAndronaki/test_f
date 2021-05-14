package tests;

import model.User;
import org.junit.Test;

import static org.awaitility.Awaitility.await;
import static org.junit.Assert.assertEquals;

public class LoginTest extends TestBase {

    public User register() {
        User user = new User();
        app.getNavigationHelper()
                .goToRegisterPage();
        app.getRegisterHelper()
                .register(user);
        app.getNavigationHelper()
                .logout();
        return user;
    }

    @Test
    public void successLoginTest() {
        User user = register();
        app.getLoginHelper()
                .login(user);
    }

    @Test
    public void wrongPasswordTest() {
        app.getNavigationHelper()
                .goToLoginPage();
        app.getLoginHelper()
                .fillLoginForm(new User().withEmail("s@gmail.com").withPassword("wrong password"))
                .clickLogInButton();
        assertEquals("Invalid Email or Password", app.getLoginHelper().getErrorText());
    }

    @Test
    public void goToRegisterPageTest() {
        app.getNavigationHelper()
                .goToLoginPage()
                .clickSignUpButton();
        await().until(() -> app.getRegisterHelper().getCurrentUrl().equals("https://www.phptravels.net/register"));
    }

    @Test
    public void resetPasswordTest() {
        User user = register();
        app.getLoginHelper()
                .clickResetPasswordButton()
                .fillEmailToResetForm(user.getEmail())
                .clickResetOnResetForm();
        await().until(() ->  app.getLoginHelper().getResetEmailStatusText()
                .equals(String.format("New Password sent to %s, Kindly check email", user.getEmail())));
    }

    @Test
    public void resetPasswordErrorTest() {
        app.getNavigationHelper()
                .goToLoginPage();
        app.getLoginHelper()
                .clickResetPasswordButton()
                .fillEmailToResetForm(System.currentTimeMillis() + "wrong_email@gmail.com")
                .clickResetOnResetForm();
        await().until(() ->  app.getLoginHelper().getResetEmailStatusText()
                .equals("Email Not Found"));
    }

}
