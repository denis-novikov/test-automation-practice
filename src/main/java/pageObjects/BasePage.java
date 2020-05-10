package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ConfigFileReader;

import java.util.List;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    ConfigFileReader configFileReader;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.XPATH, using = "//div[@class='widgets-menu-list']")
    private WebElement widgets_menu;

    @FindBy(how = How.XPATH, using = "//*[contains(text(),'Editing')]")
    private WebElement editingWidgets;

    @FindBy(how = How.CLASS_NAME, using = "widgets-menu-list")
    private List<WebElement> widgetList;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Data Validation')]")
    private WebElement dataValidationWidget;

    @FindBy(how = How.XPATH, using = "/html/body/div[1]/div[2]/div/div[1]/div/div[1]/div/div[1]/div[2]/div[1]/ul/li[1]/ul/li[4]/ul/li/a")
    private List<WebElement> editingWidgetList;

    @FindBy(how = How.XPATH, using = "//a[contains(@onclick, 'Angular')]")
    private WebElement btn_Angular;


    public void selectFramework() {
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(btn_Angular));
        btn_Angular.click();
        btn_Angular.isEnabled();
    }


    public void open_editingWidgetsList() {
        editingWidgets.click();
    }


    public DataValidationPage navigateToDataValidation() {
        dataValidationWidget.click();
        return new DataValidationPage(driver);
    }


    public void validateColor(String expectedColor, String actualColor) throws Exception {
        if (expectedColor.equalsIgnoreCase("red")) {
            Assert.assertEquals("Frame color is not red", "#d9534f", actualColor);
        } else if (expectedColor.equalsIgnoreCase("green")) {
            Assert.assertEquals("Frame color is not green", "#5cb85c", actualColor);
        } else {
            throw new Exception("Selected color is not available");
        }
    }


    public void validateMessage(String expectedMessage, String actualMessage) {
        Assert.assertEquals("Actual message is different from expected", expectedMessage, actualMessage);
    }


    public void navigateTo_HomePage() {
        configFileReader = new ConfigFileReader();
        driver.get(configFileReader.getAppUrl());
    }


    public WebDriverWait switchToFrame(String frameId) {
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameId));
        return wait;
    }


    public String getPseudoElement(String script) {
        js = (JavascriptExecutor) driver;
        return (String) js.executeScript(script);
    }
}