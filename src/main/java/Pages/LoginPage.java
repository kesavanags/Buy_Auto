package Pages;

import Common.AgilysysCommon;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginPage extends AgilysysCommon {

    String USERNAME="buy_test@0304";
    String PASSWORD="Pa$$word9";

    public LoginPage(RemoteWebDriver driver){
        this.driver = driver;
    }

    public LoginPage enterUserName(){
        enterByName("username",USERNAME);
        return this;
    }
    public LoginPage
    enterPassword(){
        enterByName("password",PASSWORD);
        return this;
    }

    public DropDownPage clickNext(){
        clickByXpath("//*[text()='Next']");
        return new DropDownPage(driver);
    }
}
