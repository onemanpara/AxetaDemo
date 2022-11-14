package ru.axeta.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ShortFeedBackForm {

    SelenideElement contactUsButton = $("a[data-form-id=discuss]");

    public ShortFeedBackForm openForm() {
        contactUsButton.click();
        return this;
    }

    public ShortFeedBackForm contactsIsVisible(String key, String value) {
        $(".popup.contacts-form ." + key).shouldBe(visible).shouldHave(text(value));
        return this;
    }

}
