package mantis.tests;

import mantis.pages.MantisSite;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Test;

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

    @Test
    public void addIssueWithoutRequiredFields() {;

    }
}
