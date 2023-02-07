package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.*;

public class ProfileTests extends BaseTest {

    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected ProfilePage profilePage;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        toSignupPage();
        signupPage.validSignup();
        toLoginPage();
        loginPage.login(signupPage.getMyEmail(), signupPage.getMyPassword());
        loginPage.closeButton();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        toProfilePage();
    }

    @Test
    public void editProfile() {
        driverWait.until(ExpectedConditions.visibilityOf(profilePage.getProfileInputForm()));
        profilePage.fillOutForm();
        driverWait.until(ExpectedConditions.visibilityOf(profilePage.getDialogMsg()));
        Assert.assertTrue(profilePage.dialogMsgString().contains("Profile saved successfuly"));
        Assert.assertEquals(checkAttributeValue(profilePage.getCityField()), profilePage.getCity());
        Assert.assertEquals(checkAttributeValue(profilePage.getCountryField()), profilePage.getCountry());
        Assert.assertEquals(checkAttributeValue(profilePage.getFullNameField()), profilePage.getFullName());
        Assert.assertEquals(checkAttributeValue(profilePage.getPhoneField()), profilePage.getPhone());
        Assert.assertEquals(checkAttributeValue(profilePage.getGitHubField()), profilePage.getGithub());
        Assert.assertEquals(checkAttributeValue(profilePage.getTwitterField()), profilePage.getTwitter());
    }

}
