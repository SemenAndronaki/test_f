package tests;

import model.User;
import org.junit.Test;

public class UserEditingTest extends TestBase {


    public void adminLogin() {
        app.getNavigationHelper()
                .getPage("https://www.phptravels.net/admin");
        app.getAdminLoginHelper()
                .login(new User().withEmail("admin@phptravels.com").withPassword("demoadmin"));
    }

    public User registerNewUser() {
        User user = new User();
        app.getNavigationHelper()
                .getPage("https://www.phptravels.net/register");
        app.getRegisterHelper()
                .register(user);
        return user;
    }

    @Test
    public void open() {
        User user = registerNewUser();
        adminLogin();
        app.getAdminHelper()
                .goToCustomerList()
                .searchCustomer(user.getEmail())
                .clickEditCustomer(user.getEmail());
    }
}
