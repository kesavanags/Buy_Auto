package Pages;

import Common.AgilysysCommon;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.awt.*;
import java.awt.event.KeyEvent;

public class DropDownPage extends AgilysysCommon {

    DropDownPage(RemoteWebDriver driver,ExtentTest test){
        this.driver = driver;
        this.test=test;
    }

    public DropDownPage clickElement(){
        mouseClickByXpath("*//div[text()='Select store']");
        enterTextWithActions("rgb dev automation store a_1-1");

        try {
            Robot robot = new Robot();
            robot.keyPress(KeyEvent.VK_ENTER);
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return this;
    }

    public MainPage clickNext(){
        clickByXpath("//*[text()='Next']");
        return new MainPage(driver,test);
    }
}
