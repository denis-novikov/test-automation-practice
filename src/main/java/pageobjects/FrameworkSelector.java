package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class FrameworkSelector {

    private static final By FRAMEWORK_MENU = byClassName("approaches");

    private static final By FRAMEWORK = byClassName("approach-tab");

    public FrameworkSelector() {
        $(FRAMEWORK_MENU).shouldBe(visible);
    }

    public void selectFramework(String frameworkName) {
        $$(FRAMEWORK).find(exactText(frameworkName))
                .click();
    }
}
