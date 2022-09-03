package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class CreateDeleteIssueTests extends BaseTest {

    private MantisSite mantisSite;
    private SoftAssertions softAssert = new SoftAssertions();

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
        mantisSite.getMainPage().goToViewIssuesPage();
        mantisSite.reportEmptyIssue();
//        softAssert.assertThat(mantisSite.getReportIssuePage());
    }
}
