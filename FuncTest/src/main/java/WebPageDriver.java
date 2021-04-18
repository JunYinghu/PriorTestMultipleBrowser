import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.File;

public class WebPageDriver {

    public static WebDriver driver;

    public void setDriver(String browserType) {

        if (browserType.contentEquals("FF")) {
            String driverPath = System.getProperty("user.dir") + File.separator + "driver" + File.separator + "geckodriver.exe";
            System.setProperty("webdriver.gecko.driver", driverPath);
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else if (browserType.contentEquals("CD")) {
            String driverPath = System.getProperty("user.dir") + File.separator + "driver" + File.separator + "chromedriver.exe";
            System.setProperty("webdriver.chrome.driver", driverPath);
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        }

    }
}

