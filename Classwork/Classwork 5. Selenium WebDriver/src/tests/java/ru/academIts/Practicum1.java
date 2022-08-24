package ru.academIts;
//• Реализовать тест на открытие страницы
//        https://the-internet.herokuapp.com/
//        • Проверить, что title страницы – «The Internet»

import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Practicum1 {
    @Test
    public void herokuOpenChrome() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriverChrome = new ChromeDriver();

        webDriverChrome.get("https://the-internet.herokuapp.com/");

        Assertions.assertAll(
                () -> assertEquals("https://the-internet.herokuapp.com/", webDriverChrome.getCurrentUrl()),
                () -> assertEquals("The Internet", webDriverChrome.getTitle())
        );
        System.out.println(webDriverChrome.getTitle());
        webDriverChrome.getTitle();


        webDriverChrome.quit();
    }

    @Test
    public void herokuOpenChromeSoft() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriverChrome1 = new ChromeDriver();

        webDriverChrome1.get("https://the-internet.herokuapp.com/");

        SoftAssertions softAssert = new SoftAssertions();

        softAssert.assertThat(webDriverChrome1.getCurrentUrl()).isEqualTo("https://the-internet.herokuapp.com/");
        softAssert.assertThat(webDriverChrome1.getTitle()).isEqualTo("The Internet");

        webDriverChrome1.quit();
        softAssert.assertAll();
    }

    @Test
    public void herokuOpenEdge() {
        WebDriverManager.edgedriver().setup();
        WebDriver webDriverEdge = new EdgeDriver();
        webDriverEdge.get("https://the-internet.herokuapp.com/");
        webDriverEdge.quit();
        // По поводу моей проблемы с открытием в edge, причина в том, что у меня был "slf4j" старой версии, добавил в dependencies новую, и все заработало
        // https://stackoverflow.com/questions/7421612/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder
    }

    @Test
    public void herokuOpenFirefox() {
        WebDriverManager.firefoxdriver().setup();
        WebDriver webDriverFirefox = new FirefoxDriver();

        webDriverFirefox.get("https://the-internet.herokuapp.com/");
        webDriverFirefox.quit();
    }
}
