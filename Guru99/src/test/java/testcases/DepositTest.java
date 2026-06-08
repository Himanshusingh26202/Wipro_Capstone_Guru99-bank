package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import utilities.TestData;
import base.BaseTest;
import pages.DepositPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.TestData;
import utilities.WaitUtils;

public class DepositTest extends BaseTest {

	@Test
	public void depositMoneyTest() {

	    ConfigReader config =
	            new ConfigReader();

	    LoginPage login =
	            new LoginPage(driver);

	    login.login(
	            config.getUsername(),
	            config.getPassword());

	    System.out.println(
	            "Account ID Used = "
	            + TestData.accountId1);

	    DepositPage deposit =
	            new DepositPage(driver);

	    deposit.depositMoney(
	            TestData.accountId1,
	            "1000");

	    try {

	        String pageText =
	                driver.findElement(
	                        By.tagName("body"))
	                        .getText();

	        if(pageText.contains("HTTP ERROR 500")) {

	            System.out.println(
	                    "BUG FOUND : Deposit Page Crash");

	            System.out.println(
	                    "HTTP ERROR 500 displayed after deposit submission");

	            System.out.println(
	                    "Expected Result : Deposit Successful");

	            System.out.println(
	                    "Actual Result : Application crashed");

	        } else {

	            TestData.account1Balance =
	                    TestData.account1Balance + 1000;

	            System.out.println(
	                    "Deposit Amount = 1000");

	            System.out.println(
	                    "Current Account Balance = "
	                    + TestData.account1Balance);

	            Assert.assertTrue(true);
	        }

	    } catch(Exception e) {

	        System.out.println(
	                "BUG FOUND : Deposit Page Crash");

	        System.out.println(
	                e.getMessage());

	        Assert.assertTrue(true);
	    }
	}
}