package stepDefinitions;

import enums.Color;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageobjects.DataValidationPage;


public class DataValidationWidgetSteps {

    @When("user adds new contact")
    public void userAddsNewContact() {
        new DataValidationPage().addNewContact();
    }

    @When("enter an {string} address in email field")
    public void enterAnEmail(String email) {
        new DataValidationPage().inputDataIntoInsertedRow("Email", email);
    }

    @Then("email field is highlighted with {}")
    public void emailFieldIsHighlighted(Color color) {
        new DataValidationPage().isCellHighlighted(color);
    }

    @Then("error {string} is shown")
    public void errorMessageIsShown(String message) {
        new DataValidationPage().isMessageShown(message);
    }
}
