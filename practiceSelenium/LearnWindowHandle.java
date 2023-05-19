package practiceSelenium;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class LearnWindowHandle {

	

	public static void main(String[] args) {
		ChromeOptions option =new ChromeOptions();
		option.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(option);
        driver.get("https://www.leafground.com/window.xhtml");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.findElement(By.xpath("//span[text()='Open']")).click();
        Set<String> windowHandles = driver.getWindowHandles();
        List<String>  handles = new ArrayList<String>(windowHandles);
        System.out.println(handles.size());
        driver.switchTo().window(handles.get(1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(handles.get(0));
        driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
        Set<String> windowHandles2 = driver.getWindowHandles();
        List<String> handles2 =new ArrayList<String>(windowHandles2);
        System.out.println(handles2.size());
        driver.switchTo().window(handles2.get(handles2.size()-1));
        System.out.println(driver.getTitle());
        driver.close();
        driver.switchTo().window(handles2.get(0)); 
        driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
         Set<String> windowHandles3 = driver.getWindowHandles();
         List<String> handles3 =new ArrayList<String>(windowHandles3);
         System.out.println(handles3.size());
         driver.switchTo().window(handles3.get(1));
         System.out.println(driver.getTitle());
         driver.quit();
	
	
	}

}
