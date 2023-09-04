package testInterTrust;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Test2 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.intertrust.ru";
    }

    @Test
    void fillFormTest() {
        open("https://www.intertrust.ru/");
        $(".btn-search").click();
        $("[name=q]").setValue("телефон");
        $(".submit").click();
        $(".search-advanced-result .search-result").shouldHave(text("Найдено: "));
        $(".search-page").shouldHave(text("телефон"));
        $$(".navigation-pages").last().click();
        $(".search-page").shouldHave(text("телефон"));

    }
}
