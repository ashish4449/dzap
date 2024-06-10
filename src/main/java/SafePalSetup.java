import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;

public class SafePalSetup {
	
	WebDriver driver;
	
	public SafePalSetup(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	@FindBy(xpath="//input[@name='q']")
	WebElement search;
	
	@FindBy(xpath="//button[normalize-space()='Get Started']")
	WebElement SPgetStarted;
		
	@FindBy(xpath="//span[normalize-space()='Import Wallet']")
	WebElement SPimportWallet;
	
	@FindBy(id="password")
	WebElement SPsetpass;
	
	@FindBy(id="confirmPassword")
	WebElement SPconfirmSetpass;
	
	@FindBy(xpath="//span[normalize-space()='Next']")
	WebElement SPnext;
	
	@FindBy(xpath="//a[normalize-space()='Private Key']")
	WebElement SPpvtKey;
	
	@FindBy(id="key")
	WebElement SPenterPvtKey;
	
	
	@FindBy(xpath="//*[@class='cur bg m0 sfpItemBox flex-space-between  Border']")
	WebElement SPnetwork;
	
	
	@FindBy(xpath="//div[text()='Arbitrum']")
	WebElement SPselNetwork;
	
	@FindBy(id="alianName")
	WebElement SPwalletName;
	
	@FindBy(xpath="//span[normalize-space()='Confirm']")
	WebElement SPwalletConfirm;
	
	@FindBy(xpath="//*[@class=\"ant-modal-close-x\"]")
	WebElement SPcloseAlert;
	

	
	@BeforeTest
	public void safePal() throws InterruptedException {
		driver.get("chrome-extension://lgmpcpglpngdoalbgeoldeajfclnhafa/index.html#/unlock");		
		SPgetStarted.click();
		SPimportWallet.click();
		SPsetpass.sendKeys("crypto@1996");
		SPconfirmSetpass.sendKeys("crypto@1996");
		SPnext.click();
		SPpvtKey.click();
		SPenterPvtKey.sendKeys("Enter your Private key here");
		SPnetwork.click();
		Thread.sleep(3000);
		SPselNetwork.click();
		SPnext.click();
		SPwalletName.sendKeys("TestWallet");
		SPwalletConfirm.click();
		SPcloseAlert.click();
		Thread.sleep(3000);
		driver.navigate().to("https://app.dzap.io/swap");				
	}
}

