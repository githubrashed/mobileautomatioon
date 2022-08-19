package com.appium.test.calculator;

import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class GeneralUtil {
    public static final int IMPLICIT_WAIT_TIME = 20;

    public static AndroidDriver driver;

    public static void implicitWait() {
        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(IMPLICIT_WAIT_TIME)));
    }
}
