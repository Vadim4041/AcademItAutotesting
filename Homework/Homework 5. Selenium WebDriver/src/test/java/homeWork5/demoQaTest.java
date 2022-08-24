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

import java.time.Duration;

public class demoQaTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        driver = null;
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
    public void formTest() throws InterruptedException {
        SoftAssertions softAssert = new SoftAssertions();

        String firstNameInput = "firstNameInput";
        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(firstNameInput);

        String lastNameInput = "lastNameInput";
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(lastNameInput);

        String userEmailInput = "userEmailInput@mail.com";
        WebElement userEmail = driver.findElement(By.id("userEmail"));
        userEmail.sendKeys(userEmailInput);

        WebElement genderRadio = driver.findElement(By.id("gender-radio-3"));
        System.out.println(genderRadio.getAttribute("value"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", genderRadio);


        WebElement userNumber = driver.findElement(By.id("userNumber"));
        userNumber.sendKeys("1111111111");

        WebElement dateOfBirthInput = driver.findElement(By.id("dateOfBirthInput"));
        dateOfBirthInput.sendKeys(Keys.CONTROL + "a");
        dateOfBirthInput.sendKeys("11 Sep 1996");
        dateOfBirthInput.sendKeys(Keys.ENTER);


        WebElement subjects = driver.findElement(By.id("subjectsInput"));
        subjects.click();
        subjects.sendKeys("Maths");
        subjects.sendKeys(Keys.ENTER);

        WebElement hobbiesCheckbox = driver.findElement(By.id("hobbies-checkbox-2"));
        js.executeScript("arguments[0].click()", hobbiesCheckbox);

//    TODO сделать решение с загрузкой картинки
//     WebElement uploadPicture = driver.findElement(By.id("uploadPicture"));
//        js.executeScript("arguments[0].click()", uploadPicture);
//        uploadPicture.sendKeys(Keys.ESCAPE);

        WebElement currentAddress = driver.findElement(By.id("currentAddress"));
        currentAddress.sendKeys("currentAddress");

        WebElement stateSelect = driver.findElement(By.id("react-select-3-input"));
        stateSelect.sendKeys("NCR");
        stateSelect.sendKeys(Keys.ENTER);

        WebElement citySelect = driver.findElement(By.id("react-select-4-input"));

        citySelect.sendKeys("Delhi");
        citySelect.sendKeys(Keys.RETURN);
//        citySelect.sendKeys(Keys.RETURN); // вариант окончания

        WebElement submit = driver.findElement(By.id("submit"));
        js.executeScript("arguments[0].click()", submit); // вариант окончания

        System.out.println(123);

        WebElement FirstLastName = driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)"));
        System.out.println(FirstLastName.getText());

        System.out.println(firstNameInput + " " + lastNameInput);
        System.out.println(genderRadio.getAttribute("value"));
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(1) > td:nth-child(2)")).getText()).isEqualTo(firstNameInput + " " + lastNameInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(2) > td:nth-child(2)")).getText()).isEqualTo(userEmailInput);
        softAssert.assertThat(driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(2)")).getText()).isEqualTo(genderRadio.getAttribute("value"));
        // Возможно, получится не задавать переменные для текста, а взять их с тех, что были записаны? скорее всего нет
//        Thread.sleep(5000);


        softAssert.assertAll();
    }

}
