package ru.axeta;

import com.github.javafaker.Faker;
import java.util.Locale;

public class TestData {

    Faker faker = new Faker(new Locale("ru"));
    Faker fakerEn = new Faker(new Locale("en"));

    String firmPhone = "+7 (964) 558 64 72";
    String firmEmail = "info@axeta.ru";
    String firmSkype = "axetacom";
    String name = faker.name().name();
    String email = fakerEn.internet().emailAddress();
    String phone = faker.phoneNumber().subscriberNumber(10);
    String filePath = "resume.pdf";
    String messageText = System.getProperty("messageText");
    String mainPage = "http://axeta.ru/";

}


