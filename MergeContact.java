package week4.day1assign;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class MergeContact {

	public static void main(String[] args) {
		
		ChromeOptions option=new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications");
		ChromeDriver driver=new ChromeDriver(option);
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.xpath("//a[text()='Contacts']")).click();
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		driver.findElement(By.xpath("//input[@id='partyIdFrom']/following::a")).click();
		Set<String> newwindow1 = driver.getWindowHandles();
		List<String> newwindowname = new ArrayList<String>(newwindow1);
		driver.switchTo().window(newwindowname.get(1));
		//System.out.println(driver.getTitle());
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[1]//div[contains(@class,'partyId')]//a")).click();
		driver.switchTo().window(newwindowname.get(0));
		driver.findElement(By.xpath("//input[@id='partyIdTo']/following::a[1]")).click();
		Set<String> newwindow2 = driver.getWindowHandles();
		List<String> window2name = new ArrayList<String>(newwindow2);
		driver.switchTo().window(window2name.get(1));
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("(//table[@class='x-grid3-row-table'])[2]//div[contains(@class,'partyId')]//a")).click();
		driver.switchTo().window(window2name.get(0));
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		Alert alertconfirm = driver.switchTo().alert();
		alertconfirm.accept();
		String title = driver.getTitle();
		System.out.println(title);
		
		driver.close();
		
	}

}
