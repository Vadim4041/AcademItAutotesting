package ru.academIts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class webDriver {

    @Test
    public void simpleTest() {

        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.get("https://ya.ru/");
    }

//    не работает у меня почему-то, у преподавателя все нормально запускается
    // По поводу моей проблемы с открытием в edge, причина в том, что у меня был "slf4j" старой версии, добавил в dependencies новую, и все заработало
    // https://stackoverflow.com/questions/7421612/slf4j-failed-to-load-class-org-slf4j-impl-staticloggerbinder
//    @Test
//    public void simpleTest() {
//
//        WebDriverManager.edgedriver().setup();
//        EdgeDriver driver = new EdgeDriver();
//
//        driver.get("https://ya.ru/");
//    }
}
