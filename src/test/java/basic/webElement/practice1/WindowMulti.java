package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class WindowMulti {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver windowDriver= new ChromeDriver();
        windowDriver.navigate().to("http://www.leafground.com/pages/Window.html");
        By buttonone = new By.ByXPath("//button[@onclick=\"openWin();\"]");
        WebElement windowOne = windowDriver.findElement(buttonone);
        String parentWindow = windowDriver.getWindowHandle();
        Thread.sleep(3111);
        windowOne.click();
       Set<String> windows= windowDriver.getWindowHandles();
       System.out.println(windows);
        for (String i :windows) {
            if (!i.equalsIgnoreCase(parentWindow)){
                windowDriver.switchTo().window(i);
            }
        }
        By buttonTwo = new By.ByXPath("//ul[@class=\"wp-categories-list\"]/child::li[11]");
        WebElement windowCat = windowDriver.findElement(buttonTwo);
        Thread.sleep(4111);
        windowCat.click();
        System.out.println(windows.size());

    }
}
