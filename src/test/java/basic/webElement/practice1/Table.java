package basic.webElement.practice1;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class Table {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver tableDriver = new ChromeDriver();
        tableDriver.navigate().to("http://www.leafground.com/pages/table.html");
        String detail = "Learn to interact with Elements";
        List<WebElement> headerElements =tableDriver.findElements(By.xpath("//table/tbody/tr/th"));
        System.out.println("The Number of columns are "+headerElements.size());
        for(int i=2;i<6;i++){
            WebElement currentEle = tableDriver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]/font"));
            if(detail.equalsIgnoreCase(currentEle.getText())){
                WebElement progressElement = tableDriver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]/font"));
                System.out.println("The process percentage is of "+detail+" "+progressElement.getText());
            }
        }
        tableDriver.quit();

    }
}
