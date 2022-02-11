package com.ohrm.testcases;

import org.testng.annotations.Test;

import com.ohrm.login.BasePage;
import com.ohrm.login.LoginPage;

public class TestCase01 {
	@Test
	public void testcase01() {
		BasePage.LaunchBrowser();

		LoginPage loginp = new LoginPage(BasePage.driver);

		// ************Login to application*******************//
		try {
			loginp.doLogin();
			Thread.sleep(5000);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
