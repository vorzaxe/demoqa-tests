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
        String userName = "Xenia Spectra";
        String eMail = "test_sp@mail.ru";

        open("/text-box");
        $(".text-center").shouldHave(text("Text Box")); //класс можно заменить на .

        $("#userName").setValue(userName); //id можно заменить на #
        $("#userEmail").setValue(eMail);
        $("#currentAddress").setValue("Russia, Omsk city, Severnaya 30-ya, 38/2");
        $("#permanentAddress").setValue("USA, Nevada State, Vernon, Main St, 9");
        $("#submit").click();

        $("#output").shouldBe(visible);
        $("#output").$("#name").shouldHave(text(userName));
        $("#output #email").shouldHave(text(eMail));

    }

}