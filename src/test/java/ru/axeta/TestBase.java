package ru.axeta;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;
import ru.axeta.helpers.Attach;

public class TestBase {

    @BeforeAll
    static void setUp() {
        SelenideLogger.addListener("Allure", new AllureSelenide());
        Configuration.baseUrl = "http://axeta.ru/";
        Configuration.browser = System.getProperty("browser", "chrome");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        DesiredCapabilities capabilities = new DesiredCapabilities();
        System.setProperty("chromeoptions.prefs","intl.accept_languages=ru");
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
        Configuration.remote = System.getProperty("remote", "https://user1:1234@selenoid.autotests.cloud/wd/hub");
    }

    @AfterEach
    void addAttach() {
        Attach.addVideo();
        Attach.browserConsoleLogs();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
    }

}
