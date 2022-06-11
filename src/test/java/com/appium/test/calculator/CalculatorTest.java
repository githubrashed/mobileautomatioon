package com.appium.test.calculator;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CalculatorTest {
    AndroidDriver driver;
    protected WebDriverWait wait;

    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Galaxy M12");
        desiredCapabilities.setCapability("udid", "RF8R40CNNNE");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("platformVersion", "11");
        desiredCapabilities.setCapability("appPackage", "com.continuum.emi.calculator");
        desiredCapabilities.setCapability("appActivity", "com.finance.emicalci.activity.Splash_screnn");

        URL url = new URL("http://127.0.0.1:4723/wd/hub");
        AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
        Thread.sleep(10000);
//      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(GeneralUtil.WAIT_TIME));

        System.out.println("Application started successfully");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        /*driver.findElement((By.xpath("//android.widget.TextView[@content-desc=\"EMI Calculator\"]"))).click();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(10)));*/

        driver.findElement((By.id("btnStart"))).click();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        WebElement etLoanAmount = driver.findElement((By.id("etLoanAmount")));
        etLoanAmount.sendKeys("100000");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        driver.findElement((By.id("etInterest"))).sendKeys("8");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        WebElement etYears = driver.findElement((By.id("etYears")));
        etYears.isDisplayed();
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));
        etYears.sendKeys("1");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        driver.findElement((By.id("etFee"))).sendKeys("5");
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        driver.findElement((By.id("btnCalculate"))).click();

        WebElement monthly_emi_result = driver.findElement(By.id("monthly_emi_result"));
        monthly_emi_result.isDisplayed();
        String monthly_emi_result1 = monthly_emi_result.getText().trim().replaceAll(",", "");
        System.out.println("monthly_emi_result1:" + monthly_emi_result1);
        Assert.assertEquals("4280.37", monthly_emi_result1);

        WebElement total_interest_result = driver.findElement(By.id("total_interest_result"));
        monthly_emi_result.isDisplayed();
        String total_interest_result1 = monthly_emi_result.getText().trim().replaceAll(",", "");
        System.out.println("total_interest_result1:" + total_interest_result1);
        Assert.assertEquals("1364.49", total_interest_result1);

        WebElement processing_fee_result = driver.findElement(By.id("processing_fee_result"));
        monthly_emi_result.isDisplayed();
        String processing_fee_result1 = monthly_emi_result.getText().trim().replaceAll(",", "");
        System.out.println("processing_fee_result1:" + processing_fee_result1);
        Assert.assertEquals("2500", processing_fee_result1);

        WebElement total_payment_result = driver.findElement(By.id("total_payment_result"));
        monthly_emi_result.isDisplayed();
        String total_payment_result1 = monthly_emi_result.getText().trim().replaceAll(",", "");
        System.out.println("total_payment_result1:" + total_payment_result1);
        Assert.assertEquals("51364.49", total_payment_result1);

        /*if ("4280.37" == monthly_emi_result1) {
            System.out.println("Monthly EMI asserted properly and Test case passed");
        }*/
    }
}
