package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class ButttonAutomate {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver buttonT = new ChromeDriver();
        buttonT.get("http://www.leafground.com/pages/Button.html");
        WebElement position =buttonT.findElement(By.xpath("//button[@id='position']"));
        WebElement colorId = buttonT.findElement(By.xpath("//button[@id='color']"));
        WebElement sizeDim= buttonT.findElement(By.xpath("//button[@id='size']"));
        WebElement homePage = buttonT.findElement(By.xpath("//button[@id='home']"));
        Point pointPosition =position.getLocation();
        int xPos =pointPosition.getX();
        int yPos =pointPosition.getY();
        System.out.println("the Position of the button is  ["+xPos+","+yPos+"]");
        String btnColor =colorId.getCssValue("background-color");
        System.out.println(btnColor);
        Dimension btnDimen= sizeDim.getSize();
        int heightBtn =btnDimen.getHeight();
        int widthBtn= btnDimen.getWidth();
        System.out.println("The Dimensions are "+heightBtn+" , "+widthBtn);
        Thread.sleep(3000);
        homePage.click();
        Thread.sleep(3000);
        buttonT.quit();



    }
}
