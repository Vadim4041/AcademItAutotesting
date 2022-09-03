package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ViewIssuesPage {
    private final WebDriver driver;
    private final WebDriverWait wait;


    @FindBy (css = "tr:nth-child(1) > td.column-id > a")
    private WebElement newestIssueId;

    public ViewIssuesPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public String getNewestIssueId() {
        return newestIssueId.getText();
    }

    public void newestIssueDetails() {
        newestIssueId.click();
    }

}
