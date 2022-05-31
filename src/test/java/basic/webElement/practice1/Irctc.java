package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Irctc {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver ticket= new ChromeDriver();
        ticket.navigate().to("https://www.irctc.co.in/nget/train-search");


    }
}
