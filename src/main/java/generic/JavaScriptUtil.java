package generic;

import org.openqa.selenium.WebElement;

public class JavaScriptUtil extends UtilityMethod{
	
	public void jsClick(WebElement element) {
		js.executeScript("arguments[0].click();", element);
	}
	public void jsSendkeys(String data,WebElement element) {
		js.executeScript("arguments[0].value='"+data+"';",element);
	}
	public void jsScrollBy(int x,int y) {
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	public void jsScrollTo(int x,int y) {
		js.executeScript("window.scrollTo("+x+","+y+")");
	}
	public void jsScrollIntoView(boolean bool, WebElement element) {
		js.executeScript("arguments[0].scrollIntoView("+bool+")",element);
	}
	public void jsScrollToBottomOfThePage() {
		js.executeScript("arguments[0].scrollBy(0,document.body.scrollHeight')");
	}
	public void jsClear(WebElement element) {
		js.executeScript("arguments[0].value='';",element);
	}

}
