package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.WithdrawalPage;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class WithdrawalTest extends BaseTest {

    @Test
    public void withdrawalMoneyTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        WithdrawalPage withdrawal =
                new WithdrawalPage(driver);

        withdrawal.withdrawMoney(
                TestData.accountId1,
                "500");
        
        WaitUtils.waitForText(
                driver,
                "Transaction details of Withdrawal");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Transaction details of Withdrawal"));
    }
}