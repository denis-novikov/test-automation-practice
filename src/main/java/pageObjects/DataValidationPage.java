package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DataValidationPage extends BasePage {

    public DataValidationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//i[@class='dx-icon dx-icon-edit-button-addrow']")
    private WebElement btn_addContact;

    @FindBy(how = How.XPATH, using = "//tr[@class='dx-row dx-data-row dx-column-lines dx-row-inserted']//td[5]")
    private WebElement txtBox_emailAddress;

    @FindBy(how = How.XPATH, using = "//input[@class='dx-texteditor-input']")
    private WebElement txtBoxEditor_emailAddress;

    @FindBy(how = How.XPATH, using = "//i[@class='dx-icon dx-icon-edit-button-save']")
    private WebElement btn_saveContact;

    @FindBy(how = How.XPATH, using = "//i[@class='dx-icon dx-icon-edit-button-save']")
    private WebElement getEmailFrameColor;

    @FindBy(how = How.XPATH, using = "//div[@class='dx-overlay-content dx-resizable']")
    private WebElement errorMessageBox;

    @FindBy(how = How.XPATH, using = "//div[contains(text(),'Email')]")
    private WebElement emailField;


    public String getErrorMessage() {
        return errorMessageBox.getText();
    }

    public void addNewContact() {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(btn_addContact));
        btn_addContact.click();
    }

    public void selectEmailField(){
        txtBox_emailAddress.click();
    }

    public void enterEmailAddress(String email) {
        txtBoxEditor_emailAddress.sendKeys(email);
        txtBoxEditor_emailAddress.sendKeys(Keys.ENTER);
    }

    public void saveContact() {
        btn_saveContact.click();
    }

    public String getEmailFrameColor() {
        String script = "return window.getComputedStyle(document.querySelector('#gridContainer > div > div.dx-datagrid-rowsview.dx-datagrid-nowrap.dx-scrollable.dx-visibility-change-handler.dx-scrollable-both.dx-scrollable-simulated > div > div > div.dx-scrollable-content > div > table > tbody > tr.dx-row.dx-data-row.dx-column-lines.dx-row-inserted > td:nth-child(5) > div'),':after').getPropertyValue('border-color')";
        String content = getPseudoElement(script);
        return Color.fromString(content).asHex();
    }

    public void isDataValidationPage() {
        driver.getTitle().equals("Data Validation");
    }

    public void isEmailFieldAvailable() {
        emailField.isDisplayed();
    }
}