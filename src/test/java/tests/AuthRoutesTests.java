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
        toHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToProfileUrlIfNotAuthenticated() {
        toProfilePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated() {
        toCitiesPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated() {
        toUsersPage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
