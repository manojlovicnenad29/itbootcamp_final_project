package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    protected LoginPage loginPage;
    protected Faker faker;
    protected HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        faker = new Faker();
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void visitsTheLoginPage() {
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), urlPage);
    }

    @Test
    public void checkInputTypes() {
        WebElement email = loginPage.getEmail();
        WebElement password = loginPage.getPassword();
        System.out.println(email);
        Assert.assertEquals(email.getAttribute("type"), "email");
        Assert.assertEquals(password.getAttribute("type"), "password");
    }

    @Test
    public void displaysErrorsWhenUserDoesNotExist() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("User does not exists"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = faker.internet().password();
        loginPage.login(email, password);
        Assert.assertTrue(loginPage.getErrorMsg().getText().contains("Wrong password"));
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"));
    }

    @Test
    public void validLogin() {
        loginPage.validlogin();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"));
    }

    @Test
    public void logout() {
        validLogin();
        driverWait.until(ExpectedConditions.elementToBeClickable(homePage.getLogoutButton()));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
        homePage.logout();
        visitsTheLoginPage();
    }
}
