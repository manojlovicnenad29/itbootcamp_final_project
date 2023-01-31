package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;

public abstract class BasePage {
    protected WebDriver driver;
    protected WebDriverWait driverWait;
    @BeforeClass
    public void beforeClass(WebDriver driver, WebDriverWait driverWait) {
        this.driver = driver;
        this.driverWait = driverWait;
        PageFactory.initElements(this.driver, this);
    }
    @BeforeClass
    public void beforeMethod(){

    }
}
