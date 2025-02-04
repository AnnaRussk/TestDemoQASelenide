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

    @Test
    public void checkBoxTest() {
        open(url);
        $x("//h5[contains(text(), 'Elements')]").scrollTo().click();
        $x("//span[contains(text(), 'Check Box')]").click();
        $x("//span[@class='rct-checkbox']").click();
        $x("//span[contains(text(), 'You have selected')]").shouldHave(text("You have selected :"));
    }

    @Test
    public void radioButtonTest() {
        open(url);
        $x("//h5[contains(text(), 'Elements')]").scrollTo().click();
        $x("//span[contains(text(), 'Radio Button')]").click();
        $x("//label[@class='custom-control-label']").click();
        $x("//span[@class='text-success']").shouldHave(text("Yes"));
    }

    @Test
    public void formText() {
        open(url);
        $x("//h5[contains(text(), 'Forms')]").click();
        $x("//span[contains(text(), 'Practice Form')]").click();
        $x("//input[@id='firstName']").sendKeys("Имя");
        $x("//input[@id='lastName']").sendKeys("Фамилия");
        $x("//div[@class='custom-control custom-radio custom-control-inline']").click();
        $x("//input[@id='userNumber']").sendKeys("1234567890");
        $x("//button[@id='submit']").scrollTo().click();
        $x("//div[contains(text(), 'Thanks for submitting the form')]").shouldHave(text("Thanks for submitting the form"));
    }
}