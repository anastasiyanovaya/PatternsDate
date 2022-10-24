package ru.netology.delivery.data;

import com.github.javafaker.Faker;
import com.github.javafaker.PhoneNumber;
import lombok.Value;

import java.time.LocalDate;
import java.util.Locale;


public class DataGenerator {
    private DataGenerator() {}

    public static class Registration {
        private Registration() {
        }

        static Faker faker = new Faker(new Locale("ru"));


        public static String generateCity(String locale) {
            Faker faker = new Faker(new Locale(locale));
            String city = faker.address().city();
            return city;
        }


        public static String generateDate(int shift) {

            var date = faker.date(LocalDate);

            return date;
        }


        public static String generateName(String locale) {
            String name1 = faker.name().firstName();
            String name2 = faker.name().lastName();
            String name = name1 + name2;
            return name;
        }

        public static PhoneNumber generatePhone(String locale) {
            var phone = faker.phoneNumber();
            return phone;
        }

        public static UserInfo generateUser(String locale) {
            String user = generateUser(generateCity(locale),generateName(locale),generatePhone(locale));
            // TODO: добавить логику для создания пользователя user с использованием методов generateCity(locale),
            // generateName(locale), generatePhone(locale)
            return user;
        }
    }
        @Value
        public static class UserInfo {
            String city;
            String name;
            String phone;
        }
    }
