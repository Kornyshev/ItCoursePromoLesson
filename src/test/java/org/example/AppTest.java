package org.example;

import org.junit.jupiter.api.*;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AppTest {

    WebDriver driver;

    @BeforeEach
    void createDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    void testGoogleCom() {
        driver.get("https://ya.ru");
        WebElement searchField = driver.findElement(By.cssSelector("form input#text"));
        searchField.sendKeys("Selenium");
        searchField.submit();
        List<WebElement> searchResults = driver.findElements(By.xpath("//ul[contains(@aria-label,'Результаты поиска')]/li"));
        Assertions.assertEquals(11, searchResults.size());
    }

    @AfterEach
    void destroyDriver() {
        driver.quit();
    }

}
