package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewestIssueDetailsPage {

    @FindBy(css = "td.bug-id")
    private WebElement actualNewestIssueId;

    @FindBy(css = "tr:nth-child(11) > td")
    private WebElement actualNewestIssueDescription;

    @FindBy(css = "tr:nth-child(10) > td")
    private WebElement actualNewestIssueSummary;

    @FindBy(css = "div > div:nth-child(10)")
    private WebElement deleteIssueButton;

    @FindBy(css = "div.widget-toolbox.padding-8.clearfix > input")
    private WebElement confirmDeleteIssueButton;

    public NewestIssueDetailsPage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public String getActualNewestIssueId() {
        return actualNewestIssueId.getText();
    }

    public String getActualNewestIssueDescription() {
        return actualNewestIssueDescription.getText();
    }

    public String getActualNewestIssueSummary() {
        return actualNewestIssueSummary.getText();
    }

    public void deleteCurrentIssue() {
        deleteIssueButton.click();
        confirmDeleteIssueButton.click();
    }

    public void deleteIssueWithoutConfirmation() {
        deleteIssueButton.click();
    }
}
