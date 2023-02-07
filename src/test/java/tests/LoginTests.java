package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    protected LoginPage loginPage;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        toLoginPage();
    }

    @Test
    public void visitsTheLoginPage() {
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.getLOGINPAGEADDRESS());
    }

    @Test
    public void checkInputTypes() {
        Assert.assertEquals(checkAttributeType(loginPage.getEmail()), "email");
        Assert.assertEquals(checkAttributeType(loginPage.getPassword()), "password");
    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        loginPage.login(loginPage.getFakerEmail(), loginPage.getFakerPassword());
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        loginPage.login(loginPage.getADMINUSERNAME(), loginPage.getFakerPassword());
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void validLogin() {
        loginPage.adminLogin();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void logout() {
        loginPage.adminLogin();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.logout();
        visitsTheLoginPage();
        toHomePage();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

}
