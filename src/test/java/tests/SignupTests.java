package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTests extends BaseTest {
    protected SignupPage signupPage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signupPage = new SignupPage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeTest() {
        toSignupPage();
    }

    @Test
    public void visitsTheSignupPage() {
        driverWait.until(ExpectedConditions.elementToBeClickable(signupPage.getSignupButton()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void checksInputTypes() {
        Assert.assertEquals(checkAttributeType(signupPage.getEmail()), "email");
        Assert.assertEquals(checkAttributeType(signupPage.getPassword()), "password");
        Assert.assertEquals(checkAttributeType(signupPage.getConfirmPassword()), "password");
    }

    @Test
    public void displaysErrorsWhenUserAlreadyExists() {
        signupPage.invalidSignup();
        driverWait.until(ExpectedConditions.visibilityOf(signupPage.getErrorMsg()));
        Assert.assertTrue(signupPage.getErrorMsg().getText().contains("E-mail already exists"));
        visitsTheSignupPage();
    }

    @Test
    public void signup() {
        signupPage.fakerSignup();
        driverWait.until(ExpectedConditions.textToBePresentInElement(signupPage.getDialogMsg(), "IMPORTANT: Verify your account"));
        Assert.assertTrue(signupPage.getDialogMsg().getText().contains("IMPORTANT: Verify your account"));
    }
    @Test
    public void signup1() {
        signupPage.validSignup();
        driverWait.until(ExpectedConditions.textToBePresentInElement(signupPage.getDialogMsg(), "IMPORTANT: Verify your account"));
        Assert.assertTrue(signupPage.getDialogMsg().getText().contains("IMPORTANT: Verify your account"));
    }
}
