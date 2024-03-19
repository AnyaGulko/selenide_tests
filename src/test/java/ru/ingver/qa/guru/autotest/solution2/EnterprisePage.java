package ru.ingver.qa.guru.autotest.solution2;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ingver.qa.guru.autotest.ConfigConstants;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class EnterprisePage {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = ConfigConstants.SCREEN_SIZE;
        Configuration.savePageSource = ConfigConstants.SAVE_PAGE_SOURSE;
    }

    @Test
    void pageEnterpriseIsOpened() {
        open(ConfigConstants.GITHUB_BASE_URL);
        $(".header-menu-wrapper").$(byText("Solutions")).hover();
        $$("a.HeaderMenu-dropdown-link").find(text("Enterprise")).click();
        $("#hero-section-brand-heading").shouldHave(exactText("The AI-powered\ndeveloper platform."));
    }
}
