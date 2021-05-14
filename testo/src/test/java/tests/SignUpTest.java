package tests;

import model.User;
import org.junit.*;

public class SignUpTest extends TestBase{

    @Before
    public void goToRegisterPage(){
        app.getNavigationHelper()
                .goToRegisterPage();
    }

    @Test
    public void successRegistrationTest() {
        app.getRegisterHelper()
                .register(new User());
    }

    @Test
    public void passwordNotMatchingTest() {
        app.getRegisterHelper()
                .fillRegisterForm(new User().withConfirmPassword("Another pasword"))
                .clickSubmitButton();
        Assert.assertEquals("Password not matching with confirm password.", app.getRegisterHelper().getErrorText());
    }

    @Test
    public void emailAlreadyExistTest() {
        User user = new User();
        app.getRegisterHelper()
                .register(user);
        app.getNavigationHelper()
                .logout()
                .goToRegisterPage();
        app.getRegisterHelper()
                .fillRegisterForm(user)
                .clickSubmitButton();
        Assert.assertEquals("Email Already Exists.", app.getRegisterHelper().getErrorText());
    }

}
