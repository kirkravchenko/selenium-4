import framework.BaseUserActions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static framework.Settings.driver;
import static framework.Settings.setUpBrowser;

public class Main {


    @BeforeClass
    public void setUp() {
        setUpBrowser();
    }

    @Test
    public void first() {
        driver.get("https://www.everydayhealth.com/");
        new BaseUserActions().srollDownSmooth();
    }


    @AfterClass
    public void after() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }
}
