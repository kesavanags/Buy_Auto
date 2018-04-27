package Tests;

import Common.AgilysysCommon;
import Common.jira.CustomEmailableReporter;
import Common.jira.JiraServer;
import Pages.LoginPage;
import org.testng.annotations.*;

@JiraServer(domain = "jira.agilysys.local", ssl = false)
@Listeners(CustomEmailableReporter.class)
@Test
public class BuySample extends AgilysysCommon {


    @AfterClass
    public void afterClass() {
        endofResult();

    }

    @AfterMethod
    public void afterMethod() {
        endofTestcase();
        System.out.println("Test finished.");
        System.out.println("-------------------------------------------------------------------");
    }

    @BeforeClass
    public void beforeClass() {
        startResult();
    }

    @BeforeMethod
    public void beforeMethod() {
        startofTestCase("Login", "login successful");
        invokeTestApp("chrome");
    }

    @Test()
    public void TestSample() throws InterruptedException {

        new LoginPage(driver, test)
                .enterUserName()
                .enterPassword()
                .clickNext()
                .clickElement()
                .clickNext();
    }

}