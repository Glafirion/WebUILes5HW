package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RORtest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.returnofreckoning.com/forum/ucp.php?mode=login");
        WebElement loginForm = driver.findElement(By.id("username"));
        loginForm.sendKeys("Raditest");
        driver.findElement(By.id("password")).sendKeys("Plkoijhuyg");
        Thread.sleep(1500);

        //If you have in your browser ADBLOCK addon release strings 21 and 22
        //driver.findElement(By.xpath("//*[@id=\"phpbb\"]/div[6]/div[7]/div/button")).click();
        //Thread.sleep(1500);

        driver.findElement(By.className("button1")).click();
        Thread.sleep(1500);
        driver.findElement(By.id("keywords")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("keywords")).sendKeys("lion");
        Thread.sleep(500);
        driver.findElement(By.xpath("//*[@id=\"search\"]/fieldset/button")).click();

        Thread.sleep(5000);
        driver.quit();



    }
}
