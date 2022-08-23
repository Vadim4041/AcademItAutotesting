package ru.academIts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practicum2 {
    @Test
    public void simpleTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        Thread.sleep(1500);

        driver.get("https://the-internet.herokuapp.com/");
        

    }
}
