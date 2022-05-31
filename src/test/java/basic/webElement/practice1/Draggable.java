package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Draggable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver draggableDriver = new ChromeDriver();
        draggableDriver.navigate().to("http://www.leafground.com/pages/drag.html");
        WebElement draggableEle= draggableDriver.findElement(By.id("draggable"));
        Actions act = new Actions(draggableDriver);
        act.clickAndHold(draggableEle).moveToElement(draggableEle,135,143).build().perform();
    }
}
