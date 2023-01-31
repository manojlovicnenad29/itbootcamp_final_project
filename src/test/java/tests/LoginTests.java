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
import pages.LoginPage;

public class LoginTests extends BaseTest {

    private LoginPage loginPage;
    private Faker faker;

    @Override
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver,driverWait);
        faker = new Faker();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
    }

    @Test
    public void visitsTheLoginPage(){
        String urlPage = "https://vue-demo.daniel-avellaneda.com/login";
        Assert.assertEquals(driver.getCurrentUrl(),urlPage);
    }

    @Test
    public void checkInputTypes () {
        WebElement email = loginPage.getEmail();
        WebElement password = loginPage.getPassword();
        System.out.println(email);
        Assert.assertEquals(email.getAttribute("type"),"email");
        Assert.assertEquals(password.getAttribute("type"),"password");
    }
@Test
    public void DisplaysErrorsWhenUserDoesNotExist(){
    String email = faker.internet().emailAddress();
    String password = faker.internet().password();
    loginPage.login(email,password);
    String errorMsg = "User does not exists";
    driverWait.until(ExpectedConditions.visibilityOf(loginPage.getErrorMsg()));
    Assert.assertEquals(loginPage.getErrorMsg().getText(), errorMsg);
}


}
