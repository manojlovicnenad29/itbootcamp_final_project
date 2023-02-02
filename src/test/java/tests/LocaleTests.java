package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class LocaleTests extends BaseTest{

    private HomePage homePage;
    @BeforeClass
    public void beforeClass() {
        super.beforeClass();
        homePage = new HomePage(driver,driverWait);
    }

    @BeforeMethod
    public void beforeMethod() {
        super.beforeMethod();
        homePage.changeLanguage();
    }
@Test
    public void setLocaleToES(){
    homePage.getEsButton().click();
    Assert.assertEquals(homePage.getHeader(),"Página de aterrizaje");
}
    @Test
    public void setLocaleToEN(){
        homePage.getEnButton().click();
        Assert.assertEquals(homePage.getHeader(),"Landing");
    }
    @Test
    public void setLocaleToFR(){
        homePage.getFrButton().click();
        Assert.assertEquals(homePage.getHeader(),"Page d'atterrissage");
    }

}
