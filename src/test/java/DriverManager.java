import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;


public class DriverManager {

    protected SoftAssert softAssert = new SoftAssert();
    protected WebDriver driver;
    protected WebDriverWait wait;

    @NotNull
    @Contract("_ -> new")
    public static WebDriver getDriver(@NotNull String browser) {
        switch (browser) {
            case "firefox":
                System.setProperty(
                        "webdriver.gecko.driver", System.getProperty("user.dir") + "//resources/geckodriver.exe");
                return new FirefoxDriver();
            case "edge":
                System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "//resources/MicrosoftWebDriver.exe");
                return new EdgeDriver();
            case "headless-chrome":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources/chromedriver.exe");
                ChromeOptions options = new ChromeOptions();
                options.addArguments("headless");
                options.addArguments("window-size=800*600");
                return new ChromeDriver(options);
            case "remote-chrome":
                ChromeOptions optionsRemote = new ChromeOptions();
                        try {
                            return new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), optionsRemote);
                        } catch(MalformedURLException e){
                            e.printStackTrace();
                        }
                        return null;
            case "mobile":
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources/chromedriver.exe");
                Map<String,String> mobileEmulation = new HashMap<>();
                mobileEmulation.put("device name", "Iphone 6");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
                return new ChromeDriver(chromeOptions);
            case "chrome":
            default:
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "//resources/chromedriver.exe");
                return new ChromeDriver();
        }
    }

    @BeforeClass
    @Parameters("selenium browser")
    public void setup(@Optional("chrome")String browser){
        driver = getDriver(browser);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver,10);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}