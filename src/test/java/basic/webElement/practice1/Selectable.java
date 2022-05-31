package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Selectable {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver selectableDriver = new ChromeDriver();
        selectableDriver.navigate().to("http://www.leafground.com/pages/selectable.html");
        List<WebElement> items =selectableDriver.findElements(By.xpath("//ol[@id=\"selectable\"]/li"));
        Actions act =new Actions(selectableDriver);
        act.keyDown(Keys.CONTROL).clickAndHold(items.get(0)).clickAndHold(items.get(3)).build().perform();

    }
}
