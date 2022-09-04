package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    public String descriptionText = "Random Description";
    public String summaryText = "Random Summary";


    @FindBy(id = "summary")
    private WebElement summaryField;

    @FindBy(id = "description")
    private WebElement descriptionField;

    @FindBy(css = "div.widget-toolbox.padding-8.clearfix > input")
    private WebElement submitIssueButton;

    public ReportIssuePage(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void inputSummary() {
        summaryField.sendKeys(summaryText);
    }

    public void inputDescription() {
        descriptionField.sendKeys(descriptionText);
    }

    public void clearInputDescription() {
        descriptionField.clear();
    }

    public void clearInputSummary() {
        summaryField.clear();
    }

    public void submitIssue() {
        submitIssueButton.click();
    }

    public void reportIssue() {
        inputSummary();
        inputDescription();
        submitIssue();
    }

    public void reportIssueWithoutSummary() {
        inputDescription();
        clearInputSummary();
        submitIssue();
    }

    public void reportIssueWithoutDescription() {
        clearInputDescription();
        inputSummary();
        submitIssue();
    }

}