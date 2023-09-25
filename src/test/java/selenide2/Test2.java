package selenide2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class Test2 {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://the-internet.herokuapp.com";
    }

    @Test
    void hoverAndClick() {

        WebElement B = $(By.id("column-b"));

        open("/drag_and_drop");
        actions().moveToElement($("[id=column-a]")).clickAndHold().moveToElement(B).release().perform();
        $("[id=column-a]").shouldHave(text("B"));
    }
}