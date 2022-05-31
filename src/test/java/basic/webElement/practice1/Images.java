package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Images {
     public static void main(String[] args) throws InterruptedException {
          WebDriverManager.chromedriver().setup();
          WebDriver imageDriver = new ChromeDriver();
          imageDriver.navigate().to("http://www.leafground.com/pages/Image.html");
          WebElement image1=imageDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div/div/div/img[1]"));
          Thread.sleep(3111);
          image1.click();
          Thread.sleep(3111);
          imageDriver.navigate().to("http://www.leafground.com/pages/Image.html");
          WebElement image2=imageDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[2]/div/div/img"));
          String image2Address = image2.getAttribute("src");
          try {
               URL url= new URL(image2Address);
               HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
               urlConnect.setConnectTimeout(4111);
               urlConnect.connect();
               if(urlConnect.getResponseCode()==404){
                    System.out.println("The image is broken ");
               }
          } catch (MalformedURLException e) {
               throw new RuntimeException(e);
          } catch (IOException e) {
               throw new RuntimeException(e);
          }
          


     }
}
