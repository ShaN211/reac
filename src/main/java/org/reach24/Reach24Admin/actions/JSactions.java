package org.reach24.Reach24Admin.actions;

import org.openqa.selenium.JavascriptExecutor;
import org.reach24.Reach24Admin.util.BasePage;

public class JSactions extends BasePage{

	public void enterTextInTextBox(String xpath, String text) {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].value="+text+";", xpath);
		//e.executeScript("document.evaluate("+xpath+", document, null, 9, null).singleNodeValue.innerHTML="+ text);
	}

}
