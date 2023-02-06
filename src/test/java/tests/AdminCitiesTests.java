package tests;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
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
    protected LoginPage loginPage;
    protected AdminPage adminPage;
    protected HomePage homePage;
    protected Faker faker;
    protected String cityName;

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
        driver.get("https://vue-demo.daniel-avellaneda.com/login");
        loginPage.validlogin();
        adminPage.goToadminPage();
    }

    @Test
    public void visitsTheAdminCitiesPageAndListCities() {
        driverWait.until(ExpectedConditions.visibilityOf(adminPage.getNewItem()));
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"));
        driverWait.until(ExpectedConditions.visibilityOf(homePage.getLogoutButton()));
        Assert.assertTrue(homePage.getLogoutButton().isDisplayed());
    }

    @Test
    public void createNewCity() {
        adminPage.addNewCity(cityName);
        driverWait.until(ExpectedConditions.visibilityOf(adminPage.getErrorMsg()));
        Assert.assertTrue(adminPage.getErrorMsg().getText().contains("Saved successfully"));
    }

    @Test
    public void editCity() {
        adminPage.addNewCity(cityName);
        adminPage.editCityName(cityName);
        driverWait.until(ExpectedConditions.visibilityOf(adminPage.getErrorMsg()));
        Assert.assertTrue(adminPage.getErrorMsg().getText().contains("Saved successfully"));
    }

    @Test
    public void searchCity() {
        adminPage.addNewCity(cityName);
        adminPage.editCityName(cityName);
        adminPage.editedCitySearch(cityName);
        String expectedResult = cityName + " -edited";
        String editCityString = adminPage.getSearchResult().getText();
        Assert.assertEquals(editCityString, expectedResult);
    }

    @Test
    public void deleteCity() {
        adminPage.addNewCity(cityName);
        driverWait.until(ExpectedConditions.textToBePresentInElement(adminPage.getFirstListElement(), cityName));
        Assert.assertEquals(adminPage.getFirstListElement().getText(), cityName);
        adminPage.deleteCItyName(cityName);
        driverWait.until(ExpectedConditions.visibilityOf(adminPage.getErrorMsg()));
        Assert.assertTrue(adminPage.getErrorMsg().getText().contains("Deleted successfully"));
    }

    @AfterClass
    public void afterClass() {
        homePage.logout();
        super.afterClass();
    }

}
