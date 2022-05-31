package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Dropdown {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver dropDriver = new ChromeDriver();
        dropDriver.navigate().to("http://www.leafground.com/pages/Dropdown.html");
        WebElement dropOne =dropDriver.findElement(By.id("dropdown1"));
        Select drop1 =new Select(dropOne);
        drop1.selectByIndex(2);
        WebElement dropTwo =dropDriver.findElement(By.name("dropdown2"));
        Select drop2 =new Select(dropTwo);
        drop2.selectByVisibleText("Loadrunner");
        WebElement dropThree =dropDriver.findElement(By.name("dropdown3"));
        Select drop3 =new Select(dropThree);
        drop3.selectByValue("3");
        WebElement dropFour =dropDriver.findElement(By.className("dropdown"));
        Select drop4= new Select(dropFour);
        List<WebElement> dropdownElements =drop4.getOptions();
        System.out.println(dropdownElements.size());
        WebElement dropFive =dropDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[5]/select"));
        dropFive.sendKeys("Selenium");
        WebElement dropSix =dropDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[6]/select"));
        Select drop6 = new Select(dropSix);
        drop6.selectByValue("0");
        drop6.selectByIndex(2);
        drop6.selectByIndex(3);
        Thread.sleep(5111);
        dropDriver.quit();


    }
}
