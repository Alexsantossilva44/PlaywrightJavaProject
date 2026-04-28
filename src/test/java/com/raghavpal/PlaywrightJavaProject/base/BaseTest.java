package com.raghavpal.PlaywrightJavaProject.base;

import java.lang.reflect.Method;

import com.raghavpal.PlaywrightJavaProject.utils.ScreenshotUtil;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.raghavpal.PlaywrightJavaProject.utils.ExtentManager;

/**
 * Autor: Alex Silva Data: 24/04/2026
 */

public class BaseTest {

    protected Playwright playwright;
    protected Browser browser;
    protected Page page;
    protected ExtentReports extent;
    protected ExtentTest test;

    @BeforeMethod
    public void setUp(Method method) {

        extent = ExtentManager.getInstance();
        test = extent.createTest(method.getName());

        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(1000));
        page = browser.newPage();
        page.setDefaultTimeout(4000);
    }

    @AfterMethod
    public void tearDown(ITestResult result) {

        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());

            String screenshotPath = ScreenshotUtil.takeScreenshot(page, result.getName());

            System.out.println("****** Screenshot saved at: " + screenshotPath);
            String projectPath = System.getProperty("user.dir");

            String absoluteScreenshotPath = projectPath + "/" + screenshotPath;
            System.out.println("****** AbsoluteScreenshotPath: " + absoluteScreenshotPath);

            test.addScreenCaptureFromBase64String(absoluteScreenshotPath);
            test.addScreenCaptureFromBase64String(absoluteScreenshotPath, "Screenshot on Failure");

        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test passed");
        } else {
            test.skip("Test skipped");
        }

        extent.flush();

        if (browser != null) {
            browser.close();
        }
        if (playwright != null) {
            playwright.close();
        }
    }
}
