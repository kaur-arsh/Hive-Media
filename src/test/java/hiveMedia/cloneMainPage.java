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

public class cloneMainPage {

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

		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		// Getting Timezone elements list
		WebElement selectControl = driver.findElement(By.className("TIMEZONEFormField"));
		selectControl.click();
		List<WebElement> dd_timezone = driver.findElements(By.className("Select-option"));

		// Getting Channel elements list

		System.out.println(dd_timezone.size());

		for (int i = 0; i < dd_timezone.size(); i++) {

			try {

				WebElement se = driver.findElement(By.id("react-select-2--option-" + i));
				se.click();

				// Open the Channel Drop-down
				WebElement selectControl1 = driver.findElement(By.className("ChannelFormField"));
				selectControl1.click();
				List<WebElement> dd_channel = driver.findElements(By.className("Select-option"));
				System.out.println(dd_channel.size());

				WebDriverWait wait = new WebDriverWait(driver, 40);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewershipChart")));
				for (int j = 0; j < dd_channel.size(); j++) {
					try {

						WebElement sc = driver.findElement(By.id("react-select-3--option-" + j));
						sc.click();

						// Close the Channel Drop-down
						selectControl1.click();
						WebElement sctrl1 = driver.findElement(By.className("ChannelFormField"));// driver.findElement(By.id("react-select-3--value"));
						sctrl1.click();

					} catch (Exception e) {
						e.printStackTrace();
					}
					Thread.sleep(20000);
				}

				WebElement sctrl = driver.findElement(By.className("TIMEZONEFormField"));// driver.findElement(By.id("react-select-2--value"));
				sctrl.click();

			} catch (Exception e) {
				e.printStackTrace();
			}

			Thread.sleep(20000);

			WebDriverWait d = new WebDriverWait(driver, 20);
			d.until(ExpectedConditions.visibilityOfElementLocated(By.id("viewershipChart")));

			System.out.println("Viewership Displayed");

		}
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		selectControl.click();

		Thread.sleep(15000);

		driver.close();

	}

}
