package ru.axeta.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class FeedBackForm {

    private SelenideElement name = $("#name"),
            email = $("#email"),
            phone = $("#phone"),
            fileUpload = $("#file-upload"),
            messageText = $("#message"),
            sendButton = $x("//button[contains(text(), 'Отправить')]"),
            resultMessage = $(".message p");


    public FeedBackForm openPage() {
        open("http://axeta.ru/contacts");
        return this;
    }

    public FeedBackForm setName(String value) {
        name.setValue(value);
        return this;
    }

    public FeedBackForm setEmail(String value) {
        email.setValue(value);
        return this;
    }

    public FeedBackForm setPhone (String phoneNumber) {
        phone.setValue(phoneNumber);
        return this;
    }

    public FeedBackForm setFile (String filePath) {
        fileUpload.uploadFromClasspath(filePath);
        return this;
    }

    public FeedBackForm setMessageText (String message) {
        messageText.setValue(message);
        return this;
    }

    public FeedBackForm sendButtonClick() {
        sendButton.click();
        return this;
    }

    public FeedBackForm checkPossitiveResult() {
        resultMessage.shouldHave(text("Спасибо за то, что оставили заказ на нашем сайте.")).scrollTo().shouldBe(visible);
        return this;
    }

}
