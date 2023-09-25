package selenide;

import com.codeborne.selenide.AuthenticationType;
import com.codeborne.selenide.BasicAuthCredentials;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Snippets {

    void browser_command_examples() {

        open("https://google.com");
        open("/customer/orders");   // -Dselenide.baseUrl=http://123.23.23.1
        open("/", AuthenticationType.BASIC,
                new BasicAuthCredentials("", "user", "password"));

        Selenide.back();
        Selenide.refresh();

        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        executeJavaScript("sessionStorage.clear()");    // no Selenide command for this yet

        Selenide.confirm(); // OK in alert dialogs
        Selenide.dismiss(); // Cancel in alerts dialogs

        Selenide.closeWindow(); // close active tab
        Selenide.closeWebDriver();  // close browser completely

        Selenide.switchTo().frame("new");
        Selenide.switchTo().defaultContent();   // return from frame
    }

    void selectors_examples() {

        $("div").click();
        element("div").click();

        $("div", 2).click();    // the third div

        $x("//h1/div").click();
        $(byXpath("//h1/div")).click();

        $(byText("full text")).click();
        $(withText("ull tex")).click();

        $(byTagAndText("div", "full text"));
        $(withTagAndText("div", "ull tex"));

        $("").parent();
        $("").sibling(1);
        $("").preceding(1);
        $("").closest("div");
        $("").ancestor("div");  // the same as closest
        $("div:last-child");

        $("div").$("h1").find(byText("abc")).click();
        // very optional
        $(byAttribute("abc", "x")).click();
        $("[abc=x]").click();

        $(byId("mytext")).click();
        $("#mytext").click();

        $(byClassName("red")).click();
        $(".red").click();
    }

    void actions_examples() {

        $("").click();
        $("").doubleClick();
        $("").contextClick();   // right click of mouse

        $("").hover();  // поднести мышь и не кликать

        $("").setValue("text");
        $("").append("text");
        $("").clear();  // не всегда срабатывает (у пользователя может не быть кнопки clear)
        $("").setValue(""); // clear

        $("div").sendKeys("c"); // hotkey c on element
        actions().sendKeys("c").perform();  // hotkey c on whole application
        actions().sendKeys(Keys.chord(Keys.CONTROL, "f")).perform();    // Ctrl + f
        $("html").sendKeys(Keys.chord(Keys.CONTROL, "f"));

        $("").pressEnter();
        $("").pressEscape();
        $("").pressTab();

        // complex actions with keyboard and mouse, example
        actions().moveToElement($("div")).clickAndHold().moveByOffset(300, 200).release().perform();

        // old html actions don't work with many modern frameworks
        $("").selectOption("dropdown_option");
        $("").selectRadio("radio_options");
    }

    void conditions_examples() {

        $("").shouldBe(visible);
        $("").shouldBe(hidden);

        $("").shouldHave(text("abc"));
        $("").shouldHave(exactText("abc"));
        $("").shouldHave(textCaseSensitive("abc"));
        $("").shouldHave(exactTextCaseSensitive("abc"));
        $("").shouldHave(matchText("[0-9]abc$"));

        $("").shouldHave(cssClass("red"));
        $("").shouldHave(cssValue("font-size", "12"));

        $("").shouldHave(value("25"));
        $("").shouldHave(exactValue("25"));
    }

    void collections_examples() {

        $$("div");  // does nothing!

        $$x("//div");   // by XPath

        //selections
        $$("div").filterBy(text("123")).shouldHave(size(1));
        $$("div").excludeWith(text("123")).shouldHave(size(1));

        $$("div").first().click();
        $$("div").first().click();
    }

    void javascript_examples() {

        executeJavaScript("alert('selenide')");
        executeJavaScript("alert(arguments[0]+arguments[1])", "abc", 12);
        long fortytwo = executeJavaScript("return arguments[0]*arguments[1];", 6, 7);

    }
}