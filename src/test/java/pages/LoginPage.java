package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    Faker faker = new Faker();

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

    private final String ADMINUSERNAME = "admin@admin.com";
    private final String ADMINPASSWORD = "12345";
    private String fakerEmail = faker.internet().emailAddress();
    private String fakerPassword = faker.internet().password();

    private final String LOGINPAGEADDRESS = "https://vue-demo.daniel-avellaneda.com/login";

    public LoginPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void clearInputFieldAndFill(WebElement webElement, String text) {
        webElement.sendKeys(Keys.CONTROL + "a", Keys.DELETE);
        webElement.sendKeys(text);
    }

    public void login(String user, String pass) {
        clearInputFieldAndFill(email, user);
        clearInputFieldAndFill(password, pass);
        loginButton.click();
    }

    public void adminLogin() {
        clearInputFieldAndFill(email, ADMINUSERNAME);
        clearInputFieldAndFill(password, ADMINPASSWORD);
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

    public String getADMINUSERNAME() {
        return ADMINUSERNAME;
    }

    public String getFakerPassword() {
        return fakerPassword;
    }

    public String getFakerEmail() {
        return fakerEmail;
    }

    public String getLOGINPAGEADDRESS() {
        return LOGINPAGEADDRESS;
    }

    public void closeButton() {
        closeButton.click();
    }

}
