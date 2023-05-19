package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class LearnSelectMultipleoption {

	public static void main(String[] args) throws InterruptedException {
	  ChromeOptions option = new ChromeOptions();
	  option.addArguments("--remote-allow-origins=*");
	  ChromeDriver driver = new ChromeDriver(option);
	  driver.get("https://www.leafground.com/select.xhtml");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
	  WebElement element = driver.findElement(By.className("ui-selectonemenu"));
	  
	  Select dd = new Select(element);
	  List<WebElement> options = dd.getOptions();
	  for (int i = 0; i < options.size(); i++) {
		  
		  
		  options.get(i).click();
		
	}
	  driver.findElement(By.xpath("//label[text()='Select Country']")).click();
	  driver.findElement(By.xpath("//li[text()='Germany']")).click();
	  
	  Thread.sleep(1000);
	  driver.findElement(By.xpath("//label[text()='Select City']")).click();
	  driver.findElement(By.xpath("//li[text()='Frankfurt']")).click();	
	  
	  Thread.sleep(2000);
	  WebElement element2 = driver.findElement(By.xpath("//input[@placeholder='Choose Course']"));
	  Select dd1 = new Select(element2);
	  dd1.selectByVisibleText("Selenium WebDriver");
	  
	  //driver.findElement(By.xpath("//li[text()='ReactJs']")).click();
	  //driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click()
	  //Thread.sleep(2000);
	 // driver.findElement(By.xpath("//li[text()='Selenium WebDriver']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//label[text()='Select Language']")).click();
	  driver.findElement(By.xpath("//li[text()='English']")).click();
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//label[text()='Select Values']")).click();
	  driver.findElement(By.xpath("//li[text()='Three']")).click();
	  
	}

}
