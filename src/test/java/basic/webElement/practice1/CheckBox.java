package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBox {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver checkDriver= new ChromeDriver();
        checkDriver.navigate().to("http://www.leafground.com/pages/checkbox.html");
        WebElement java = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]/input[1]"));
        WebElement vb = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]/input[2]"));
        WebElement sql = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]/input[3]"));
        WebElement c = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]/input[4]"));
        WebElement cPlus = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[1]/input[5]"));
        //java is selected by click method
        java.click();
        //sql is selected by click method
        sql.click();
        //cplus is selected by click method
        cPlus.click();
        //printing of status of vb selection
        System.out.println("selection status of vb "+vb.isSelected());
        //printing of status of c selection
        System.out.println("selection status of c  "+c.isSelected());
        //creating and assigning a web element through xpath
        WebElement confirmation = checkDriver.findElement(By.xpath("//section[@class=\"innerblock\"]/div[2]/input"));
        //printing of status of selenium selection
        System.out.println("selection status of "+confirmation.isSelected());
        List<WebElement> deselectE1 = checkDriver.findElements(By.xpath("//section[@class=\"innerblock\"]/div[3]/input"));
        for (WebElement i:deselectE1) {
            if(i.isSelected()){
                System.out.println("name of the selected checkbox "+i.getText());
            }
        }
        List<WebElement> allOptions = checkDriver.findElements(By.xpath("//section[@class=\"innerblock\"]/div[4]/input"));
        for (WebElement i:allOptions) {
            i.click();
        }

    }
}
