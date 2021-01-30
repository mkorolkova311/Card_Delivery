package ru.netology.delivery;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;


public class CardDeliveryTest {
    @Test
void shouldDeliveryFormTest(){
open("http://localhost:7777/");
       $("[placeholder=\"Город\"]").setValue("Москва");
       $("[data-test-id=date] input").sendKeys(Keys.chord(Keys.SHIFT, Keys.HOME), Keys.BACK_SPACE);
       $("[data-test-id=date] input").setValue(LocalDate.of(2021,02,04).format(DateTimeFormatter.ofPattern("dd.MM.uuuu")));
       $("[data-test-id=name] input").setValue("Маргарита Королькова");
       $("[data-test-id=phone] input").setValue("+798122221");
       $("[data-test-id=agreement]").click();
       $(withText("Забронировать")).click();
       $("[data-test-id=notification]").waitUntil(Condition.visible,15000);
    }
}
