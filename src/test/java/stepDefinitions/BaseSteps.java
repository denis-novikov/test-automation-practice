package stepDefinitions;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import pageobjects.DataValidationPage;
import pageobjects.FrameworkSelector;
import pageobjects.WidgetsMenu;
import utils.ConfigFileReader;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseSteps {

    @Before
    public void setUp() {
        Configuration.baseUrl = new ConfigFileReader().getAppUrl();
        Configuration.timeout = 20000;
    }

    @After
    public void tearDown() {
        closeWebDriver();
    }

    @Given("^Widgets Gallery Page is open")
    public void widgetsGalleryPage() {
        open("/");
    }

    @And("User is navigating to {string} > {string} page")
    public void navigatingToPage(String widgetCategory, String widgetName) {
        new WidgetsMenu().expand(widgetCategory)
                .selectWidget(widgetName);
    }

    @And("select {string} framework")
    public void selectFramework(String frameworkName) {
        new FrameworkSelector().selectFramework(frameworkName);
    }

    @Given("switch to demo frame")
    public void switchToFrame() {
        new DataValidationPage().switchFocusToFrame();
    }
}