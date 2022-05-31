package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver frameDriver = new ChromeDriver();
        frameDriver.navigate().to("http://www.leafground.com/pages/drop.html");
        WebElement drag = frameDriver.findElement(By.xpath("//div[@id=\"draggable\"]"));
        WebElement drop = frameDriver.findElement(By.xpath("//div[@id=\"droppable\"]"));
        Actions dragAndDrop = new Actions(frameDriver);
        dragAndDrop.clickAndHold(drag).moveToElement(drop).release(drop).build().perform();
    }
}
