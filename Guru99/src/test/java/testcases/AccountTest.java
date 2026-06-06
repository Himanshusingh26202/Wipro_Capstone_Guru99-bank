package testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.NewAccountPage;
import utilities.ConfigReader;
import utilities.TestData;

public class AccountTest extends BaseTest {

    @Test
    public void createAccountTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        NewAccountPage account =
                new NewAccountPage(driver);

        account.createAccount(
                TestData.customerId);
        driver.findElement(
                By.linkText("New Account"))
                .click();

        account.createAccount(
                TestData.customerId);
        
        Assert.assertTrue(
                driver.getPageSource()
                      .contains("Account Generated Successfully"));
    }
}