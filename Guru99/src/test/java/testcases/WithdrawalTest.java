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
        
        TestData.account1Balance =
                TestData.account1Balance - 500;

        System.out.println(
                "Withdrawal Amount = 500");

        System.out.println(
                "Current Account Balance = "
                        + TestData.account1Balance);
        
        WaitUtils.waitForText(
                driver,
                "Transaction details of Withdrawal");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Transaction details of Withdrawal"));
    }
}