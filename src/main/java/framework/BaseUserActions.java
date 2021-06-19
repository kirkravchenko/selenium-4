package framework;

import org.openqa.selenium.JavascriptExecutor;

import static framework.Settings.driver;

public class BaseUserActions {

    public void srollDownSmooth() {
        Long height = (Long) ((JavascriptExecutor) driver).executeScript("return document.body.scrollHeight");
        for (int i = 0; i < height / 10; i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,10)", "");
        }
    }
}
