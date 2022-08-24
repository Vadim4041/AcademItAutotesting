package ru.academIts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Practicum2 {
    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = null;
        String browser = System.getProperty("browser");
        // при запуске через конфигурацию, нужно нажимать на стрелочки рядом с конфигуратором!
        System.out.println(browser);
        switch (browser) {
            case "chrome" -> {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
            }
            case "edge" -> {
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            }
            case "firefox" -> {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            }
        }
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }

    }


    @Test
    public void simpleTest() throws InterruptedException {
        SoftAssertions softAssert = new SoftAssertions();

//        WebDriverWait wait = new WebDriverWait(driver, 30, 500);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li:nth-child(11) > a"))); // deprecated
//        https://stackoverflow.com/questions/58993667/webdriverwait-is-deprecated-in-selenium-4

        WebElement dropdownLink = driver.findElement(By.cssSelector("li:nth-child(11) > a"));

        dropdownLink.click();
        Thread.sleep(1500); // - неудобно, лучше не использовать

        WebElement dropdownList = driver.findElement(By.id("dropdown"));
        dropdownList.click();
        Thread.sleep(1500);

        WebElement option2 = driver.findElement(By.cssSelector("option:nth-child(3)"));
        option2.click();
        softAssert.assertThat(driver.findElement(By.id("dropdown")).getText()).isEqualTo("Option 2"); // - как вариант, но длинно сильно
        softAssert.assertThat(option2.isSelected());
        Thread.sleep(1500);
    }
}
