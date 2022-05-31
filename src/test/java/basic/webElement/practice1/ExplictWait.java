package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ExplictWait {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver waitDriver = new ChromeDriver();
        waitDriver.navigate().to("http://www.leafground.com/pages/TextChange.html");
        WebDriverWait btnText = new WebDriverWait(waitDriver, Duration.ofSeconds(123));
        btnText.until(ExpectedConditions.textToBe(By.id("btn"),"Click ME!"));
        WebElement button = waitDriver.findElement(By.id("btn"));
        System.out.println(button.getText());
        waitDriver.navigate().to("http://www.leafground.com/pages/disapper.html");
        WebElement button1 =waitDriver.findElement(By.id("btn"));
        System.out.println(button1.getText());
        WebDriverWait btnDisappear = new WebDriverWait(waitDriver, Duration.ofSeconds(123));
        btnDisappear.until(ExpectedConditions.invisibilityOf(button1));
        System.out.println(button1.getText());




    }
}
