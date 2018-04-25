package Tests;

import Common.AgilysysCommon;
import Common.jira.CustomEmailableReporter;
import Common.jira.JiraServer;
import Pages.LoginPage;
import org.testng.annotations.*;

@JiraServer(domain = "jira.agilysys.local", ssl = false)
@Listeners(CustomEmailableReporter.class)
@Test
public class BuySample extends AgilysysCommon{



    @AfterMethod
    public void afterMethod() {
        System.out.println("Test finished.");
        System.out.println("-------------------------------------------------------------------");
    }

    @BeforeClass
    public void beforeClass(){
        startResult();
    }

    @BeforeMethod
    public void beforeMethod()
    {
        startTestCase("Login","login successful");
        invokeApp("chrome");
    }

    @Test()
    public void TestSample() throws InterruptedException {

        new LoginPage(driver,test)
                .enterUserName()
                .enterPassword()
                .clickNext()
                .clickElement()
                .clickNext();
    }

}