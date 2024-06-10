import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.io.File;
import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class Base {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions op = new ChromeOptions();
		op.addExtensions(new File("ex/Safepal.crx"));
		WebDriver driver = new ChromeDriver(op);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));		
		SafePalSetup SPS = new SafePalSetup(driver);
		SPS.safePal();
		DzapWalletConnect DWC= new DzapWalletConnect(driver);
		DWC.SafepalSelect();
		DzapWalletConnect.switchToNewTab(driver);
		
	}
	
	

	
	

}
