import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DzapWalletConnect {
	
	WebDriver driver;
	
	public DzapWalletConnect(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//button[@data-testid='rk-connect-button']")
	WebElement ConnectWallet;
	
	@FindBy(xpath="//button[@data-testid='rk-wallet-option-https://www.safepal.com/download']")
	WebElement SelectSafepal;
	
	@FindBy(xpath="//span[normalize-space()='Connect']")
	static
	WebElement FinalConfirm;
	
	
	public void SafepalSelect() throws InterruptedException {
		ConnectWallet.click();
		Thread.sleep(3000);
		SelectSafepal.click();
		
	}
	
   public static  void switchToNewTab(WebDriver driver) throws InterruptedException {
	    Thread.sleep(5000);
		String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
		Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
		for (String handle : windowHandles) {
		    if (!handle.equals(mainWindowHandle)) {
		        driver.switchTo().window(handle); // Switch to the pop-up window
		        break;
		    }
		}
		FinalConfirm.click();
	}

}

