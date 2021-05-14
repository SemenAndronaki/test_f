package AppManager;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    private final Properties properties;
    WebDriver wd;

    private RegisterHelper registerHelper;
    private LoginHelper loginHelper;
    private AdminLoginHelper adminLoginHelper;
    private AdminHelper adminHelper;
    private NavigationHelper navigationHelper;
    private CustomerHelper customerHelper;


    public ApplicationManager(String browser) {
        properties = new Properties();
    }

    public void init() throws IOException {
        System.setProperty("webdriver.chrome.driver", "C:/Chromedriver/chromedriver.exe");
        properties.load(new FileReader(new File(String.format("src/test/resources/properties.properties"))));
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        wd.get(properties.getProperty("web.baseUrl"));
        registerHelper = new RegisterHelper(wd);
        navigationHelper = new NavigationHelper(wd);
        loginHelper = new LoginHelper(wd);
        adminLoginHelper = new AdminLoginHelper(wd);
        adminHelper = new AdminHelper(wd);
        customerHelper = new CustomerHelper(wd);
    }

    public void stop() {
        wd.quit();
    }

    public RegisterHelper getRegisterHelper() {
        return registerHelper;
    }

    public NavigationHelper getNavigationHelper() {
        return navigationHelper;
    }

    public LoginHelper getLoginHelper() {
        return loginHelper;
    }

    public AdminLoginHelper getAdminLoginHelper() {
        return adminLoginHelper;
    }

    public AdminHelper getAdminHelper() {
        return adminHelper;
    }

    public CustomerHelper getCustomerHelper() {
        return customerHelper;
    }
}
