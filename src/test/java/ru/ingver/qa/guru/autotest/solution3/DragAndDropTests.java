package ru.ingver.qa.guru.autotest.solution3;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.ingver.qa.guru.autotest.ConfigConstants;

import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;

public class DragAndDropTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = ConfigConstants.HEROKUAPP_BASE_URL;
        Configuration.browserSize = ConfigConstants.SCREEN_SIZE;
        Configuration.savePageSource = ConfigConstants.SAVE_PAGE_SOURSE;
    }

    @Test
    void dragAndDropWithActions() {
        open("/drag_and_drop");
        actions().moveToElement($("#column-a"))
                .clickAndHold()
                .moveToElement($("#column-b"))
                .release()
                .perform();
    }
    
    @Test
    void dragAndDrop() {
        open("/drag_and_drop");
        $("#column-a").dragAndDrop(to("#column-b"));
    }
}
