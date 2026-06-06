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

	    try {

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

	        System.out.println(
	                driver.findElement(By.tagName("body"))
	                      .getText());

	    } catch (Exception e) {

	        e.printStackTrace();
	        throw e;
	    }
	}
}
