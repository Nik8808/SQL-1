package ru.netology.web.data;

import com.github.javafaker.Faker;
import lombok.Value;

import java.util.Locale;

public class DataHelper {
private static Faker faker = new Faker(new Locale("en"));
    private DataHelper() {
    }

    public static AuthInfo getAuthInfoWithTestData() {
        return new AuthInfo("vasya", "qwerty123");
    }
    private static String generateRandomLogin() {
        return faker.name().username();
    }
    private static String generateRandomPassword() {
        return faker.internet().password();
    }
    public static AuthInfo generateRandomUser() {
        return new AuthInfo(generateRandomLogin(), generateRandomPassword());
    }
    public static VerificationCode generateRandomVerificationCode() {
        return new  VerificationCode(faker.numerify("######"));
    }

    @Value
    public static class VerificationCode {
        String code;
    }

//    @Value
//    public static class AutCode {
//        private String id;
//        private String user_id;
//        private String code;
//        private String created;
//    }

    @Value
    public static class AuthInfo {
        String login;
        String password;
    }
}
