package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;

public class BaseTest {

    public static WebDriver driver;
    ConfigReader config = new ConfigReader();

    @BeforeMethod
    public void setup() {

        String browser = config.getBrowser();

        if(browser.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();

            ChromeOptions options =
                    new ChromeOptions();

            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--window-size=1920,1080");

            driver =
                    new ChromeDriver(options);

        } else if(browser.equalsIgnoreCase("edge")) {

            WebDriverManager.edgedriver().setup();

            driver =
                    new EdgeDriver();
        }

        driver.manage().timeouts()
                .implicitlyWait(Duration.ofSeconds(10));

        driver.get(config.getUrl());
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {
            driver.quit();
        }
    }
}