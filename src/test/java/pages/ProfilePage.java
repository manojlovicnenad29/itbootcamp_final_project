package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ProfilePage extends BasePage {

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form")
    private WebElement profileInputForm;

    @FindBy(id = "name")
    private WebElement fullNameField;
    @FindBy(id = "phone")
    private WebElement phoneField;
    @FindBy(id = "city")
    private WebElement cityField;
    @FindBy(id = "country")
    private WebElement countryField;
    @FindBy(id = "urlTwitter")
    private WebElement twitterField;
    @FindBy(id = "urlGitHub")
    private WebElement gitHubField;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[2]/span/form/div/div/div[8]/button")
    private WebElement saveButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]")
    private WebElement dialogMsg;

    public ProfilePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public String dialogMsgString() {
        return dialogMsg.getText();
    }

    public WebElement getDialogMsg() {
        return dialogMsg;
    }

    public boolean isProfileInputFormDisplayed() {
        driver.get("https://vue-demo.daniel-avellaneda.com/profile");
        if (profileInputForm.isDisplayed())
            return true;
        else return false;
    }

    public void filloutForm(String fullName, String phone, String city, String country, String twitter, String gitHub) {
        fullNameField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        fullNameField.sendKeys(fullName);
        phoneField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        phoneField.sendKeys(phone);
        cityField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        cityField.sendKeys(city);
        cityField.sendKeys(Keys.ENTER, Keys.ARROW_DOWN, Keys.ENTER);
        countryField.click();
        countryField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        countryField.sendKeys(country);
        twitterField.clear();
        twitterField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        twitterField.sendKeys(twitter);
        gitHubField.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        gitHubField.clear();
        gitHubField.sendKeys(gitHub);
        saveButton.click();
    }

    public WebElement getProfileInputForm() {
        return profileInputForm;
    }

    public WebElement getFullNameField() {
        return fullNameField;
    }

    public WebElement getPhoneField() {
        return phoneField;
    }

    public WebElement getCityField() {
        return cityField;
    }

    public WebElement getCountryField() {
        return countryField;
    }

    public WebElement getTwitterField() {
        return twitterField;
    }

    public WebElement getGitHubField() {
        return gitHubField;
    }
}
