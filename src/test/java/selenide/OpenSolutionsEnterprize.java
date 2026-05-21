package selenide;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class OpenSolutionsEnterprize {

    @Test

    void openSolutionsEnterprize() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $(byText("Enterprises")).click();
        $(".Primer_Brand__Heading-module__Heading___IVpmp").shouldHave(Condition.text("The AI-powered developer platform for the agent-ready enterprise"));
    }
}
