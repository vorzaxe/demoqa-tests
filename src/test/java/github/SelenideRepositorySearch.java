package github;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class SelenideRepositorySearch {

    @Test

    void shouldFindSelenideRepositoryAtTheTop() {

        // открыть главную страницу
        Selenide.open("https://github.com/");
        // ввести в поле поиска selenide и нажать enter
        $("[data-target='qbsearch-input.inputButtonText']").click();
        $("#query-builder-test").setValue("selenide").pressEnter();
        // кликнуть на первый репозиторий из списка найденных
        $(".search-match").click();
        // проверка: заголовок selenide/selenide
        $("#repository-container-header").shouldHave(text("selenide / selenide"));
        sleep(5000);

    }
}