package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class AutoSelectable {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver autoDriver = new ChromeDriver();
        autoDriver.navigate().to("http://www.leafground.com/pages/autoComplete.html");
        WebElement inputBox = autoDriver.findElement(By.id("tags"));
        inputBox.sendKeys("S");
        Thread.sleep(1111);
        List<WebElement> items = autoDriver.findElements(By.xpath("//ul[@id=\"ui-id-1\"]/li/div"));
        for (WebElement tagItem:items) {
            if(tagItem.getText().equalsIgnoreCase("Selenium")){
                tagItem.click();
                break;
            }
        }
        autoDriver.quit();
    }
}
