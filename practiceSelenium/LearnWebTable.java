package practiceSelenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWebTable {

	public static void main(String[] args) {
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
		ChromeDriver driver = new ChromeDriver(option);
		driver.get("https://html.com/tags/table/");
		driver.manage().window().maximize()	;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> elements2 = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr"));
		int rowsize = elements2.size();
		System.out.println(rowsize);
		List<WebElement> elements = driver.findElements(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td"));
		int colsize = elements.size();
		System.out.println(elements.size());
		WebElement element = driver.findElement(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td[1]/a"));
		System.out.println(element.getText());
		// to retrieve the Ist column data
		for (int i = 2; i <=rowsize; i++) {
			String text = driver.findElement(By.xpath("//table[@class='attributes-list']/tbody/tr["+i+"]/td/a")).getText();
			System.out.println(text);
		}
		 System.out.println("to retrive the Ist row data---------------");
//		for(int i=1; i<= colsize;i++){
//			
//			String text = driver.findElement(By.xpath("//table[@class='attributes-list']/tbody/tr[2]/td["+i+"]/a")).getText();
//			System.out.println(text);
//		}
		
		System.out.println("to retrive all the row data and column data--------------");
//		for(int i=2;i<=rowsize;i++) {
//			for(int j=1;j<=colsize;j++) {
//				String text = driver.findElement(By.xpath("//table[@class='attributes-list']/tbody/tr["+i+"]/td["+j+"]/a")).getText();
//				System.out.println(text);
//				
//				
//			}
//		}
		driver.close();
		
	}

}
