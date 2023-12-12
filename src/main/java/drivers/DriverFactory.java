package drivers;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    public static WebDriver getDriver() throws Exception {
        if (webDriver.get() == null) {
            webDriver.set(createDriver());
        }
        return webDriver.get();
    }

    private static WebDriver createDriver() throws Exception {
        WebDriver driver = null;
//        String browserType = "chrome";

        switch (getBrowserType()) {
            case "chrome" -> {

                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/java/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);// selenium 4 feature
                driver = new ChromeDriver(chromeOptions);
                break;
            }
            case "firefox" -> {

                System.setProperty(("webdriver.gecko.driver"), System.getProperty("user.dir") + "/src/main/java/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
                driver = new FirefoxDriver(firefoxOptions);
                break;
            }
        }
        driver.manage().window().maximize();
        return driver;

    }

    private static String getBrowserType() throws Exception {
        String browserType = null;

        Properties properties = new Properties();
        FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/properties/config.properties");
        properties.load(file);
        final String browserType1 = properties.getProperty("browser").toLowerCase().trim();
        return browserType1;
    }
    public static void cleanUpDriver() {
        webDriver.get().quit();
        webDriver.remove();
    }

}
