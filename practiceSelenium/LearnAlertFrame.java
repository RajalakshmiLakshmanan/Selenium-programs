package practiceSelenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnAlertFrame {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_confirm");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.switchTo().frame("iframeResult");
		driver.findElement(By.xpath("//button[text()='Try it']")).click();
		Alert alert= driver.switchTo().alert();
		String text = alert.getText();
		
		
		System.out.println(text);
		alert.accept();
		
		WebElement element = driver.findElement(By.id("demo"));
		
		String text2 = element.getText();
		
		System.out.println(text2);
		driver.close();	 	
	}

}
