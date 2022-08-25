package homeWork5;

//В ДЗ используем WebDriver Manager
//        • Реализовать логику с параметром запуска – минимум 3 вида
//        браузеров
//        • Структурировать код с помощью аннотаций @Before /
//@After
//• Написать автотест для формы на странице:
//        https://demoqa.com/automation-practice-form
//        • Заполните все поля, нажать кнопку Submit, в открывшемся
//        окне проверить, что данные заполнены верно
//        • При необходимости использовать wait

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class demoQaTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        String browser = System.getProperty("browser");

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
        driver.get("https://demoqa.com/automation-practice-form");
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
    public void formTest() {
        SoftAssertions softAssert = new SoftAssertions();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        String firstNameInput = "firstNameInput";
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameInput);

        String lastNameInput = "lastNameInput";
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(lastNameInput);

        String userEmailInput = "userEmailInput@mail.com";
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(userEmailInput);

        String genderRadioInput = "3";
        WebElement genderRadio = driver.findElement(By.id("gender-radio-" + genderRadioInput));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", genderRadio);

        String userNumberInput = "1111111111";
        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys(userNumberInput);

        Calendar calendar = new GregorianCalendar(1996, Calendar.SEPTEMBER, 11);
        DateFormat df = new SimpleDateFormat("dd MMMM,yyy", Locale.ENGLISH);
        DateFormat dfInput = new SimpleDateFormat("dd MMM yyy", Locale.ENGLISH);
        String dateInput = dfInput.format(calendar.getTime());
        String date = df.format(calendar.getTime());
        WebElement dateOfBirth = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirth.sendKeys(Keys.CONTROL + "a");
        dateOfBirth.sendKeys(dateInput);
        dateOfBirth.sendKeys(Keys.ENTER);

        String subjectsInput = "Maths";
        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.click();
        subjects.sendKeys(subjectsInput);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("subjectsInput"))); // firefox слишком быстрый, поэтому добавил задержку, на других браузерах ошибки не было и без задержки
        subjects.sendKeys(Keys.ENTER);

        String hobbiesCheckboxInput = "2";
        WebElement hobby = driver.findElement(By.cssSelector("#hobbiesWrapper > div.col-md-9.col-sm-12 > div:nth-child(" + hobbiesCheckboxInput + ") > label"));
        WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-" + hobbiesCheckboxInput));
        js.executeScript("arguments[0].click()", hobbiesCheckbox);

        String pictureName = "picture.jpg";
        String picturePath = "D:\\YandexDisk\\0_PROGRAMMING\\ACADEM IT\\AcademItAutotesting\\Homework\\Homework 5. Selenium WebDriver\\src\\test\\recources\\picture.jpg";
        WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
        uploadPicture.sendKeys(picturePath);

        String currentAddressInput = "currentAddress";
        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys(currentAddressInput);

        String stateSelectInput = "NCR";
        WebElement stateSelect = driver.findElement(By.id("react-select-3-input"));
        stateSelect.sendKeys(stateSelectInput);
        stateSelect.sendKeys(Keys.ENTER);

        String citySelectInput = "Delhi";
        WebElement citySelect = driver.findElement(By.id("react-select-4-input"));

        citySelect.sendKeys(citySelectInput);
        citySelect.sendKeys(Keys.RETURN);
//        citySelect.sendKeys(Keys.RETURN); // вариант окончания

        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()", submit); // вариант окончания

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("tr:nth-child(1) > td:nth-child(2)"))); // добавил задержку, так как ошибка появлялась на всех браузерах

        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText()).isEqualTo(firstNameInput + " " + lastNameInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText()).isEqualTo(userEmailInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText()).isEqualTo(genderRadio.getAttribute("value"));
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(4) > td:nth-child(2)")).getText()).isEqualTo(userNumberInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(5) > td:nth-child(2)")).getText()).isEqualTo(date);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(6) > td:nth-child(2)")).getText()).isEqualTo(subjectsInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(7) > td:nth-child(2)")).getText()).isEqualTo(hobby.getText());
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(8) > td:nth-child(2)")).getText()).isEqualTo(pictureName);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(9) > td:nth-child(2)")).getText()).isEqualTo(currentAddressInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(10) > td:nth-child(2)")).getText()).isEqualTo(stateSelectInput + " " + citySelectInput);

        softAssert.assertAll();
    }

}
