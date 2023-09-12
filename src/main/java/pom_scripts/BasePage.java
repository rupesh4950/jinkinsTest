package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import generic.UtilityMethod;

public class BasePage extends UtilityMethod{
	public BasePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
}
