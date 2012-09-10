import org.openqa.selenium.htmlunit.HtmlUnitDriver
import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver


driver = {
	new FirefoxDriver()
}

environments {
	
	firefox {
		driver = { new FirefoxDriver() }
	}
	
	chrome {
		driver = { new FirefoxDriver() }
	}
	
	htmlUnit {
		driver = { 
			def driver = new HtmlUnitDriver()
			driver.javascriptEnabled = true
			driver			
		}
	}
	
}