package Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
@Test
public class Demo {

    @AfterMethod(alwaysRun = true)
    public void afterMethod() {
        System.out.println("Test finished.");
        System.out.println("-------------------------------------------------------------------");
    }

    @BeforeMethod
    public static void beforeMethod()
    {

    }

    @Test()
    public void Test() {

        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

 //       try {
            String baseUrl = "http://localhost:8502/swagger/ui/index";

            driver.get(baseUrl);

            WebDriverWait wait = new WebDriverWait(driver, 10);
            JavascriptExecutor jse = (JavascriptExecutor) driver;

            driver.manage().window().maximize();
            driver.findElement(By.xpath("//li[@id='Health_Health_GetHealthDetail']/div/h3/span[2]/a")).click();

            WebElement tryItOut = driver.findElement(By.xpath("//div[@id='Health_Health_GetHealth_content']/form/div[2]/input"));


//        Actions actions = new Actions(driver);
//        Actions scrollDown = actions.moveToElement(tryItOut);
//        scrollDown.click().build().perform();

            jse.executeScript("window.scrollBy(0,1000)");

            //jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");

            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='Health_Health_GetHealthDetail_content']/form/div[3]/input"))).click();


            //tryItOut.click();


            String responseJson = driver.findElement(By.xpath("//div[@class='block response_body hljs json']/pre/code")).getText();

            if (responseJson.contains("\"name\": \"rGuest Pay Elavon\",")
                    && responseJson.contains("\"isHealthy\": true")
                    && responseJson.contains("\"serviceGroups\"")
                   // && responseJson.contains("\"id\": \"mirapaydirect\",\n" +
                    //"          \"status\": \"available\"")
//                    && responseJson.contains("\"id\": \"miraserv\",\n" +
//                    "          \"status\": \"available\"")
                    ) {
                System.out.println("Test Passed!");
            } else {
                System.out.println("Test Failed");
            }
       //}
// finally {
//            driver.close();
//        }


    }

}