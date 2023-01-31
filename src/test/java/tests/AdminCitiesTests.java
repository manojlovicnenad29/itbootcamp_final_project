package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

import java.security.spec.ECPoint;

public class AdminCitiesTests extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;

    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        adminPage = new AdminPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();

    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities() {
        driver.manage().window().maximize();
        loginPage.validlogin();
        adminPage.goToadminPage();
        WebElement newItem = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button"));
        driverWait.until(ExpectedConditions.visibilityOf(newItem));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        driverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        Assert.assertTrue(logoutButton.isDisplayed());

    }
}
