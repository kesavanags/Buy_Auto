package Common.Report;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class Report {
    public ExtentTest test;
    public static ExtentReports extent;

    DateFormat form = new SimpleDateFormat("YYYY/MMMdd");
    Date d = new Date();
    String date = form.format(d).toString();

    public ExtentReports startResult() {
        extent = new ExtentReports("report.html", false);
        extent.loadConfig(new File("extent-config.xml"));
        return extent;
    }

    public ExtentTest startofTestCase(String testCaseName, String testDescription) {
        test = extent.startTest(testCaseName, testDescription);
        return test;
    }

    public void endofResult() {
        extent.flush();
    }

    public void endofTestcase() {
        extent.endTest(test);
    }

    public abstract long takeASnapshot();

    public void reportTestStep(String desc, String status) {

        long snapNumber = 2000002;

        try {
            snapNumber = takeASnapshot();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (status.toUpperCase().equals("PASS")) {
            test.log(LogStatus.PASS, desc + test.addScreenCapture("reports/images/" + date + "/" + snapNumber + ".jpg"));
        } else if (status.toUpperCase().equals("FAIL")) {
            test.log(LogStatus.FAIL, desc + test.addScreenCapture("reports/images/" + date + "/" + snapNumber + ".jpg"));
            throw new RuntimeException("FAILED");
        } else if (status.toUpperCase().equals("INFO")) {
            test.log(LogStatus.INFO, desc);
        } else if (status.toUpperCase().equals("WARN")) {
            test.log(LogStatus.WARNING, desc + test.addScreenCapture("reports/images/" + date + "/" + snapNumber + ".jpg"));
        }
    }


}