package Common;

//import Common.Report.Report;

import Common.Report.Report;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class AgilysysCommon extends Report implements InterfaceCommon {
    public AgilysysCommon(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public RemoteWebDriver driver;
    protected static Properties prop;
    public String sUrl, primaryWindowHandle;

    public AgilysysCommon() {
        sUrl = "http://buy-test-buy-01.bellevue.agilysys.com:8080/login";
    }

    public void invokeTestApp(String browser) {
        invokeApp(browser, false);
    }


    public void invokeApp(String browser, boolean bRemote) {
        try {

            DesiredCapabilities dc = new DesiredCapabilities();
            dc.setBrowserName(browser);
            dc.setPlatform(Platform.WINDOWS);

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver",
                        "C:\\chromedriver.exe");
                driver = new ChromeDriver();
            } else {
                System.setProperty("webdriver.gecko.driver",
                        "./drivers/geckodriver.exe");
                driver = new FirefoxDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(sUrl);

            primaryWindowHandle = driver.getWindowHandle();
            reportTestStep("The browser:" + browser + " launched successfully",
                    "PASS");

        } catch (Exception e) {
            e.printStackTrace();
            reportTestStep("The browser:" + browser + " could not be launched",
                    "FAIL");
        }
    }


    public void enterById(String idValue, String data) {
        try {
            driver.findElement(By.id(idValue)).clear();
            driver.findElement(By.id(idValue)).sendKeys(data);
            reportTestStep("The data: " + data + " entered successfully in field :"
                    + idValue, "PASS");
        } catch (NoSuchElementException e) {
            reportTestStep("The data: " + data
                    + " could not be entered in the field :" + idValue, "FAIL");
        } catch (WebDriverException e) {
            reportTestStep("Unknown exception occured while entering " + data
                    + " in the field :" + idValue, "FAIL");
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while entering " + data
                    + " in the field :" + idValue, "FAIL");
        }
    }

    public void enterByName(String nameValue, String data) {
        try {
            driver.findElement(By.name(nameValue)).clear();
            driver.findElement(By.name(nameValue)).sendKeys(data);
            reportTestStep("The data: " + data + " entered successfully in field :"
                    + nameValue, "PASS");

        } catch (NoSuchElementException e) {
            reportTestStep("The data: " + data
                            + " could not be entered in the field :" + nameValue,
                    "FAIL");
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while entering " + data
                    + " in the field :" + nameValue, "FAIL");
        }

    }

    public void enterByXpath(String xpathValue, String data) {
        try {
            driver.findElement(By.xpath(xpathValue)).clear();
            driver.findElement(By.xpath(xpathValue)).sendKeys(data);
            reportTestStep("The data: " + data + " entered successfully in field :"
                    + xpathValue, "PASS");

        } catch (NoSuchElementException e) {
            reportTestStep("The data: " + data
                            + " could not be entered in the field :" + xpathValue,
                    "FAIL");
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while entering " + data
                    + " in the field :" + xpathValue, "FAIL");
        }

    }

    public boolean verifyTitle(String title) {
        boolean bReturn = false;
        try {
            if (driver.getTitle().equalsIgnoreCase(title)) {
                reportTestStep("The title of the page matches with the value :"
                        + title, "PASS");
                bReturn = true;
            } else {
                reportTestStep(
                        "The title of the page:" + driver.getTitle()
                                + " did not match with the value :" + title,
                        "SUCCESS");

            }
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while verifying the title",
                    "FAIL");
        }
        return bReturn;
    }

    public void verifyTextByXpath(String xpath, String text) {
        try {
            String sText = driver.findElementByXPath(xpath).getText();
            if (sText.equalsIgnoreCase(text)) {
                reportTestStep("The text: " + sText + " matches with the value :"
                        + text, "PASS");
            } else {
                reportTestStep("The text: " + sText
                        + " did not match with the value :" + text, "FAIL");
            }
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while verifying the title",
                    "FAIL");
        }
    }

    public void verifyTextContainsByXpath(String xpath, String text) {
        try {
            String sText = driver.findElementByXPath(xpath).getText();
            if (sText.contains(text)) {
                reportTestStep(
                        "The text: " + sText + " contains the value :" + text,
                        "PASS");
            } else {
                reportTestStep("The text: " + sText + " did not contain the value :"
                        + text, "FAIL");
            }
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while verifying the title",
                    "FAIL");
        }
    }

    public void verifyTextById(String id, String text) {
        try {
            String sText = driver.findElementById(id).getText();
            if (sText.equalsIgnoreCase(text)) {
                reportTestStep("The text: " + sText + " matches with the value :"
                        + text, "PASS");
            } else {
                reportTestStep("The text: " + sText
                        + " did not match with the value :" + text, "FAIL");
            }
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while verifying the title",
                    "FAIL");
        }
    }

    public void verifyTextContainsById(String id, String text) {
        try {
            String sText = driver.findElementById(id).getText();
            if (sText.contains(text)) {
                reportTestStep(
                        "The text: " + sText + " contains the value :" + text,
                        "PASS");
            } else {
                reportTestStep("The text: " + sText + " did not contain the value :"
                        + text, "FAIL");
            }
        } catch (Exception e) {
            reportTestStep("Unknown exception occured while verifying the title",
                    "FAIL");
        }
    }

    public void quitBrowser() {
        try {
            driver.quit();
        } catch (Exception e) {
            reportTestStep(
                    "The browser:" + driver.getCapabilities().getBrowserName()
                            + " could not be closed.",
                    "FAIL");
        }

    }

    public void clickById(String id) {
        try {

            driver.findElement(By.id(id)).click();
            reportTestStep("The element with id: " + id + " is clicked.", "PASS");

        } catch (NoSuchElementException e) {
            reportTestStep("The element with id: " + id + " could not be clicked.",
                    "FAIL");
        } catch (Exception e) {
            reportTestStep("The element with id: " + id + " could not be clicked.",
                    "FAIL");
        }
    }

    public void clickByClassName(String classVal) {
        try {
            driver.findElement(By.className(classVal)).click();
            reportTestStep(
                    "The element with class Name: " + classVal + " is clicked.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The element with class Name: " + classVal
                    + " could not be clicked.", "FAIL");
        }
    }

    public void clickByName(String name) {
        try {
            driver.findElement(By.name(name)).click();
            reportTestStep("The element with name: " + name + " is clicked.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep(
                    "The element with name: " + name + " could not be clicked.",
                    "FAIL");
        }
    }

    public void clickByLink(String name) {
        try {
            driver.findElement(By.linkText(name)).click();
            reportTestStep("The element with link name: " + name + " is clicked.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The element with link name: " + name
                    + " could not be clicked.", "FAIL");
        }
    }

    public void clickByLinkNoSnap(String name) {
        try {
            driver.findElement(By.linkText(name)).click();
            reportTestStep("The element with link name: " + name + " is clicked.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The element with link name: " + name
                    + " could not be clicked.", "FAIL");
        }
    }

    public void clickByXpath(String xpathVal) {
        try {
            driver.findElement(By.xpath(xpathVal)).click();
            reportTestStep("The element : " + xpathVal + " is clicked.", "PASS");
        } catch (Exception e) {
            reportTestStep("The element with xpath: " + xpathVal
                    + " could not be clicked.", "FAIL");
        }
    }

    public void clickByXpathNoSnap(String xpathVal) {
        try {
            driver.findElement(By.xpath(xpathVal)).click();
            reportTestStep("The element : " + xpathVal + " is clicked.", "PASS");
        } catch (Exception e) {
            reportTestStep("The element with xpath: " + xpathVal
                    + " could not be clicked.", "FAIL");
        }
    }

    public void mouseOverByXpath(String xpathVal) {
        try {
            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath(xpathVal)))
                    .build().perform();
            reportTestStep(
                    "The mouse over by xpath : " + xpathVal + " is performed.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The mouse over by xpath : " + xpathVal
                    + " could not be performed.", "FAIL");
        }
    }

    public void mouseClickByXpath(String xpathVal) {
        try {
            new Actions(driver)
                    .moveToElement(driver.findElement(By.xpath(xpathVal)))
                    .click()
                    .build().perform();
            reportTestStep(
                    "The mouse over by xpath : " + xpathVal + " is performed.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The mouse over by xpath : " + xpathVal
                    + " could not be performed.", "FAIL");
        }
    }

    public void enterTextWithActions(String text) {
        try {
            new Actions(driver)
                    .sendKeys(text)
                    .build().perform();
            reportTestStep(
                    "The text " + text + " is keyed in the specified text area",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The text " + text + "could not be keyed in the specified text field",
                    "FAIL");
        }
    }

    public void mouseOverByLinkText(String linkName) {
        try {
            new Actions(driver)
                    .moveToElement(driver.findElement(By.linkText(linkName)))
                    .build().perform();
            reportTestStep(
                    "The mouse over by link : " + linkName + " is performed.",
                    "PASS");
        } catch (Exception e) {
            reportTestStep("The mouse over by link : " + linkName
                    + " could not be performed.", "FAIL");
        }
    }

    public String getTextByXpath(String xpathVal) {
        String bReturn = "";
        try {
            return driver.findElement(By.xpath(xpathVal)).getText();
        } catch (Exception e) {
            reportTestStep("The element with xpath: " + xpathVal
                    + " could not be found.", "FAIL");
        }
        return bReturn;
    }

    public String getTextById(String idVal) {
        String bReturn = "";
        try {
            return driver.findElementById(idVal).getText();
        } catch (Exception e) {
            reportTestStep("The element with id: " + idVal + " could not be found.",
                    "FAIL");
        }
        return bReturn;
    }

    public void selectVisibileTextById(String id, String value) {
        try {
            new Select(driver.findElement(By.id(id)))
                    .selectByVisibleText(value);
            ;
            reportTestStep("The element with id: " + id
                    + " is selected with value :" + value, "PASS");
        } catch (Exception e) {
            reportTestStep("The value: " + value + " could not be selected.",
                    "FAIL");
        }
    }

    public void selectVisibileTextByXPath(String xpath, String value) {
        try {
            new Select(driver.findElement(By.xpath(xpath)))
                    .selectByVisibleText(value);
            ;
            reportTestStep("The element with xpath: " + xpath
                    + " is selected with value :" + value, "PASS");
        } catch (Exception e) {
            reportTestStep("The value: " + value + " could not be selected.",
                    "FAIL");
        }
    }

    public void selectIndexById(String id, String value) {
        try {
            new Select(driver.findElement(By.id(id)))
                    .selectByIndex(Integer.parseInt(value));
            ;
            reportTestStep("The element with id: " + id
                    + " is selected with index :" + value, "PASS");
        } catch (Exception e) {
            reportTestStep("The index: " + value + " could not be selected.",
                    "FAIL");
        }
    }

    public void switchToParentWindow() {
        try {
            Set<String> winHandles = driver.getWindowHandles();
            for (String wHandle : winHandles) {
                driver.switchTo().window(wHandle);
                break;
            }
        } catch (Exception e) {
            reportTestStep("The window could not be switched to the first window.",
                    "FAIL");
        }
    }

    public void switchToLastWindow() {
        try {
            Set<String> winHandles = driver.getWindowHandles();
            for (String wHandle : winHandles) {
                driver.switchTo().window(wHandle);
            }
        } catch (Exception e) {
            reportTestStep("The window could not be switched to the last window.",
                    "FAIL");
        }
    }

    public void acceptAlert() {
        try {
            driver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            reportTestStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportTestStep("The alert could not be accepted.", "FAIL");
        }
    }

    public String getAlertText() {
        String text = null;
        try {
            driver.switchTo().alert().getText();
        } catch (NoAlertPresentException e) {
            reportTestStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportTestStep("The alert could not be accepted.", "FAIL");
        }
        return text;

    }

    public void dismissAlert() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            reportTestStep("The alert could not be found.", "FAIL");
        } catch (Exception e) {
            reportTestStep("The alert could not be accepted.", "FAIL");
        }

    }

    public long takeASnapshot() {

        long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
        DateFormat form = new SimpleDateFormat("YYYY/MMMdd");
        Date d = new Date();
        String date = form.format(d).toString();

        try {
            FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),
                    new File("./reports/images/" + date + "/" + number
                            + ".jpg"));
        } catch (WebDriverException e) {
            reportTestStep("The browser has been closed.", "FAIL");
        } catch (IOException e) {
            reportTestStep("The snapshot could not be taken", "WARN");
        }
        return number;
    }
}
