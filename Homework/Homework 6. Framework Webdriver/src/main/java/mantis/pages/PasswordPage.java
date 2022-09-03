package mantis.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PasswordPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    @FindBy(id = "password")
    private WebElement passwordField;

    public PasswordPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 30, 500);

        PageFactory.initElements(driver, this);
    }

    public void login() {
        passwordField.sendKeys("admin20");
        passwordField.sendKeys(Keys.ENTER);
    }
}
