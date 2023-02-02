package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BaseTest {


    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
    }

    @Test
    public void forbidsVisitsToHomeUrIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/home");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }
    @Test
    public void forbidsVisitstoProfileUrlIfNotAuthenticated() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }


}
