package com.appium.test.calculator;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.Base64;

public abstract class BaseTest extends ExtentReportsTest {
    static protected AndroidDriver driver;

    protected WebDriverWait wait;

    protected abstract String getAppPackage();

    protected abstract String getAppActivity();

    public void initialization() throws MalformedURLException {

        try {
            DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
            desiredCapabilities.setCapability("deviceName", "Galaxy M12");
            desiredCapabilities.setCapability("udid", "RF8R40CNNNE");
            desiredCapabilities.setCapability("platformName", "Android");
            desiredCapabilities.setCapability("platformVersion", "11");
            desiredCapabilities.setCapability("appPackage", getAppPackage());
            desiredCapabilities.setCapability("appActivity", getAppActivity());

            URL url = new URL("http://127.0.0.1:4723/wd/hub");
            AndroidDriver driver = new AndroidDriver(url, desiredCapabilities);
            System.out.println("Application started successfully");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait((Duration.ofSeconds(5)));

        //Start Screen Record
        driver.startRecordingScreen();
    }

    public void tearDown() {
        stopRecording();
        driver.quit();
    }

    protected void stopRecording() {
        String projectHomeDirectory = System.getProperty("user.dir");
        String base64VideoString = driver.stopRecordingScreen();
        String destinationPath = projectHomeDirectory + "/build/videos";
        byte[] data = Base64.getDecoder().decode(base64VideoString);
        File fileDir = new File(destinationPath);
        if (!fileDir.exists()) {
            fileDir.mkdirs();
        }
        String filePath = destinationPath + "/" + driver.getDeviceTime().replace(":", "_").replace("+", " ") + ".mp4";
        System.out.println("filePath" + filePath);
        Path path = Paths.get(filePath);
        try {
            Files.write(path, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
