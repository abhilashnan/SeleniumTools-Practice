package basic.webElement.practice1;
// we create a package of name basic.webElement.practice1
// these libraries automatically import when we use them in our program and thanks to IDE for that
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// creating a public class of name Test
public class Test {
    // creating a method named editTool in order to start the execution form here
        public static void editTool() throws InterruptedException {
            //here we use the chrome platform to automate.so,we set up the chromedriver
            //if the chrome drive library is not available, it automatically downloads
            WebDriverManager.chromedriver().setup();
            // we create a chromedriver object and assign it to variable name driver which is of WebDriver
            WebDriver driver = new ChromeDriver();
            // we are requesting a url to open by get method and provide the url as a parameter to it
            driver.get("http://www.leafground.com/pages/Edit.html");
            // we assign the web elements to their assigned variable names by their specific xpath addresses
            WebElement emailEntry = driver.findElement(By.xpath("//input[@id='email']"));
            WebElement appendExmp = driver.findElement(By.xpath("//section[@class='innerblock']/div[2]/div/div/input"));
            WebElement obtainAttribute = driver.findElement(By.xpath("//input[@name='username']"));
            WebElement confirmArea = driver.findElement(By.xpath("//input[@style=\"width:350px;background-color:LightGrey;\"]"));
            // providing a email address by sendKeys method pointing to the assigned web element name
            emailEntry.sendKeys("naniabhilash22@gmail.com");
            //  making the execution to pause for 5 seconds
            Thread.sleep(5000);
            //  clearing the area of appendExmp named web element by using clear method
            appendExmp.clear();
            // providing a string  to the appendEmp named element by senMethod
            appendExmp.sendKeys("after clear");
            // since the return type of get attribute is string data. So, we assign it to a string variable of name userName
            // here get attribute method is used to return mentioned  attribute value present in the web element
            String userName = obtainAttribute.getAttribute("value");
            // Printing the username
            System.out.println(userName);
            // since the return type of get attribute is boolean. So, we assign it to a string variable of name userName
            // here isenabled method return the boolean valve of the confirmArea web element
            boolean isabled = confirmArea.isEnabled();
            //printing the value of isabled
            System.out.print(isabled);
            driver.quit();
        }
    // creating a main method  in order to start the execution form here
        public static void main(String[] args) throws InterruptedException {
            //calling the method named editTool
        editTool();
    }

}
