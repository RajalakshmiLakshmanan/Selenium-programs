package officeWork;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//1. Launch https://www.snapdeal.com/
//2. Go to Mens Fashion
//3. Go to Sports Shoes
//4. Get the count of the sports shoes
//5. Click Training shoes
//6. Sort by Low to High
//7. Check if the items displayed are sorted correctly
//8.Select the price range (900-1200)
//9.Filter with color Navy 
//10 verify the all applied filters 
//11. Mouse Hover on first resulting Training shoes
//12. click QuickView button
//13. Print the cost and the discount percentage
//14. Take the snapshot of the shoes.
//15. Close the current window
//16. Close the main window



public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		option.addArguments("--disable-notifications-");
		ChromeDriver driver =new ChromeDriver(option);
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
		driver.findElement(By.xpath("//span[@class='catText']")).click();
		driver.findElement(By.xpath("//span[text()='Sports Shoes']")).click();
        
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println("Count of sports shoes:"+text);
		
		driver.findElement(By.xpath("//div[text()='Basketball Shoes']")).click();
		driver.findElement(By.xpath("//span[text()='Sort by:']")).click();
		
		WebElement ltoh = driver.findElement(By.xpath("//li[@data-sorttype='plth']"));
		ltoh.click();
		//WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		//wait.until(ExpectedConditions.visibilityOf(ltoh));
		Thread.sleep(1000);
		
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		int size = list.size();
		
		for(WebElement price:list) {
			String text2 = price.getText();
			System.out.println(text2);
			
		}
		
		WebElement drag = driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-corner-all')]"));
		Actions action = new Actions(driver);
		action.dragAndDropBy(drag, 0, 200).perform();
		Thread.sleep(1000);

        WebElement drop = driver.findElement(By.xpath("(//a[contains(@class,'ui-state-default ui-corner-all')])[2]"));
        Actions move = new Actions(driver);
        move.dragAndDropBy(drop,-100, 0).perform();
        
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.xpath("//label[@for='Color_s-Blue']"));
//        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
//		wait.until(ExpectedConditions.elementToBeSelected(element));
		element.click();
		
        Thread.sleep(1000);
        List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='navFiltersPill']"));
        for(WebElement filter:list2) {
        	String text2 = filter.getText();
        	System.out.println(text2);
        	
        }
        WebElement item = driver.findElement(By.xpath("//img[@title='Vector X COSMIC Blue Basketball Shoes']"));
        WebElement quickview = driver.findElement(By.xpath("//div[contains(text(),'Quick View')]"));
        Actions action2= new Actions(driver);
        action2.moveToElement(item).click(quickview).perform();
        
        Thread.sleep(1000);
        File file = driver.getScreenshotAs(OutputType.FILE);
        File dest = new File("./snap/shoeimg.png");
         FileUtils.copyFile(file, dest);      
        
        WebElement findElement = driver.findElement(By.xpath("//span[@class='payBlkBig']"));
        String text2 = findElement.getText();
        System.out.println("cost of item:"+text2);
        
        WebElement findElement2 = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
        String text3 = findElement2.getText();
        System.out.println("discount:"+text3);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-delete-sign']")).click();
        driver.close();
       
	}

}
