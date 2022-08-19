package com.appium.test.calculator;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class ExtentReportsTest {

    ExtentSparkReporter htmlReporter;
    ExtentReports extent;

    @BeforeSuite
    public void setupExtentReport() {
        htmlReporter = new ExtentSparkReporter("ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @AfterSuite
    public void tearDownExtendReport() {
        extent.flush();
    }

}
