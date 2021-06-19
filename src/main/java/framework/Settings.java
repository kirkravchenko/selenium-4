package framework;

import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashMap;
import java.util.Map;

public class Settings {

    public static ChromeDriver driver;

    public static void setUpBrowser() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        if (System.getProperty("device").equals("mobile")) {
            int width = 0;
            int height = 0;
            switch (System.getProperty("model")) {
                case "iphone_x":
                    width = System.getProperty("orientation").equals("landscape") ? 812 : 375;
                    height = System.getProperty("orientation").equals("landscape") ? 375 : 812;
                    break;
                case "ipad":
                    width = System.getProperty("orientation").equals("landscape") ? 1024 : 768;
                    height = System.getProperty("orientation").equals("landscape") ? 768 : 1024;
                    break;
                case "iphone_12_mini":
                    width = System.getProperty("orientation").equals("landscape") ? 780 : 360;
                    height = System.getProperty("orientation").equals("landscape") ? 360 : 780;
                    break;
            }
            driver.getDevTools().createSession();
            Map<String, Object> deviceMetrics = new HashMap<>();
            deviceMetrics.put("width", width);
            deviceMetrics.put("height", height);
            deviceMetrics.put("mobile", true);
            deviceMetrics.put("deviceScaleFactor", 50);
            driver.executeCdpCommand("Emulation.setDeviceMetricsOverride", deviceMetrics);
        }
    }
}
