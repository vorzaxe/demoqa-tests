package ru.intertrust;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
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
        $(byText("О компании")).click();

        $(".sidebar-list").shouldHave(text("История компании"));
        $(".sidebar-list").shouldHave(text("Руководство"));
        $(".sidebar-list").shouldHave(text("Сертификаты и лицензии"));
        $(".sidebar-list").shouldHave(text("Наши клиенты"));
        $(".sidebar-list").shouldHave(text("Отзывы клиентов"));
        $(".sidebar-list").shouldHave(text("Строим открыто"));
        $(".sidebar-list").shouldHave(text("Мы помогаем"));
        $(".sidebar-list").shouldHave(text("Задать вопрос"));

        $(".sidebar-list").$(byText("История компании")).click();
        $(".sidebar-list").$(byText("Руководство")).click();
        $(".sidebar-list").$(byText("Сертификаты и лицензии")).click();
        $(".sidebar-list").$(byText("Наши клиенты")).click();
        $(".sidebar-list").$(byText("Отзывы клиентов")).click();
        $(".sidebar-list").$(byText("Строим открыто")).click();
        $(".sidebar-list").$(byText("Мы помогаем")).click();
        $(".sidebar-list").$(byText("Задать вопрос")).click();
    }
}
