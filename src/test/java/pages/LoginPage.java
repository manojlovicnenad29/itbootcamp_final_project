package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    @FindBy(id = "email")
    private WebElement email;
    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "btnClose")
    private WebElement closeButton;
    @FindBy(xpath = "//*[@id=\"app\"]/div/main/div/div[2]/div/div/div[3]/span/form/div/div[3]/button/span")
    private WebElement loginButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div/div[4]/div/div/div/div/div[1]/ul/li")
    private WebElement errorMsg;


    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void login(String user, String pass) {
        email.clear();
        email.sendKeys(user);
        password.clear();
        password.sendKeys(pass);
        loginButton.click();
    }

    public WebElement getEmail() {
        return email;
    }

    public WebElement getPassword() {
        return password;
    }

    public WebElement getErrorMsg() {
        return errorMsg;
    }

    public void validlogin() {
        email.clear();
        email.sendKeys("admin@admin.com");
        password.clear();
        password.sendKeys("12345");
        loginButton.click();
    }

    public void closeButton() {
        closeButton.click();
    }

}
