package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

public class CreateDeleteIssueTests extends BaseTest {

    private MantisSite mantisSite;
    private final SoftAssertions softAssert = new SoftAssertions();

    @Test
    public void addDeleteIssuePositive() throws InterruptedException {
        mantisSite = new MantisSite(driver);
        mantisSite.login();
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.reportIssue();
        mantisSite.getMainPage().goToViewIssuesPage();
        String newIssueId = mantisSite.getViewIssuesPage().getNewestIssueId();
        mantisSite.getViewIssuesPage().newestIssueDetails();
        String actualNewIssueId = mantisSite.getNewestIssuePage().getActualNewestIssueId();
        String actualNewIssueDescription = mantisSite.getNewestIssuePage().getActualNewestIssueDescription();
        String actualNewIssueSummary = mantisSite.getNewestIssuePage().getActualNewestIssueSummary();

        softAssert.assertThat(actualNewIssueId).isEqualTo(newIssueId);
        softAssert.assertThat(actualNewIssueDescription).isEqualTo(mantisSite.getReportIssuePage().descriptionText);
        softAssert.assertThat(actualNewIssueSummary).isEqualTo(newIssueId + ": " + mantisSite.getReportIssuePage().summaryText);

        mantisSite.getNewestIssuePage().deleteIssue();

        softAssert.assertThat(mantisSite.getViewIssuesPage().getNewestIssueId()).isNotEqualTo(newIssueId);

        softAssert.assertAll();

        Thread.sleep(1000);

    }

    @Test
    public void addIssueWithoutRequiredFields() {
        mantisSite = new MantisSite(driver);
        mantisSite.login();
        mantisSite.getMainPage().goToReportIssuePage();
        mantisSite.reportEmptyIssue();

        softAssert.assertThat(driver.getCurrentUrl()).isEqualTo("https://academ-it.ru/mantisbt/bug_report_page.php");

        mantisSite.reportIssueWithoutDescription();

        softAssert.assertThat(driver.getCurrentUrl()).isEqualTo("https://academ-it.ru/mantisbt/bug_report_page.php");

        mantisSite.reportIssueWithoutSummary();

        softAssert.assertThat(driver.getCurrentUrl()).isEqualTo("https://academ-it.ru/mantisbt/bug_report_page.php");
        softAssert.assertAll();
    }

    @Test
    public void deleteIssueWithoutConfirmation() {
        mantisSite = new MantisSite(driver);
        mantisSite.login();
        mantisSite.getMainPage().goToViewIssuesPage();
        String issueIdBeforeDeletion = mantisSite.getViewIssuesPage().getNewestIssueId();
        mantisSite.getViewIssuesPage().newestIssueDetails();
        mantisSite.getNewestIssuePage().deleteIssueWithoutConfirmation();
        mantisSite.getMainPage().goToViewIssuesPage();
        String issueIdAfterDeletion = mantisSite.getViewIssuesPage().getNewestIssueId();

        softAssert.assertThat(issueIdBeforeDeletion).isEqualTo(issueIdAfterDeletion);

        softAssert.assertAll();
    }

}
