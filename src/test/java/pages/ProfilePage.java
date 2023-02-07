package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage extends BasePage {
    protected Faker faker = new Faker();
    private String fullName = faker.name().fullName();
    private String phone = faker.phoneNumber().cellPhone();
    private String country = faker.address().country();
    private String twitter = "https://twitter.com/" + faker.address().firstName().toLowerCase();
    private String github = "https://github.com/" + faker.address().firstName().toLowerCase();
    private String city = "Chicago";
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

    public void clearInputFieldAndFill(WebElement webElement, String text) {
        webElement.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        webElement.sendKeys(text);
    }

    public void fillOutForm() {
        clearInputFieldAndFill(cityField, city);
        cityField.sendKeys(Keys.TAB);
        clearInputFieldAndFill(phoneField, phone);
        clearInputFieldAndFill(fullNameField, fullName);
        clearInputFieldAndFill(countryField, country);
        clearInputFieldAndFill(twitterField, twitter);
        clearInputFieldAndFill(gitHubField, github);
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

    public String getFullName() {
        return fullName;
    }

    public String getPhone() {
        return phone;
    }

    public String getCountry() {
        return country;
    }

    public String getTwitter() {
        return twitter;
    }

    public String getGithub() {
        return github;
    }

    public String getCity() {
        return city;
    }
}
