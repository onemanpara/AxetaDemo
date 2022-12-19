package ru.axeta;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    protected String
            firmPhone = "+7 (964) 558 64 72",
            firmEmail = "info@axeta.ru",
            firmSkype = "axetacom",
            name = faker.name().name(),
            email = fakerEn.internet().emailAddress(),
            phone = faker.phoneNumber().subscriberNumber(10),
            filePath = "resume.pdf",
            messageText = System.getProperty("messageText"),
            mainPage = "http://axeta.ru/";

}


