package com.appium.test.calculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CalculatorTest extends BaseEmiCalculatorTest {


    @Test
    public void emiCalculatorTest() {

        WebElement btnStart = driver.findElement((By.id("btnStart")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By) btnStart)));
        btnStart.click();

        WebElement etLoanAmount = driver.findElement((By.id("etLoanAmount")));
        etLoanAmount.isDisplayed();
        etLoanAmount.sendKeys("100000");
        GeneralUtil.implicitWait();

        driver.findElement((By.id("etInterest"))).sendKeys("8");
        GeneralUtil.implicitWait();

        WebElement etYears = driver.findElement((By.id("etYears")));
        etYears.isDisplayed();
        GeneralUtil.implicitWait();
        etYears.sendKeys("1");
        GeneralUtil.implicitWait();

        driver.findElement((By.id("etFee"))).sendKeys("5");
        GeneralUtil.implicitWait();

        WebElement btnCalculate = driver.findElement((By.id("btnCalculate")));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement((By) btnCalculate)));
        btnCalculate.click();

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
    }

}




