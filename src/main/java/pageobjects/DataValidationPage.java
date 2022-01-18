package pageobjects;

import com.codeborne.selenide.SelenideElement;
import enums.Color;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;


public class DataValidationPage {

    private static final By DATA_VALIDATION_FRAME = byId("demoFrame");

    private static final By INSERTED_ROW = byClassName("dx-row-inserted");

    private static final By LOADING_INDICATOR = byClassName("load-panel");

    private static final By INVALID_MESSAGE = byClassName("dx-overlay-content");

    private static final SelenideElement EMAIL_CELL = $(INSERTED_ROW).$(byAttribute("aria-colindex", "5"));

    private static final By ADD_CONTACT_BTN = byClassName("dx-icon-edit-button-addrow");

    public DataValidationPage() {
        $(LOADING_INDICATOR).shouldBe(hidden);
    }

    public void addNewContact() {
        $(ADD_CONTACT_BTN).scrollIntoView(false)
                .shouldBe(visible)
                .click();
        $(INSERTED_ROW).should(appear);
    }

    public void inputDataIntoInsertedRow(String cellName, String data) {
        selectCell(cellName).val(data)
                .pressTab();
    }

    private SelenideElement selectCell(String column) {
        switch (column) {
            case "First Name":
                break;
            case "Last Name":
                break;
            case "Email":
                EMAIL_CELL.click();
                break;
            default:
                throw new IllegalArgumentException(column + " column is not available");
        }
        return $(byClassName("dx-texteditor-input")).shouldBe(visible);
    }

    public void switchFocusToFrame() {
        switchTo().frame($(DATA_VALIDATION_FRAME));
    }

    public void isCellHighlighted(Color color) {
        EMAIL_CELL.shouldHave(pseudo(":after", "border-color", color.getRgba()));
    }

    public void isMessageShown(String message) {
        EMAIL_CELL.click();
        $(INVALID_MESSAGE).shouldHave(text(message));
    }
}