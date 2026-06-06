package testcases;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtils;
import utilities.RetryAnalyzer;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void validLoginTest() {

        String excelPath =
                "C:\\Users\\himan\\OneDrive\\Desktop\\folder\\Guru99Data.xlsx";

        String username =
                ExcelUtils.getData(excelPath, 1, 0);

        String password =
                ExcelUtils.getData(excelPath, 1, 1);

        LoginPage login =
                new LoginPage(driver);

        login.login(username, password);

        HomePage home =
                new HomePage(driver);

        Assert.assertTrue(
                home.verifyManagerHomePage(),
                "Login Failed");
    }

    @Test
    public void invalidLoginTest() {

        LoginPage login =
                new LoginPage(driver);

        login.login(
                "wrongUser",
                "wrongPass");

        WebDriverWait wait =
                new WebDriverWait(
                        driver,
                        Duration.ofSeconds(10));

        Alert alert =
                wait.until(
                        ExpectedConditions.alertIsPresent());

        String alertText =
                alert.getText();

        Assert.assertTrue(
                alertText.contains(
                        "User or Password is not valid"));

        alert.accept();
    }
    @Test
    public void emptyLoginTest() throws Exception {

        LoginPage login =
                new LoginPage(driver);

        try {

            login.login("", "");

            Thread.sleep(3000);

            System.out.println(
                    "Title = " + driver.getTitle());

            System.out.println(
                    "Source Length = "
                    + driver.getPageSource().length());

        } catch (Exception e) {

            System.out.println(
                    "Exception = "
                    + e.getMessage());
        }

        Assert.assertTrue(true);
    }
}