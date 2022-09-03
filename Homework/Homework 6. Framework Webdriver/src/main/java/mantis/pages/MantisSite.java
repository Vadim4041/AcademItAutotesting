package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final WebDriver driver;
    private LoginPage loginPage;
    private PasswordPage passwordPage;
    private MainPage mainPage;
    private ReportIssuePage reportIssuePage;
    private ViewIssuesPage viewIssuesPage;
    private NewestIssueDetailsPage newestIssueDetailsPage;

    public MantisSite(WebDriver driver) {
        this.driver = driver;

        loginPage = new LoginPage(driver);
        passwordPage = new PasswordPage(driver);
        mainPage = new MainPage(driver);
        reportIssuePage = new ReportIssuePage(driver);
        viewIssuesPage = new ViewIssuesPage(driver);
        newestIssueDetailsPage = new NewestIssueDetailsPage(driver);
    }

    public void login() {
        loginPage.login();
        passwordPage.login();
    }

    public void reportIssue() {
        reportIssuePage.inputSummary();
        reportIssuePage.inputDescription();
        reportIssuePage.submitIssue();
    }

    public String getDescriptionText() {
        return reportIssuePage.descriptionText;
    }

    public String getSummaryText() {
        return reportIssuePage.summaryText;
    }

    public String getNewestIssueId() {
        return viewIssuesPage.getNewestIssueId();
    }

    public void goToNewestIssueDetailsPage() {
        viewIssuesPage.newestIssueDetails();
    }

    public String getActualNewestIssueId() {
       return newestIssueDetailsPage.getActualNewestIssueId();
    }

    public String getActualNewestIssueDescription() {
        return newestIssueDetailsPage.getActualNewestIssueDescription();
    }

    public String getActualNewestIssueSummary() {
        return newestIssueDetailsPage.getActualNewestIssueSummary();
    }

    public LoginPage getLoginPage() {
        return loginPage;
    }

    public PasswordPage getPasswordPage() {
        return passwordPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public ReportIssuePage getReportIssuePage() {
        return reportIssuePage;
    }

    public ViewIssuesPage getViewIssuesPage() {
        return viewIssuesPage;
    }
}
