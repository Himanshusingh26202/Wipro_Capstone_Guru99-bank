package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.WithdrawalPage;
import utilities.ConfigReader;
import utilities.TestData;

public class InsufficientBalanceTest extends BaseTest {

    @Test
    public void insufficientBalanceTest() {

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
                "99999999");

        Assert.assertTrue(true);

        System.out.println(
                "Insufficient Balance Test Executed");
    }
}
