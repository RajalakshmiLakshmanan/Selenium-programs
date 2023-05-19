package practiceSelenium;
//1.Load the URL https://www.amazon.in/
//2.search as oneplus 9 pro 
//3.Get the price of the first product
//4. Print the number of customer ratings for the first displayed product
//5. Click the first text link of the first image
//6. Take a screen shot of the product displayed
//7. Click 'Add to Cart' button
//8. Get the cart subtotal and verify if it is correct.
//9.close the browser

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class amazon {

	public static void main(String[] args) throws IOException, InterruptedException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver= new ChromeDriver(option);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
		String text = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println("price:"+text);
		String text2 = driver.findElement(By.xpath("(//span[@class='a-size-base s-underline-text'])[1]")).getText();
		System.out.println("no of customer rating:"+text2);
		driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();
		Set<String> handles = driver.getWindowHandles();
		List<String> whandle= new ArrayList<String>(handles);
		driver.switchTo().window(whandle.get(1));
		System.out.println("title:"+driver.getTitle());
		
		File screenshotAs = driver.getScreenshotAs(OutputType.FILE);
		File destn= new File("./snap/mobile.png");
		FileUtils.copyFile(screenshotAs, destn);
		
		driver.findElement(By.id("add-to-cart-button")).click();
		Thread.sleep(1000);
		String text3 = driver.findElement(By.id("attach-accessory-cart-subtotal")).getText();
		System.out.println("cart total:"+text3);
		if(text.contains(text3)) {
			System.out.println("Its verified that item is added in cart");
			
		}else {
			System.out.println("item is not added");
		}
		driver.quit();
		
	}

}
