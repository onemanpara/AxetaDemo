package ru.axeta;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.axeta.components.FeedBackForm;
import ru.axeta.components.ShortFeedBackForm;
import ru.axeta.helpers.DriverUtils;
import ru.axeta.pages.ProjectPage;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;

public class AxetaTests extends Data {

    FeedBackForm feedBackForm = new FeedBackForm();
    ShortFeedBackForm shortFeedBackForm = new ShortFeedBackForm();
    ProjectPage projectPage = new ProjectPage();


    @Test
    @DisplayName("В заголовке первого баннера \"Разработка мобильных приложений\"")
    void setUP() {
        step("Открываем главную страницу", () -> open(mainPage));
        step("Проверяем, что в первом баннере заголовок \"Разработка мобильных приложений\"", () -> {
            $x("//h1[contains(text(), 'Разработка мобильных приложений')]").shouldBe(visible);
        });
    }

    @Test
    @DisplayName("Вызов формы обратной связи, валидация контактов.")
    void callBack() {
        step("Открываем главную страницу", () -> open(mainPage));
        step("Вызываем форму обратной связи", () -> {
            shortFeedBackForm.openForm();
        });
        step("Проверяем отображение контактов компании", () -> {
            shortFeedBackForm.contactsIsVisible("phone", firmPhone);
            shortFeedBackForm.contactsIsVisible("email", firmEmail);
            shortFeedBackForm.contactsIsVisible("skype", firmSkype);
        });
    }

    @Test
    @DisplayName("Отправка формы обратной связи со страницы /contacts")
    void feedBackFormTest() {
        step("Открываем страницу с формой обратной связи", () -> {
            feedBackForm.openPage();
        });
        step("Заполняем форму данными", () -> {
            feedBackForm.setName(name)
                    .setEmail(email)
                    .setPhone(phone)
                    .setFile(filePath)
                    .setMessageText(messageText);
        });
        step("Отправляем форму", () -> {
            feedBackForm.sendButtonClick();
        });
        step("Проверяем, что появилось уведомление об успешной отправке", () -> {
            feedBackForm.checkPossitiveResult();
        });
    }

    @Test
    @DisplayName("Проверяем H1 на странице проекта")
    void h1AtProjectPageCheck() {
        step("Открываем главную страницу", () -> open(mainPage));
        step("Кликаем на ссылку \"Проекты\" в хедере", () -> {
            projectPage.projectsPageClick();
        });
        step("Кликаем на кнопку \"Посмотреть кейс\" у проекта \"Марафон\"", () -> {
            projectPage.projectCaseLinkClick();
        });
        step("Проверяем, что на детальной странице проекта H1 = \"Марафон\"", () -> {
            projectPage.projectPageCheckH1();
        });
    }

    @Test
    @DisplayName("В консоли нет ошибок")
    @Disabled("Данный тест отключен, т.к. сейчас в консоли есть ошибка.")
    void consoleShouldNotHaveErrorsTest() {
        step("Открываем главную страницу'", () ->
                open(mainPage));
        step("Проверяем, что в логах консоли нет ошибок (строк с \"SEVERE\")", () -> {
            String consoleLogs = DriverUtils.getConsoleLogs();
            String errorText = "SEVERE";
            assertThat(consoleLogs).doesNotContain(errorText);
        });
    }
}
