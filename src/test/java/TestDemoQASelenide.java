import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class TestDemoQASelenide {

    private final String url = "https://demoqa.com/";

    @BeforeAll
    public static void setUp() {
        Configuration.browserSize = String.valueOf(true);
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    public void textFieldText() {
        open(url);
        $x("//h5[contains(text(), 'Elements')]").scrollTo().click();
        $x("//span[contains(text(), 'Text Box')]").click();
        $x("//input[@id='userName']").scrollTo().setValue("Какое-то Имя");
        $x("//button[@id='submit']").click();
        $x("//p[@id='name']").shouldHave(text("Name:Какое-то Имя"));
    }
}
