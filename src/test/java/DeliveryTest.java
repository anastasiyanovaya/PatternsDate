package ru.netology.delivery.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

class DeliveryTest {
    private final DataGenerator.UserInfo validUser = DataGenerator.Registration.generateUser("ru");
    private final int daysToAddForFirstMeeting = 4;
    private final String firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
    private final int daysToAddForSecondMeeting = 7;
    private final String secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }


    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        $("[placeholder=\"Город\"]").setValue(validUser.getCity());
        $("input[placeholder=\"Дата встречи\"]").setValue(firstMeetingDate);
        $("[data-test-id=\"name\"] input").setValue(validUser.getName());
        $("[data-test-id='phone'] input").setValue(validUser.getPhone());
        $("[data-test-id=\"agreement\"]").click();
        $x("//span[text()='Запланировать']").click();
        $("[data-test-id=\"success-notification\"]").should(visible, Duration.ofSeconds(15));
        $x("//span[text()='Запланировать']").click();
        $x("//span[text()='Перепланировать']").click();
        $x("//div[text()='Встреча успешно запланирована на ']").should(visible,Duration.ofSeconds(15));

    }






    // var validUser = DataGenerator.Registration.generateUser("ru");
        //var daysToAddForFirstMeeting = 4;
        // var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        //var daysToAddForSecondMeeting = 7;
        //var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);

        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе
    }