Following below step by step instruction to make Appium Environment and run Test case for Windows 11:
--------------------------------------------------------------------------------
Covered area's:
---------------
# Environment set up
# added single test case with value assertion
# TestNG framework
# added Extend Report
# Added screen recording feature

Let's start from here
---------------------

Note: Need to install exe file for all required

1. Download & Install JDK
   https://www.oracle.com/java/technologies/javase/jdk11-archive-downloads.html
2. Download & Install IntelliJ IDEA Community Version
   https://www.jetbrains.com/idea/download/
3. Download & Install android studio Android SDK
   https://developer.android.com/studio
4. Download & Install LTS Node Js
   https://nodejs.org/en/download/
5. Download & Install Vysor
   https://www.vysor.io/download/
6. Download & Install Appium Desktop Apps
   https://github.com/appium/appium-desktop/releases/
7. Go to Command prompt, run with: node --version, npm --version and check node.js & npm are installed properly

- check appium is installed with command: appium -v
- Install appium with node.js by command: npm install -g appium

8. Set environment: variable(path) - Set JAVA_HOME & ANDROID_HOME
9. Go to device setting's, find out developer mode & USB debugging options and turn on developer mode & USB debugging
    - Find build number under settings and tap 7 times on build number.
    - Input required information to enable Developer options menu. The "Developer options" menu will now appear in your
      Settings menu. Turn On the "USB Debugging" option from "Developer Options"
    - Identify appPackage & appActivityName, Open the app in your device and use the command - adb shell "dumpsys
      activity activities | grep mResumedActivity"

- Create TestNG XML plugin install from Marketplace - File >> Setting >> plugin >> Marketplace >> search 'Create TestNG
  XML' & install Create Java(Gradle) Project in IntelliJ IDEA for Appium:

  Create Java(Gradle) Project in IntelliJ IDEA Add Gradle Dependencies
    - Selenium
      https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    - Appium Client
      https://mvnrepository.com/artifact/io.appium/java-client
    - TestNG
      https://mvnrepository.com/artifact/org.testng/testng
    - Desired Capabilities
      https://appium.io/docs/en/writing-running-appium/caps/

  Open existing Java(Gradle) Project using IntelliJ IDEA:
    - Identify Elements
- Start Writing Automation Code
- Run Test Cases

Appium Inspector to Identify Elements:

- Appium Inspector download & install
  https://github.com/appium/appium-inspector/releases

Configure Appium Desktop client & Appium Inspector:

- Appium Desktop

1. Go to Appium Server GUI -> Advanced
2. Server address: localhost
3. Port: 4723
4. Allow CORP: yes
5. Appium Inspector

Go to or Open Appium Inspector:

- Remote host: localhost
- Port: 4723
- Path: /wd/hub
- Allow Unauthorized Certificates

- Select your capabilities
- Start Appium Server GUI First Appium Inspector server will open

Run Test Case - Go to desired Java Class where has Test Case, Right click of mouse on Test Case >> click on Run Run XML
File - After create TestNG file, Right click of mouse on TestNG xml >> click on Run

Related Resources:
Troubleshoot Activities Startup
https://github.com/appium/appium/blob/master/docs/en/writing-running-appium/android/activity-startup.md

Appium API Documentation
https://appium.io/docs/en/about-appium/api/

Selenium WebDriver

https://www.selenium.dev/documentation/webdriver/

Create automated scripts to test mobile app:

- Download & install mobile app your device
- Record Video