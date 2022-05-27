package pageobjects;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byClassName;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class WidgetsMenu {

    private static final By WIDGETS_MENU = byClassName("widgets-menu");

    private static final By WIDGET_GROUP = byClassName("group-name");

    public WidgetsMenu() {
        $(WIDGETS_MENU).shouldBe(visible);
    }

    public WidgetsMenu expand(String widgetGroup) {
        $$(WIDGET_GROUP).filterBy(visible)
                .find(exactText(widgetGroup))
                .click();
        return this;
    }

    public WidgetsMenu selectWidget(String widgetName) {
        $(byText(widgetName)).click();
        return this;
    }
}
