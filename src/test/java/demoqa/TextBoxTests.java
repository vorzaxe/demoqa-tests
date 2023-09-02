package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void fillFormTest() {
        open("https://demoqa.com/text-box");
        $(".main-header").shouldHave(text("Text Box")); //класс можно заменить на .

        $("#userName").setValue("Xenia Spectra"); //id можно заменить на #
        $("#userEmail").setValue("test_sp@mail.ru");
        $("#currentAddress").setValue("Russia, Omsk city, Severnaya 30-ya, 45/1");
        $("#permanentAddress").setValue("USA, Nevada State, Vernon, Main St, 5");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave((text("Xenia Spectra")));
        $("#output #email").shouldHave((text("test_sp@mail.ru")));

    }

}