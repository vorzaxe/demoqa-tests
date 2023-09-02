package testInterTrust;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class Test1 {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://www.intertrust.ru";
    }

    @Test
    void fillFormTest() {
        open("https://www.intertrust.ru/");

        $(".header-nav__menu").shouldHave(text("О компании"));

        // $(by("#text", "О компании")).click();

//        $(".header-nav row").shouldHave(text("ИСТОРИЯ КОМПАНИИ"));
//        $(".header-nav row").shouldHave(text("РУКОВОДСТВО"));
//        $(".header-nav row").shouldHave(text("СЕРТИФИКАТЫ И ЛИЦЕНЗИИ"));
//        $(".header-nav row").shouldHave(text("НАШИ КЛИЕНТЫ"));
//        $(".header-nav row").shouldHave(text("ОТЗЫВЫ КЛИЕНТОВ"));
//        $(".header-nav row").shouldHave(text("СТРОИМ ОТКРЫТО"));
//        $(".header-nav row").shouldHave(text("МЫ ПОМОГАЕМ"));
//        $(".header-nav row").shouldHave(text("ЗАДАТЬ ВОПРОС"));

//        $("#submit").click();
//
//        $("#output").shouldBe(visible);
//        $("#output").$("#name").shouldHave((text("Xenia Spectra")));
//        $("#output #email").shouldHave((text("test_sp@mail.ru")));

    }
}
