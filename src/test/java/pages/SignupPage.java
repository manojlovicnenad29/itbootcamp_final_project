package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
    Faker faker = new Faker();

    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[2]/span/form/div/div[5]/button")
    private WebElement signupButton;

    @FindBy(id = "name")
    private WebElement name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirmPassword")
    private WebElement confirmPassword;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMsg;

    @FindBy(xpath = "//*[@id=\"app\"]/div[4]/div/div")
    private WebElement dialogMsg;

    private final String fakeFullName = faker.name().fullName();
    private final String fakeEmail = faker.internet().emailAddress();
    private final String fakePassword = faker.internet().password();
    private final String myfullName = "Nenad Manojlovic";
    private final String myEmail = "manojlovicnenad29@gmail.com";
    private final String myPassword = "neznamsifru";

    public SignupPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getConfirmPassword() {
        return confirmPassword;
    }

    public WebElement getSignupButton() {
        return signupButton;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    public WebElement getDialogMsg() {
        return dialogMsg;
    }

    public String getMyfullName() {
        return myfullName;
    }

    public String getMyEmail() {
        return myEmail;
    }

    public String getMyPassword() {
        return myPassword;
    }

    public void invalidSignup() {
        name.clear();
        name.sendKeys("Test Test");
        email.clear();
        email.sendKeys("admin@admin.com");
        password.clear();
        password.sendKeys("123654");
        confirmPassword.sendKeys("123654");
        signupButton.click();
    }

    public void validSignup() {
        name.clear();
        name.sendKeys(myfullName);
        email.clear();
        email.sendKeys(myEmail);
        password.clear();
        password.sendKeys(myPassword);
        confirmPassword.sendKeys(myPassword);
        signupButton.click();
    }

    public void fakerSignup() {
        name.clear();
        name.sendKeys(fakeFullName);
        email.clear();
        email.sendKeys(fakeEmail);
        password.clear();
        password.sendKeys(fakePassword);
        confirmPassword.sendKeys(fakePassword);
        signupButton.click();
    }

}
