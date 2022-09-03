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

    public void reportIssueWithoutSummary() {
        reportIssuePage.inputDescription();
        reportIssuePage.clearInputSummary();
        reportIssuePage.submitIssue();
    }

    public void reportIssueWithoutDescription() {
        reportIssuePage.clearInputDescription();
        reportIssuePage.inputSummary();
        reportIssuePage.submitIssue();
    }

    public void reportEmptyIssue() {
        reportIssuePage.submitIssue();
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

    public NewestIssueDetailsPage getNewestIssuePage() {
        return newestIssueDetailsPage;
    }
}
