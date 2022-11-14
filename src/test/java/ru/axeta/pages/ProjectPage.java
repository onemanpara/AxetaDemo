package ru.axeta.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProjectPage {

    SelenideElement projectLink = $x("//a[contains(text(),'Проекты')]"),
            viewCaseButton = $x("//h2[contains(text(), 'Марафон')]")
            .parent().$(".view-review"),
            h1 = $("h1");

    public ProjectPage projectsPageClick () {
        projectLink.click();
        return this;
    }

    public ProjectPage projectCaseLinkClick() {
        viewCaseButton.click();
        return this;
    }

    public ProjectPage projectPageCheckH1() {
        h1.shouldHave(text("Марафон"));
        return this;
    }
}
