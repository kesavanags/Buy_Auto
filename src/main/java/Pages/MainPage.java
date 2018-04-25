package Pages;

import Common.AgilysysCommon;
import com.relevantcodes.extentreports.ExtentTest;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MainPage extends AgilysysCommon {

    public MainPage(RemoteWebDriver driver,ExtentTest test){
        this.driver = driver;
        this.test=test;

    }

}
