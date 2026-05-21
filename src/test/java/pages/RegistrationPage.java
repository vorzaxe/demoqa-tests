package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationPage {
    private final String TITLE_TEXT = "Student Registration Form";
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName");

    public void openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text(TITLE_TEXT));
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
    }

    public void setFirstName(String value) {
        $("#firstName").setValue(value);
    }

    public void setLastName(String value) {
        lastNameInput.setValue(value);
    }

    public void clearLastName() {
        lastNameInput.clear();
    }

    public void setEmail(String value) {
        $("#userEmail").setValue(value); // todo move to Selenide elements
    }

    public void setGender(String value) {
        $("#genterWrapper").$(byText(value)).click(); // todo move to Selenide elements
    }

    public void setPhone(String value) {
        $("#userNumber").setValue(value); // todo move to Selenide elements
    }
}