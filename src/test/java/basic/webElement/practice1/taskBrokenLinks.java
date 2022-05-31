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
import java.util.List;

public class taskBrokenLinks {
    public static void main(String[] args)  {
        WebDriverManager.chromedriver().setup();
        WebDriver brokenDriver = new ChromeDriver();
        brokenDriver.navigate().to("http://www.leafground.com/pages/Link.html");
        List<WebElement> allLinks =brokenDriver.findElements(By.tagName("a"));
        for (WebElement i:allLinks) {
            String unknownLink = i.getAttribute("href");
            try {
               URL url = new URL(unknownLink);
                HttpURLConnection huc= (HttpURLConnection)url.openConnection();
                huc.setConnectTimeout(4000);
                huc.connect();
                if (huc.getResponseCode()==200){
                    System.out.println(unknownLink+" is a secure link with a response code"+huc.getResponseCode());
                }
                else {
                    System.out.println(unknownLink+" is a broken link with a response code"+huc.getResponseCode());
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        brokenDriver.quit();
    }
}
