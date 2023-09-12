package pom_scripts.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import pom_scripts.BasePage;

public class Footer extends BasePage {
	String temp = "";

	public Footer(WebDriver driver) {
		super(driver);
	}

	// About_link
	@FindBy(xpath = "//p[text()='About']\r\n"
			+ "")
	private WebElement About_link;

	public WebElement getAbout_link() {
		return About_link;
	}

}
