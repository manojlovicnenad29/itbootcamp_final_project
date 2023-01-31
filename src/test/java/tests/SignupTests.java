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


}
