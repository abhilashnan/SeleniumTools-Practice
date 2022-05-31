package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RadioButtton {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver radioDriver= new ChromeDriver();
        radioDriver.navigate().to("http://www.leafground.com/pages/radio.html");
        WebElement unChecked = radioDriver.findElement(By.xpath("//input[@name=\"news\"][1]"));
        WebElement checked = radioDriver.findElement(By.xpath("//input[@name=\"news\"][2]"));
        //printing the  unchecked button is selected or not selected of boolean type by is selected method
        System.out.println(unChecked.isSelected());
        // selecting the unchecked button by click
        unChecked.click();
        //printing the  checked button is selected or not selected of boolean type by is selected method
        // it should return us false because unchecked is selected
        System.out.println(checked.isSelected());
    }
}
