package mantis.pages;

import org.openqa.selenium.WebDriver;

public class MantisSite {
    private final LoginPage loginPage;
    private final PasswordPage passwordPage;
    private final MainPage mainPage;
    private final ReportIssuePage reportIssuePage;
    private final ViewIssuesPage viewIssuesPage;
    private final NewestIssueDetailsPage newestIssueDetailsPage;

    public MantisSite(WebDriver driver) {

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
