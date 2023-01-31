package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.SignupPage;

public class SignupTests extends BaseTest{

    protected SignupPage signupPage;
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        signupPage = new SignupPage(driver,driverWait);
    }

    @BeforeMethod
    public void beforeTest(){
        driver.get("https://vue-demo.daniel-avellaneda.com/signup");
    }
    @Test
    public void visitsTheSignupPage(){
        WebElement signupButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button"));
        driverWait.until(ExpectedConditions.elementToBeClickable(signupButton));
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"));
    }
    @Test
    public void checksInputTypes(){
    WebElement email = signupPage.getEmail();
    WebElement password = signupPage.getPassword();
    WebElement confirmPassword = signupPage.getConfirmpassword();
    Assert.assertEquals(email.getAttribute("type"),"email");
    Assert.assertEquals(password.getAttribute("type"),"password");
    Assert.assertEquals(confirmPassword.getAttribute("type"),"password");
    }
@Test
    public void displaysErrorsWhenUserAlreadyExists(){
signupPage.invalidSignup();
//WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]"));
//Assert.assertTrue(errorMsg.getText().contains("E-mail already exists"));
    WebElement errorMSg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]/ul/li"));
    driverWait.until(ExpectedConditions.visibilityOf(errorMSg));
    Assert.assertEquals(errorMSg.getText(),"E-mail already exists");
    visitsTheSignupPage();
}



}
