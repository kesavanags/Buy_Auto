package Tests;

import Common.AgilysysCommon;
import Pages.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

//comment the above line and uncomment below line to use Chrome
//import org.openqa.selenium.chrome.ChromeDriver;
@Test
public class BuySample extends AgilysysCommon{



    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished.");
        System.out.println("-------------------------------------------------------------------");
    }

    @BeforeMethod
    public void beforeMethod()
    {
        invokeApp("chrome");
    }

    @Test()
    public void TestSample() throws InterruptedException {

        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //Actions actions=new Actions(driver);
        //       try {
        //String baseUrl = "http://buy-test-buy-01.bellevue.agilysys.com:8080/login";

        //driver.get(baseUrl);

        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //JavascriptExecutor jse = (JavascriptExecutor) driver;


        //Login Page
        //driver.manage().window().maximize();

        new LoginPage(driver)
                .enterUserName()
                .enterPassword()
                .clickNext()
                .clickElement()
                .clickNext()
       ;



//        driver.findElement(By.name("username")).sendKeys(USERNAME);
//        driver.findElement(By.name("password")).sendKeys(PASSWORD);
//        driver.findElement(By.xpath("//*[text()='Next']")).click();

        //DropDown page
//        driver.getTitle().equals("rGuest Buy Site Manager");
//        Thread.sleep(5000);
//        WebElement element=driver.findElement(By.xpath("*//div[text()='Select store']"));
//        actions.moveToElement(element);
//        actions.click();
//        actions.sendKeys("rgb dev automation store a_1-1");
//        actions.build().perform();
//        actions.sendKeys(Keys.ENTER).build().perform();
//        driver.findElement(By.xpath("//*[text()='Next']")).click();
//
//        //Main Page
//        driver.getTitle().equals("rGuest Buy Site Manager");

    }

}