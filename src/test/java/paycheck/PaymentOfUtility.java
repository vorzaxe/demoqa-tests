package paycheck;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byTitle;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class PaymentOfUtility {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://tbcpay.ge/en";
    }

    @Test
    void water() {
        open("/services/wyali/batumis-wyali");
        $(".input-container").$(".h-10").setValue("274/14-97");
        $(".input-container").$(".h-10").pressEnter();
        $(".grid").$(".text-lg").shouldHave(text("0.00"));
    }
    @Test
    void EP() {
        open("/services/komunaluri-gadasaxadebi/uccepgeorgia");
        $(".input-container").$(".h-10").setValue("6011118731");
        $(".input-container").$(".h-10").pressEnter();
        $(".grid").$(".text-lg").shouldHave(text("0.00"));
    }
    @Test
    void socar() {
        open("/services/bunebrivi-airi/socar-gazi");
        $(".relative").$(byText("Select a service")).click();
        $(byTitle("Socar Gas")).click();
        $(".input-container").$(".h-10").setValue("001117049255");
        $(".input-container").$(".h-10").pressEnter();
        $(".grid").$(".text-lg").shouldHave(text("0.00"));
    }
}
