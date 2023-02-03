package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProfilePage;
import pages.SignupPage;

public class ProfileTests extends BaseTest {

    protected LoginPage loginPage;
    protected SignupPage signupPage;
    protected ProfilePage profilePage;
    protected HomePage homePage;
    protected Faker faker;
    protected final String fullname = "Nenad Manojlovic";
    protected final String email = "manojlovicnenad29@gmail.com";
    protected final String password = "neznamsifru";

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        profilePage = new ProfilePage(driver, driverWait);
        signupPage = new SignupPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.manage().window().maximize();
        signupPage.validSignup(fullname, email, password);
        loginPage.login(email, password);
        driverWait.until(ExpectedConditions.visibilityOf((homePage.getLogoutButton())));
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        profilePage.isProfileInputFormDisplayed();
    }

    @Test
    public void editProfile()  {
        String fullName = faker.name().fullName();
        String phone = faker.phoneNumber().cellPhone();
        String city = "Chicago";
        String country = faker.address().country();
        String twitter = "https://twitter.com/mypicturefolder";
        String github = "https://github.com/manojlovicnenad29/";
        driverWait.until(ExpectedConditions.visibilityOf(profilePage.getProfileInputForm()));
        profilePage.filloutForm(fullName, phone, city, country, twitter, github);
        String actualResult = profilePage.dialogMsgString();
        driverWait.until(ExpectedConditions.visibilityOf(profilePage.getDialogMsg()));
        Assert.assertTrue(actualResult.contains("Profile saved successfuly"));
    }

}
