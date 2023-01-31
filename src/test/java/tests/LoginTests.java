package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private Faker faker;
    private HomePage homePage;

    @Override
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
    public void DisplaysErrorsWhenUserDoesNotExist() {
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        loginPage.login(email, password);
        String errorMsg = "User does not exists";
        driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
        Assert.assertEquals(loginPage.getErrorMsg().getText(), errorMsg);
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), urlPage);
    }

    @Test
    public void displaysErrorsWhenPasswordIsWrong() {
        String email = "admin@admin.com";
        String password = faker.internet().password();
        loginPage.login(email, password);
        String errorMsg = "Wrong password";
        Assert.assertEquals(loginPage.getErrorMsg().getText(), errorMsg);
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(), urlPage);
    }

    @Test
    public void validLogin() {
        loginPage.login("admin@admin.com", "12345");
        String expectedResult = "https://vue-demo.daniel-avellaneda.com/home";
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        driverWait.until(ExpectedConditions.elementToBeClickable(logout));
        Assert.assertTrue(driver.getCurrentUrl().contains(expectedResult));
    }

    @Test
    public void logout() {
        validLogin();
        WebElement logout = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        driverWait.until(ExpectedConditions.elementToBeClickable(logout));
        Assert.assertTrue(logout.isDisplayed());
        homePage.logout();
        visitsTheLoginPage();
    }


}
