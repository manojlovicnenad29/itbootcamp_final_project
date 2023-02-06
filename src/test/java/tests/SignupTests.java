package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTests extends BaseTest {
    protected SignupPage signupPage;
    protected Faker faker;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signupPage = new SignupPage(driver, driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeTest() {
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }

    @Test
    public void visitsTheSignupPage() {
        driverWait.until(ExpectedConditions.elementToBeClickable(signupPage.getSignupButton()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }

    @Test
    public void checksInputTypes() {
        WebElement email = signupPage.getEmail();
        WebElement password = signupPage.getPassword();
        WebElement confirmPassword = signupPage.getConfirmPassword();
        Assert.assertEquals(email.getAttribute("type"), "email");
        Assert.assertEquals(password.getAttribute("type"), "password");
        Assert.assertEquals(confirmPassword.getAttribute("type"), "password");
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
        String fullName = faker.name().fullName();
        String email = faker.internet().emailAddress();
        String password = faker.internet().password();
        signupPage.validSignup(fullName, email, password);
        driverWait.until(ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div"), "IMPORTANT: Verify your account"));
        WebElement dialogMsg = driverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"app\"]/div[4]/div/div/div[1]")));
        Assert.assertEquals(dialogMsg.getText(), "IMPORTANT: Verify your account");
    }

}
