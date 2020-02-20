package com.automation.tests.day3;

import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileBrowserType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class MobileWebTestAutomation {
    //for mobile web automation, we dont use appium drivers
    //we use Webdriver or RemoteWebDriver
    //RemoteWebDriver is aclass, that implements Webdriver interface
    // it is a super class for all web drivers
    // like ChromeDriver, Firefox, etc
    private RemoteWebDriver driver;
    /*
    In this test, instead of destktop chrome brwoser, we will use mobile browser
    For Testing, we will use vytrack
     */

    @Test
    public void test1() throws Exception {
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", Platform.ANDROID);
        desiredCapabilities.setCapability("platformVersion", "7.0");
        desiredCapabilities.setCapability("deviceName", "Pixel_2");
        desiredCapabilities.setCapability("automationName", "UiAutomator2");
        desiredCapabilities.setCapability(CapabilityType.BROWSER_NAME, MobileBrowserType.CHROME);
        desiredCapabilities.setCapability("w3c", true);

        WebDriverManager.chromedriver().setup();
        desiredCapabilities.setCapability(AndroidMobileCapabilityType.CHROMEDRIVER_EXECUTABLE, WebDriverManager.chromedriver().getBinaryPath());


        driver = new RemoteWebDriver(new URL("http://localhost:4723/wd/hub"), desiredCapabilities);
        driver.get("http://zero.webappsecurity.com/login.html");
        Thread.sleep(5000);

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password", Keys.ENTER);

        WebDriverWait wait = new WebDriverWait(driver, 10);

        //wait for board presence
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".board")));

        Assert.assertTrue(driver.findElement(By.className("brand")).isDisplayed());
        Assert.assertEquals(driver.findElement(By.className("brand")).getText(),"Zero Bank");

        //click on Online Statements
        driver.findElement(By.linkText("Online Statements")).click();

        Thread.sleep(5000);
        driver.quit();

//        Comeback in 1 hour
    }
}
