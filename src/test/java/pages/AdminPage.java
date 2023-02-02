package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AdminPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminButton;
    @FindBy(id = "list-item-113")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement newItem;
    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMsg;

    @FindBy(className = "btnSave")
    private WebElement saveButton;


    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public void goToadminPage() {
        driverWait.until(ExpectedConditions.elementToBeClickable(adminButton));
        adminButton.click();
        driverWait.until(ExpectedConditions.elementToBeClickable(adminButton));
        citiesButton.click();

    }

    public void addNewCity(String cityName) {
        goToadminPage();
        newItem.click();
        driverWait.until(ExpectedConditions.visibilityOf(inputName));
        inputName.sendKeys(cityName);
        saveButton.click();
    }


    public WebElement getErrorMsg() {
        return errorMsg;
    }
}
