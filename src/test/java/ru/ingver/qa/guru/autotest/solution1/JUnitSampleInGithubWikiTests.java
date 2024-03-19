package ru.ingver.qa.guru.autotest.solution1;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ingver.qa.guru.autotest.ConfigConstants;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

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
        $(".wiki-rightbar")
                .$("button.Link--muted")
                .click();
        $(byText("SoftAssertions")).click();

        $("#wiki-body").shouldHave(text("""
@ExtendWith({SoftAssertsExtension.class})
class Tests {
@Test
void test() {
Configuration.assertionMode = SOFT;
open("page.html");

$("#first").should(visible).click();
$("#second").should(visible).click();
}
}
"""))
                .shouldBe(visible);
    }
}
