package tests;

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
        loginPage = new LoginPage();
    }

    @BeforeMethod
    @Override
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void VisitsTheLoginPage(){
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),urlPage);
    }

    @Test
    public void CheckInputTypes (){
    }
}
