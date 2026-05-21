//package demoqa;
//
//import com.codeborne.selenide.Configuration;
//import org.junit.jupiter.api.BeforeAll;
//import org.junit.jupiter.api.Test;
//import pages.RegistrationPage;
//
//import static com.codeborne.selenide.Condition.*;
//import static com.codeborne.selenide.Selectors.byText;
//import static com.codeborne.selenide.Selenide.*;
//
//public class RegistrationWithPageObjectsForm {
//    RegistrationPage registrationPage = new RegistrationPage();
//
//    @BeforeAll
//    static void beforeAll() {
//        Configuration.browserSize = "1920x1080";
//        Configuration.baseUrl = "https://demoqa.com";
//        Configuration.holdBrowserOpen = true;
//    }
//
//    @Test
//    void fillFormRegistration() {
//
//        String userFirstName = "Xenia";
//        String currentAddress = "Georgia, Batumi, Griboedova, 13";
//        String userFileName = "1394695586_1144072832.jpg";
//        String userState = "Uttar Pradesh";
//        String userCity = "Lucknow";
//
//        registrationPage.openPage();
//
//        registrationPage.setFirstName(userFirstName);
//        registrationPage.setLastName("Vorza");
//        registrationPage.setEmail("xeniavorza@gmail.com");
//        registrationPage.setGender("Other");
//        registrationPage.setPhone("8987546345");
//
//        $("#dateOfBirthInput").click();
//        $(".react-datepicker__month-container").shouldBe(visible);
//        $(".react-datepicker__month-select").selectOption("June");
//        $(".react-datepicker__year-select").selectOption("1992");
//        $(".react-datepicker__day--030:not(.react-datepicker__day--outside-month)").click();
//        $("#subjectsInput").setValue("Computer Science").pressEnter();
//        $("#subjectsInput").$(byText("Sports")).click();
//
//        $("#uploadPicture").uploadFromClasspath("img/1.png");
//
//        $("#currentAddress").setValue(currentAddress);
//
//        $("#state").click();
////        $(byText(userState)).click(); //1-ый способ (по названию города)
//        $("#react-select-3-option-2").click(); //узнали id элемента списка с помощью BreakPoint (DevTools)
//        $("#city").click();
//        $(byText(userCity)).click();
//
//        $("#submit").click();
//
//        $(".modal-dialog").should(appear); //доп. проверка из разбора домашки
//        $(".modal-header").shouldHave(text("Thanks for submitting the form"));
//        $(".table").$(byText("Student Name")).sibling(0).shouldHave(text(userFirstName + " " + userLastName));
//        $(".table").$(byText("Student Email")).sibling(0).shouldHave(text(userEmail));
//        $(".table").$(byText("Gender")).sibling(0).shouldHave(text(userGender));
//        $(".table").$(byText("Mobile")).sibling(0).shouldHave(text(userNumber));
//        $(".table").$(byText("Date of Birth")).sibling(0).shouldHave(text("13" + " " + month + "," + year));
//        $(".table").$(byText("Subjects")).sibling(0).shouldHave(text("Computer Science"));
//        $(".table").$(byText("Hobbies")).sibling(0).shouldHave(text("Reading"));
//        $(".table").$(byText("Picture")).sibling(0).shouldHave(text(userFileName));
//        $(".table").$(byText("Address")).sibling(0).shouldHave(text(currentAddress));
//        $(".table").$(byText("State and City")).sibling(0).shouldHave(text(userState + " " + userCity));
//
//    }
//}
