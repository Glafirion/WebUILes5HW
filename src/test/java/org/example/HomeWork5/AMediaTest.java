package org.example.HomeWork5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;



public class AMediaTest {

    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    private final static String AMEDIA_BASE_URL = "https://amedia.online/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(AMEDIA_BASE_URL);

    }
    @Test
    void likeTopAnimeTest() {
        driver.findElement(By.xpath("//i[@class='fa fa-user-circle-o']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_name")));
        Assertions.assertEquals(driver.findElement(By.id("login_name")).isDisplayed(), true);
        driver.findElement(By.id("login_name")).sendKeys("Raditest");
        driver.findElement(By.id("login_password")).sendKeys("Plkoijhuyg");
        driver.findElement(By.xpath("//button[@title='Вход']")).click();
        driver.findElement(By.xpath("//img[@alt='Постер к аниме Боевой Континент 3']")).click();
        driver.findElement(By.xpath("//*[@id=\"ratig-layer-393\"]/div/a[1]")).click();
    }

    @Test
        void hoverGenreButtonAndClickMartialArtTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='show-menu']")).click();
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Жанры')]")));
        actions.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Жанры')]")))
                .click(driver.findElement(By.xpath("//a[contains(text(),'Жанры')]")))
                .build()
                .perform();
        //Thread.sleep(3000);
        //webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Боевые искусства')]")));
        driver.findElement(By.xpath("//a[contains(text(),'Боевые искусства')]")).click();
        Assertions.assertEquals(driver.getCurrentUrl(),
                "https://amedia.online/ghanr/%D0%B1%D0%BE%D0%B5%D0%B2%D1%8B%D0%B5%20%D0%B8%D1%81%D0%BA%D1%83%D1%81%D1%81%D1%82%D0%B2%D0%B0/");
    }


        //
    @AfterEach
    void quitBrowser() {
        driver.quit();
    }
}
