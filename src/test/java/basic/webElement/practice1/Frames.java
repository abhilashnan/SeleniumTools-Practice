package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Frames {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver frameDriver = new ChromeDriver();
        frameDriver.navigate().to("http://www.leafground.com/pages/frame.html");
        WebElement frame1 = frameDriver.findElement(By.xpath("//iframe[1]"));
        frameDriver.switchTo().frame(frame1);
        WebElement button1 = frameDriver.findElement(By.xpath("//button[contains(text(),\"Click Me\")]"));
        button1.click();
        frameDriver.switchTo().defaultContent();
        List<WebElement> button3 = frameDriver.findElements(By.xpath("//iframe"));
        System.out.println(button3.size());
    }
}
