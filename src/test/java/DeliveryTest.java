package ru.netology.delivery.test;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.delivery.data.DataGenerator;

import java.time.Duration;
import java.util.Locale;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

class DeliveryTest {

    private static Faker faker;

    @BeforeAll
    static void setUpAll() {
        faker = new Faker( new Locale("ru"));

    }

    @BeforeEach
    void setup() {
        open("http://localhost:9999");
    }

    @Test
    @DisplayName("Should successful plan and replan meeting")
    void shouldSuccessfulPlanAndReplanMeeting() {
        return new DataGenerator.Registration.UserInfo(
        $("input[placeholder=\"Город\"]").setValue(DataGenerator.Registration.generateCity());
        $("[placeholder=\"Дата встречи\"]").setValue(DataGenerator.Registration.generateDate());
        $("[name=\"name\"]").setValue(DataGenerator.Registration.generateName());
        $("[name=\"phone\"]").setValue(DataGenerator.Registration.generatePhone());
        $("[data-test-id=\"agreement\"]").click();
        $x('//span[text()="Запланировать"]').click();)

               /*should(visible, Duration.ofSeconds(15))
        String city = faker.;
        String name = faker.name().fullName();
        String phone = faker.phoneNumber().phoneNumber();
        String cardNumber = faker.finance().creditCard(CreditCardType.MASTERCARD);
        System.out.println(city);
        System.out.println(date);
        System.out.println(phone);

        var validUser = DataGenerator.Registration.generateUser("ru");
        var validCity = DataGenerator.generateCity("ru");
        var daysToAddForFirstMeeting = 4;
        var firstMeetingDate = DataGenerator.generateDate(daysToAddForFirstMeeting);
        var daysToAddForSecondMeeting = 7;
        var secondMeetingDate = DataGenerator.generateDate(daysToAddForSecondMeeting);
        // TODO: добавить логику теста в рамках которого будет выполнено планирование и перепланирование встречи.
        // Для заполнения полей формы можно использовать пользователя validUser и строки с датами в переменных
        // firstMeetingDate и secondMeetingDate. Можно также вызывать методы generateCity(locale),
        // generateName(locale), generatePhone(locale) для генерации и получения в тесте соответственно города,
        // имени и номера телефона без создания пользователя в методе generateUser(String locale) в датагенераторе*/
    }

}