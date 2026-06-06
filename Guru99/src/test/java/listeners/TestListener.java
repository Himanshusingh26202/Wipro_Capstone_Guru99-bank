package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import utilities.ScreenshotUtil;
import base.BaseTest;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {

        System.out.println(
                "STARTED : "
                        + result.getName()); 
    }

    @Override
    public void onTestSuccess(ITestResult result) {

        System.out.println(
                "PASSED : "
                        + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println(
                "FAILED : "
                        + result.getName());

        ScreenshotUtil.captureScreenshot(
                BaseTest.driver,
                result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {

        System.out.println(
                "SKIPPED : "
                        + result.getName());
    }

    @Override
    public void onStart(ITestContext context) {

        System.out.println(
                "Execution Started");
    }

    @Override
    public void onFinish(ITestContext context) {

        System.out.println(
                "Execution Completed");
    }
}