package mantis.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {
    private final WebDriver driver;
//    private final WebDriverWait wait;


    public loginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }
}
