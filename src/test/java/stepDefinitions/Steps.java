package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObjects.DataValidationPage;
import pageObjects.BasePage;
import utils.ConfigFileReader;

import java.util.concurrent.TimeUnit;

public class Steps {
    WebDriver driver;
    BasePage basePage;
    DataValidationPage dataValidationPage;
    ConfigFileReader configFileReader;

    @Before
    public void setUp() {
        configFileReader = new ConfigFileReader();
        System.setProperty("webdriver.chrome.driver", configFileReader.getDriver());
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void tearDown() {
            driver.quit();
        }

    @Given("^I am on BasePage$")
    public void iAmOnBasePage() {
        basePage = new BasePage(driver);
        basePage.navigateTo_HomePage();
    }

    @And("I am navigating to {} page")
    public void navigatingToDataValidationPage(String widget) {
        basePage.open_editingWidgetsList();
        dataValidationPage = basePage.navigateToDataValidation();
        dataValidationPage.isDataValidationPage();
    }

    @And("I am switching to {} framework")
    public void chooseFramework(String framework) {
        dataValidationPage.selectFramework();
    }

    @And("starting to work with widget")
    public void startingToWorkWithWidget() {
        basePage.switchToFrame("demoFrame");
    }

    @When("I am adding new contact")
    public void addNewContact() {
        dataValidationPage.addNewContact();
    }

    @And("enter an {} address in email field")
    public void enterAnEmailAddressInEmailField(String email) throws InterruptedException {
        dataValidationPage.isEmailFieldAvailable();
        dataValidationPage.selectEmailField();
        dataValidationPage.enterEmailAddress(email);
        dataValidationPage.saveContact();
        dataValidationPage.selectEmailField();
    }

    @Then("email field is highlighted with {}")
    public void emailFieldHighlighted(String expectedColor) throws Exception {
        String emailFrameColor = dataValidationPage.getEmailFrameColor();
        dataValidationPage.validateColor(expectedColor, emailFrameColor);
    }

    @And("I can see an error {}")
    public void isErrorMessageShown(String expectedMessage) {
        String actualMessage = dataValidationPage.getErrorMessage();
        dataValidationPage.validateMessage(expectedMessage, actualMessage);
    }
}