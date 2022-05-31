package basic.webElement.practice1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Calender {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver calenderDriver = new ChromeDriver();
        calenderDriver.navigate().to("http://www.leafground.com/pages/Calendar.html");
        WebElement inputBox = calenderDriver.findElement(By.id("datepicker"));
        inputBox.click();
        String month= "May";
        String year = "1997";
        calenderDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(121));
        while (true){
            WebElement selectMonth= calenderDriver.findElement(By.xpath("//span[@class=\"ui-datepicker-month\"]"));
            String currentMonth = selectMonth.getText();
            WebElement selectYear= calenderDriver.findElement(By.xpath("//span[@class=\"ui-datepicker-year\"]"));
            String currentYear = selectYear.getText();
            WebElement previousMonth = calenderDriver.findElement(By.xpath("//span[@class=\"ui-icon ui-icon-circle-triangle-w\"]"));

            if (year.equalsIgnoreCase(currentYear)&& month.equalsIgnoreCase(currentMonth)){
                WebElement dateSelect= calenderDriver.findElement(By.xpath("//a[contains(text(),\"29\")]"));
                dateSelect.click();
                break;
            }
            else {
                previousMonth.click();
            }
        }
        Thread.sleep(3111);
        calenderDriver.quit();
    }
}
