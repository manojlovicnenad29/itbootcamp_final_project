package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BaseTest {
    protected WebDriverWait driverWait;

    protected WebDriver driver;
    protected String baseUrl = "https://vue-demo.daniel-avellaneda.com";

    @BeforeClass
    public void beforeClass() {
//        System.setProperty("webdriver.chrome.driver", "C:\\BC\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds((15)));
        driverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    public void toLoginPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    public void toHomePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
    }

    public void toProfilePage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
    }

    public void toCitiesPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/cities");
    }

    public void toUsersPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/admin/users");
    }

    public void toSignupPage() {
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }

    public String checkAttributeValue(WebElement webElement) {
    return webElement.getAttribute("value");
    }
    public String checkAttributeType(WebElement webElement) {
        return webElement.getAttribute("type");
    }
    @AfterClass
    public void afterClass() {
        driver.quit();
    }

}
