package ramzil-fattakhov.allure;

import com.codeborne.selenide.Configuration;
import io.qameta.allure.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LabelsTest {

    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUE = "80";

    @BeforeAll
    static void beforeAll() {
        Configuration.holdBrowserOpen = false;
        Configuration.browserSize = "1920x1080";
        Configuration.browser = "chrome";
        Configuration.timeout = 10000;
    }

    @Test
    @Feature("Issue в репозитории")
    @Story("Создание Issue")
    @Owner("ramzil.fattahov")
    @Severity(SeverityLevel.BLOCKER)
    @Link(value = "Testing", url = "https://testing.github.com")
    @DisplayName("Создание issue для авторизованного пользователя")
    public void testStaticLabels() {

    }

    @Test
    public void testDynamicsLabels() {
        Allure.getLifecycle().updateTestCase(t -> t.setName("Создание issue для авторизованного пользователя"));
        if (true) {
            Allure.feature("Issue в репозитории");
        } else {
            Allure.feature("Issue не в репозитории");
        }
        Allure.story("Создание Issue");
        Allure.label("Owner", "ramzil.fattakhov");
        Allure.label("Severity", SeverityLevel.CRITICAL.value());
        Allure.link("Testing", "https://testing.github.com");
    }
}
