package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    public WebElement getLogoutButton() {
        return logoutButton;
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[2]")
    private WebElement logoutButton;

    @FindBy(className = "btnLocaleActivation")
    private WebElement changeLanguageButton;

    @FindBy(className = "btnES")
    private WebElement esButton;

    @FindBy(className = "btnEN")
    private WebElement enButton;

    @FindBy(className = "btnFR")
    private WebElement frButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/h1")
    private WebElement header;

    public HomePage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void logout() {
        logoutButton.click();
    }

    public void changeLanguage() {
        changeLanguageButton.click();
    }

    public WebElement getEsButton() {
        return esButton;
    }

    public WebElement getEnButton() {
        return enButton;
    }

    public WebElement getFrButton() {
        return frButton;
    }

    public String getHeader() {
        return header.getText();
    }
}
