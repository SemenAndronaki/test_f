package tests;

import AppManager.ApplicationManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.BrowserType;

import java.io.IOException;


public class TestBase {

    protected static final ApplicationManager app
            = new ApplicationManager(System.getProperty("browser", BrowserType.CHROME));


    @Before
    public void setUp() throws IOException {
        app.init();
    }

    @After
    public void tearDown() {
        app.stop();
    }


}
