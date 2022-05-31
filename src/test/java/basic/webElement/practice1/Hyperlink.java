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

public class Hyperlink {
    //creating a main method to run the program
    public static void main(String[] args) throws InterruptedException {
        //we are making sure that chromedriver is present in PC if not it sets up with the same version of browser and driver
        WebDriverManager.chromedriver().setup();
        //creating a Chrome driver object of webdriver returntype
        WebDriver linkDriver = new ChromeDriver();
        // providing a url to webdriver in order to navigate to that link by using navigate method
        linkDriver.navigate().to("http://www.leafground.com/pages/Link.html");
        //creating and assigning a web element with name homelink
        //using find element method we track the web element by link Text
        WebElement homeLink = linkDriver.findElement(By.linkText("Go to Home Page"));
        //creating and assigning a web element with name Unknownlink
        WebElement unknownLink =linkDriver.findElement(By.partialLinkText("broken"));
        //this method pauses the execution with the given milliseconds as parameter
        Thread.sleep(5111);
        // homelink web element is clicked by using click method
        homeLink.click();
        Thread.sleep(5111);
        // the link driver navigates back by using the navigate method
        linkDriver.navigate().back();
        // href variable is created and assigned by grabbing the attribute valve of the unknownlink web element
        //get attribute method is used to value which is an string type
        String hrefLink = unknownLink.getAttribute("href");
        //printing the href link present in unknown link
        System.out.println(hrefLink);
        // grabbing all the web elements present with tagname of a
        // assigning them to allLink variable
        List<WebElement> allLink = linkDriver.findElements(By.tagName("a"));
        // printing the size of the list  in other ways we call them length
        System.out.println(allLink.size());
        // grabbing the web element present with sub string of broken and partialLinkText method is used to achieve it
        WebElement linkBroken = linkDriver.findElement(By.partialLinkText("broken"));
        //accessing the attribute valve and assigning to a variable name
        String brokenLinkText = linkBroken.getAttribute("href");
        try {
            //we change the string data tye to a url type
            //we have a class of URL in java to convert
            URL url = new URL(brokenLinkText);
            //
            HttpURLConnection tyeCastedLink = (HttpURLConnection)url.openConnection();
            tyeCastedLink.setConnectTimeout(4000);
            tyeCastedLink.connect();
            if (tyeCastedLink.getResponseCode()==400){
                System.out.println(brokenLinkText+' '+tyeCastedLink.getResponseCode());
            }
            else {
                System.out.println(brokenLinkText+' '+tyeCastedLink.getResponseCode());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        linkDriver.quit();
    }
}
