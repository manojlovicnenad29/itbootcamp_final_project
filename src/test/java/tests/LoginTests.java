package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver,driverWait);
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void visitsTheLoginPage(){
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),urlPage);
    }

    @Test
    public void checkInputTypes () {
        WebElement email = loginPage.getEmail();
        WebElement password = loginPage.getPassword();
        System.out.println(email);
        Assert.assertEquals(email.getAttribute("type"),"email");
        Assert.assertEquals(password.getAttribute("type"),"password");
    }


}
