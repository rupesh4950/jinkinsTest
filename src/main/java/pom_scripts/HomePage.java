package pom_scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends BasePage{

	public HomePage(WebDriver driver) {
		super(driver);
		
	}
	String s="";
	@FindBy(xpath="//strong[text()='Featured products']")	private WebElement featured;
	@FindBy(xpath="//a[text()='Log in']") private WebElement login;
	

	@FindAll({@FindBy(how=How.XPATH, using="username"),
		@FindBy(className="username-field"),@FindBy(xpath = "")})
	private WebElement user_name;
	
	
	
	public WebElement getFeatured() {
		return featured;
	}
	public WebElement getLogin() {
		return login;
	}
	public void setLogin(WebElement login) {
		this.login = login;
	}
	

}
