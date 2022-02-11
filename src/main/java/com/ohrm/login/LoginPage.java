package com.ohrm.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	WebDriver driver;

	@FindBy(id = "txtUsername")
	public WebElement username;

	@FindBy(id = "txtPassword")
	public WebElement password;

	@FindBy(id = "btnLogin")
	public WebElement loginbtn;

	// ****************Initialize****************//
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// *******************Login to application*******//
	public void doLogin() {
		try {
			BasePage.enterText(username, prop.getProperty("Username"), "UserName");
			BasePage.enterText(password, prop.getProperty("Password"), "Password");
			BasePage.click(loginbtn, "Login button");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
