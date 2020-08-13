package CodingExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.*;
import java.util.List;
import org.junit.*;


public class WWInternationSearch {
	
	WebDriver driver;
	
	public void LaunchBrowser() {	
		
		System.setProperty("webdriver.gecko.driver","drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.weightwatchers.com/us/");
		
	}
	
	public void VerifyAppTitle() throws InterruptedException {
		
		//Actual title
		String my_title = driver.getTitle();
		String expected_title = "WW (Weight Watchers): Weight Loss & Wellness Help | WW USA";
		
		Assert.assertEquals(my_title,expected_title);
		System.out.println("Page Title Matched");
		
		driver.findElement(By.linkText("Find a Workshop")).click();
		
		Thread.sleep(5000);
		
	    Assert.assertTrue(driver.getTitle().contains("Find WW Studios & Meetings Near You | WW USA"));
	    System.out.println("Title Contains :: Pass");
	    
	}
	
	public void Search() throws InterruptedException {
	
		driver.findElement(By.id("location-search")).sendKeys("10011");
		driver.findElement(By.id("location-search-cta")).click();
		
		
		Thread.sleep(5000);
		
		List<WebElement> rows = driver.findElements(By.xpath("//div[@class='heading-3yCF-']/div[@class='linkContainer-1NkqM']/a[@class='linkUnderline-1_h4g']"));
		
		List<WebElement> distancerows = driver.findElements(By.xpath("//div[@class='heading-3yCF-']/span[@class='distance-OhP63']"));
		
		
		if (rows.size()>=1 && distancerows.size()>=1) {
			
			String titlelabel = rows.get(0).getText();
			String distlabel = distancerows.get(0).getText();
			System.out.println("Title of the First Line is  :: " + titlelabel);
			System.out.println("Distance of the First Line is :: " + distlabel);
			rows.get(0).click();
			Thread.sleep(5000);
			
			String LocName = driver.findElement(By.xpath("//div[@class='infoContainer-12kv1']/h1[@class='locationName-1jro_']")).getText();
		    if(LocName.equals(titlelabel)) {
		    	System.out.println("Displayed location name/title matches with the name of the first searched result that was clicked.");
		    }
		}
		
		String comppersonname ="";
		int meetingCount = 1;
	    int j = 1;
	    
		List<WebElement> weekdays = driver.findElements(By.xpath("//div[@class='scheduleContainerMobile-1RfmF']/div[@class='day-NhBOb']/span[@class='dayName-1UpF5']"));
		
		for(int i=0;i<=weekdays.size();i++) {
			System.out.println("     ");
			System.out.println(weekdays.get(i).getText());
			System.out.println("------");
			
			
			List<WebElement> pname = driver.findElements(By.xpath("//div[@class='scheduleContainerMobile-1RfmF']/div[@class='day-NhBOb']["+j+"]/div[@class='meeting-14qIm']/span[2]"));
		   
		    for (WebElement objPersonname : pname) {
		    	String personname = objPersonname.getText();
		    	
		    	if (comppersonname.equals(personname)) {
		    		meetingCount = meetingCount + 1;
		    	}else {
		    		System.out.println(personname + " - " );
		    		meetingCount = 1;
		    	}
		    	
		    	   System.out.println(meetingCount);
		    	   comppersonname = personname;
		    }
			j = j+1;
			
		}
	}
		
	
	public static void main(String[] args) throws InterruptedException {
		
		WWInternationSearch obj = new WWInternationSearch();
		obj.LaunchBrowser();
		obj.VerifyAppTitle();
		obj.Search();
	}

}
