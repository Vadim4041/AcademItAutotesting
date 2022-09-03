package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ReportIssuePage {
    private final WebDriver driver;
    private final WebDriverWait wait;
    public String descriptionText = "Random Description";
    public String summaryText = "Random Summary";


    @FindBy (id = "summary")
    private WebElement summaryField;

    @FindBy (id = "description")
    private WebElement descriptionField;

    @FindBy (css = "div.widget-toolbox.padding-8.clearfix > input")
    private WebElement submitIssueButton;

    public ReportIssuePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void inputSummary() {
        summaryField.sendKeys(summaryText);
    }
    public void inputDescription() {
        descriptionField.sendKeys(descriptionText);
    }
    public void submitIssue() {
        submitIssueButton.click();
    }

}