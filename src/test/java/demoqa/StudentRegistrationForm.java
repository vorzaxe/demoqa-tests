package demoqa;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class StudentRegistrationForm {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormRegistration() {

        String userFirstName = "Xenia";
        String userLastName = "Vorza";
        String userEmail = "xeniavorza@gmail.com";
        String userGender = "Female";
        String userNumber = "8987546345";
        String month = "June";
        String year = "1992";
        String currentAddress = "Georgia, Batumi, Griboedova, 13";
        String userFileName = "1394695586_1144072832.jpg";
        String userState = "Uttar Pradesh";
        String userCity = "Lucknow";

        open("/automation-practice-form");
        $(".main-header").shouldHave(text("Practice"));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");

        $("#firstName").setValue(userFirstName);
        $("#lastName").setValue(userLastName);
        $("#userEmail").setValue(userEmail);
//        $("#gender-radio-2").parent().$("label").shouldHave(text(userGender)); //чужой вариант
//        $("#gender-radio-2").parent().click(); //good
        $("#genterWrapper").$(byText("Other")).click(); //the best
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-container").shouldBe(visible);
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
// <div class="react-datepicker__day__030 react-datepicker__day--outside-month">30</div> //30-е число предыдущего месяца
// <div class="react-datepicker__day__030                                      >30</div> //30-е число текущего месяца
        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click(); //вариант из разбора домашки
//        $(".react-datepicker__month").$$(".react-datepicker__week")
//                .get(1).$$(".react-datepicker__day").findBy(text("13")).click(); //чужой вариант
        $("#subjectsInput").setValue("Computer Science").pressEnter();
        $("#subjectsInput").$(byText("Sports")).click(); //вариант из разбора домашки
//        $(byText("Reading")).click(); //мой вариант

        $("#uploadPicture").uploadFromClasspath("img/1.png"); //вариант из разбора домашки; работает только для элемента с type=file
//        File cv = new File("src/test/resources/img/1.png"); //более длинный вариант
//        $("#uploadPicture").uploadFile(cv); //более длинный вариант

        $("#currentAddress").setValue(currentAddress);

        $("#state").click();
//        $(byText(userState)).click(); //1-ый способ (по названию города)
        $("#react-select-3-option-2").click(); //узнали id элемента списка с помощью BreakPoint (DevTools)
        $("#city").click();
        $(byText(userCity)).click();

        $("#submit").click();

        $(".modal-dialog").should(appear); //доп. проверка из разбора домашки
        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(userFirstName + " " + userLastName));
        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
        $(".table").$(byText("Gender")).sibling(0).shouldHave(text(userGender));
        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("13" + " " + month + "," + year));
        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
        $(".table").$(byText("Picture")).sibling(0).shouldHave(text(userFileName));
        $(".table").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
        $(".table").$(byText("State and City")).sibling(0).shouldHave(text(userState + " " + userCity));

    }
}
