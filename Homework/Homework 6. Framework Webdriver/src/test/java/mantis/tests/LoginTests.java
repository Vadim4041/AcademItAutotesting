package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTests extends BaseTest{

    private MantisSite mantisSite;

    @Test
    public void loginUrlTest() {
        String currentUrl = driver.getCurrentUrl();
        Assertions.assertEquals("https://academ-it.ru/mantisbt/login_page.php", currentUrl);
    }

    @Test
    public void loginTitleTest() {
        String currentTitle = driver.getTitle();
        Assertions.assertEquals("MantisBT", currentTitle);
    }

    @Test
    public void successfulLoginTest() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login();

        String currentUserName = mantisSite.getMainPage().getUserName();
        Assertions.assertEquals("admin", currentUserName);
        Thread.sleep(1000);
    }

    @Test
    public void addDeleteIssuePositive() throws InterruptedException {
        SoftAssertions softAssert = new SoftAssertions();
        mantisSite = new MantisSite(driver);
        mantisSite.login();
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();
        String newIssueId = mantisSite.getNewestIssueId();
        mantisSite.goToNewestIssueDetailsPage();
        String actualNewIssueId = mantisSite.getActualNewestIssueId();
        String actualNewIssueDescription = mantisSite.getActualNewestIssueDescription();
        String actualNewIssueSummary = mantisSite.getActualNewestIssueSummary();

        softAssert.assertThat(actualNewIssueId).isEqualTo(newIssueId);
        softAssert.assertThat(actualNewIssueDescription).isEqualTo(mantisSite.getDescriptionText());
        softAssert.assertThat(actualNewIssueSummary).isEqualTo(newIssueId + ": " + mantisSite.getSummaryText());
        softAssert.assertAll();
        Thread.sleep(1000);

    }



    //TODO Идеи для негативного тестирования - нажимаем кнопку отправить, не заполнив обязательные поля.
    // При удалении нажимаем на кноку удалить, потом сабмит не нажимаем, возвращаемся в список с багами

}
