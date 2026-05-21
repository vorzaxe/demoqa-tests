package github;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BestContributorToSelenide {

    @Test
    void solntsevShouldBeTheTopContributor() {
        Configuration.browserSize="1920x1080";
        // открыть страницу репозитория селенида
        open("https://github.com/selenide/selenide");
        // подвести мышку к первому автору из блока contributors
        $(".BorderGrid").$(byText("Contributors")).ancestor(".BorderGrid-row")
                .$$("ul li").first().hover();
        // проверка: во всплывающем окне есть текст Andrei Solncev
        $(".Popover").shouldHave(text("Andrei Solntsev"));
        // если Popover несколько, и только один видимый, можно сделать так:
        // $$(".Popover").findBy(visible).shouldHave(text("Andrei Solntsev"));
        sleep(5000);
    }
}
