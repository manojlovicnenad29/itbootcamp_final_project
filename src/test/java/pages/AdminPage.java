package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AdminPage extends BasePage {
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/div/header/div/div[3]/button[1]/span")
    private WebElement adminButton;
    @FindBy(id = "list-item-113")
    private WebElement citiesButton;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[1]/div[3]/form/div[1]/button")
    private WebElement newItem;
    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr[1]/td[2]")
    private WebElement firstListElement;

    @FindBy(id = "name")
    private WebElement inputName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[3]/div/div/div/div/div[1]")
    private WebElement errorMsg;

    @FindBy(className = "btnSave")
    private WebElement saveButton;

    @FindBy(id = "search")
    private WebElement searchBar;
    @FindBy(xpath = "//*[@id=\"edit\"]")
    private WebElement editButton;

    @FindBy(id = "name")
    private WebElement editCityName;

    @FindBy(xpath = "//*[@id=\"app\"]/div[1]/main/div/div[2]/div/div[1]/div[2]/table/tbody/tr/td[2]")
    WebElement searchResult;

    @FindBy(id = "delete")
    private WebElement trashButton;

    @FindBy(xpath = "/html/body/div/div[10]/div/div/div[2]/button[2]/span")
    private WebElement deleteButton;

    @FindBy(css = "#app > div.v-dialog__content.v-dialog__content--active > div > div > div.v-card__actions > button.v-btn.v-btn--text.theme--light.v-size--default.red--text.text--lighten3")
    private WebElement deleteButton2;


    public AdminPage(WebDriver driver, WebDriverWait driverWait) {
        super(driver, driverWait);
    }

    public WebElement getSearchResult() {
        return searchResult;
    }

    public WebElement getNewItem() {
        return newItem;
    }

    public WebElement getFirstListElement() {
        return firstListElement;
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

    public void editCityName(String cityName) {
        searchBar.sendKeys(cityName);
        editButton.click();
        editCityName.sendKeys(Keys.SPACE, "-edited");
        driverWait.until(ExpectedConditions.elementToBeClickable(saveButton));
        saveButton.click();
    }

    public void deleteCItyName(String cityName) {
        searchBar.sendKeys(cityName);
        driverWait.until(ExpectedConditions.textToBePresentInElement(searchResult, cityName));
        trashButton.click();
        driverWait.until(ExpectedConditions.visibilityOf(deleteButton2));
        driverWait.until(ExpectedConditions.elementToBeClickable(deleteButton2));
        deleteButton2.click();
    }

}
