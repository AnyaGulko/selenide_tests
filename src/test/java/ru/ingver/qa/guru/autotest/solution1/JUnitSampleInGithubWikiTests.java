package ru.ingver.qa.guru.autotest.solution1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ingver.qa.guru.autotest.ConfigConstants;

import static com.codeborne.selenide.Condition.cssClass;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class JUnitSampleInGithubWikiTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = ConfigConstants.SCREEN_SIZE;
        Configuration.savePageSource = ConfigConstants.SAVE_PAGE_SOURSE;
        Configuration.baseUrl = ConfigConstants.GITHUB_BASE_URL;
    }

    @Test
    void checkJUnitSampleInGithubWiki() {
        open("/selenide/selenide");
        $("#wiki-tab").click();
        $("a.internal.present", 8)
                .shouldHave(text("Soft assertions"))
                .click();

        $$("h4.heading-element")
                .find(text("JUnit5"))
                .parent()
                .sibling(0)
                .shouldHave(cssClass("highlight-source-java"));
    }
}
