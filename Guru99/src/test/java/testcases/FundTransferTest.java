package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.FundTransferPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class FundTransferTest
        extends BaseTest {

    @Test
    public void fundTransferTest() {

        ConfigReader config =
                new ConfigReader();

        LoginPage login =
                new LoginPage(driver);

        login.login(
                config.getUsername(),
                config.getPassword());

        System.out.println(
                "From Account = "
                + TestData.accountId1);

        System.out.println(
                "To Account = "
                + TestData.accountId2);

        
        FundTransferPage transfer =
                new FundTransferPage(driver);

        transfer.transferFunds(
                TestData.accountId1,
                TestData.accountId2,
                "200");
        
        WaitUtils.waitForText(
                driver,
                "Fund Transfer Details");

        Assert.assertTrue(
                driver.getPageSource()
                      .contains(
                              "Fund Transfer Details"));
        
    }
}
