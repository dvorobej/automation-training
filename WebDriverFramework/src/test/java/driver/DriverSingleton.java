package driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class DriverSingleton {
    private static WebDriver driver;

    protected final Logger logger = LogManager.getRootLogger();

    private DriverSingleton() {
    }

    public static WebDriver getDriver() {
        if (null == driver) {
            switch (System.getProperty("browser")) {
                case "firefox": {
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("--disable-extensions");
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--window-size=1920,1080");
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver(options);
                    logger.info("Start firefox driver");
                }
                default: {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-extensions");
                    options.addArguments("--headless");
                    options.addArguments("--disable-gpu");
                    options.addArguments("--no-sandbox");
                    options.addArguments("--window-size=1920,1080");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    logger.info("Start chrome driver");
                }
            }
        }

        return driver;
    }

    public static void closeDriver(){
        driver.quit();
        driver = null;
    }
}
