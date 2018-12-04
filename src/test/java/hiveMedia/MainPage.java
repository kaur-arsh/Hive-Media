package hiveMedia;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.*;

public class MainPage {

	public static void main(String args[]) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "/Applications/chromedriver2");

		WebDriver driver = new ChromeDriver();
		String currentWindow = driver.getWindowHandle();
		driver.switchTo().window(currentWindow);

		// passing URL
		driver.get("http://hive-media.thehive.ai");
		driver.manage().window().fullscreen();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Performing Login
		driver.findElement(By.name("email")).sendKeys("demo@thehive.ai");
		driver.findElement(By.name("password")).sendKeys("demo");
		driver.findElement(By.className("jss69")).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Getting Timezone elements list
		WebElement selectControl = driver.findElement(By.className("TIMEZONEFormField"));
		selectControl.click();
		List<WebElement> dd_timezone = driver.findElements(By.className("Select-option"));

		// Getting Channel elements list
//		WebElement selectControl1 = driver.findElement(By.className("ChannelFormField"));
//		selectControl1.click();
//		List<WebElement> dd_channel = driver.findElements(By.className("Select-option"));

		System.out.println(dd_timezone.size());
	//	System.out.println(dd_channel.size());

		for (int i = 0; i < dd_timezone.size(); i++) {
			//for (int j = 0; j < dd_channel.size(); j++) {
				try {

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					WebElement se = driver.findElement(By.id("react-select-2--option-" + i));
					se.click();

					WebElement sctrl = driver.findElement(By.id("react-select-2--value"));
					sctrl.click();

				} catch (Exception e) {
					e.printStackTrace();
				}
			
				Thread.sleep(10000);

				WebDriverWait d = new WebDriverWait(driver, 20);
				d.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewershipChart")));

				System.out.println("Viwership Displayed");

			}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectControl.click();
		Thread.sleep(15000);

		driver.close();

	}

}
