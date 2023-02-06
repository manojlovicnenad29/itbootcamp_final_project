package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignupPage extends BasePage {
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

    public void validSignup(String fullName, String emailStr, String passwordStr) {
        name.clear();
        name.sendKeys(fullName);
        email.clear();
        email.sendKeys(emailStr);
        password.clear();
        password.sendKeys(passwordStr);
        confirmPassword.sendKeys(passwordStr);
        signupButton.click();
    }

}
