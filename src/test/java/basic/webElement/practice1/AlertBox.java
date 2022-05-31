package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.stream.Stream;

import static java.nio.file.Files.lines;

public class AlertBox {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver alertDriver= new ChromeDriver();
        alertDriver.navigate().to("http://www.leafground.com/pages/Alert.html");
        WebElement alert1 = alertDriver.findElement(By.xpath("//button[@onclick=\"normalAlert()\"]"));
        WebElement alert2 = alertDriver.findElement(By.xpath("//button[@onclick=\"confirmAlert()\"]"));
        WebElement alert3 = alertDriver.findElement(By.xpath("//button[@onclick=\"confirmPrompt()\"]"));
        WebElement alert4 = alertDriver.findElement(By.xpath("//button[@onclick=\"lineBreaks()\"]"));

        alert1.click();
        Alert alertPanel =alertDriver.switchTo().alert();
        Thread.sleep(4111);
        alertPanel.accept();
        alert2.click();
        Thread.sleep(3111);
        alertPanel.accept();
        alert3.click();
        alertPanel.sendKeys("java_selenium");
        Thread.sleep(2111);
        alertPanel.accept();
        alert4.click();
        String text= alertPanel.getText();
        Thread.sleep(3111);
        System.out.println(text);
        alertPanel.dismiss();
        System.out.println(text.contains("\n"));
        alertDriver.quit();
    }
}
