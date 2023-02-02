package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;

public class AdminCitiesTests extends BaseTest {
    private LoginPage loginPage;
    private AdminPage adminPage;

    private HomePage homePage;

    private Faker faker;
    private String cityName;

    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        loginPage = new LoginPage(driver, driverWait);
        adminPage = new AdminPage(driver, driverWait);
        homePage = new HomePage(driver, driverWait);
        faker = new Faker();
        cityName = faker.address().cityName();
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        driver.manage().window().maximize();
        loginPage.validlogin();
        adminPage.goToadminPage();
    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities() {
        WebElement newItem = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button"));
        driverWait.until(ExpectedConditions.visibilityOf(newItem));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        WebElement logoutButton = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]"));
        driverWait.until(ExpectedConditions.visibilityOf(logoutButton));
        Assert.assertTrue(logoutButton.isDisplayed());
    }

    @Test
    public void createNewCity() {
        adminPage.addNewCity(cityName);
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        driverWait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Saved successfully"));
    }

    @Test
    public void edithCity() {
        adminPage.editCityName(cityName);
        WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
        driverWait.until(ExpectedConditions.visibilityOf(errorMsg));
        Assert.assertTrue(errorMsg.getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity(){
        createNewCity();
        edithCity();
        WebElement editCity = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]"));
        String expectedResult = cityName + " -edited";
        String editCityString = editCity.getText();
        Assert.assertEquals(expectedResult, editCityString);
    }

@Test
public void deleteCity()   {
adminPage.deleteCItyName(cityName);
    WebElement errorMsg = driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]"));
    driverWait.until(ExpectedConditions.visibilityOf(errorMsg));
    Assert.assertTrue(errorMsg.getText().contains("Deleted successfully"));
}
    @AfterClass
    public void afterClass() {
        homePage.logout();
        super.afterClass();
    }

}
