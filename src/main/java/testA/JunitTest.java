package testA;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.junit.After;		
import org.junit.AfterClass;		
import org.junit.Before;		
import org.junit.BeforeClass;		
import org.junit.Ignore;		
import org.junit.Test;
import org.junit.runner.JUnitCore;		
import org.junit.runner.Result;		
import org.junit.runner.notification.Failure;	

public class JunitTest {
	 // Generate random integers in range 0 to 9999
	static Random rand = new Random();
	public static int rand_int=rand.nextInt(10000);
	
	
	
	@BeforeClass		
    public static void register() {							
        System.out.println("Using @BeforeClass , executed before all test cases ");		
        EdgeDriver driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dvynu\\Downloads\\edgedriver_win64\\msedgedriver.exe");  
        driver.get("https://demowebshop.tricentis.com/"); 
        driver.manage().window().maximize();
        WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(90));
        
        WebElement log = driver.findElement(By.xpath("//a[@class=\"ico-login\"]"));
        log.click();
        WebElement reg = driver.findElement(By.xpath("//input[@class=\"button-1 register-button\"]"));
        reg.click();
        WebElement name = driver.findElement(By.xpath("//input[@id=\"FirstName\"]"));
        name.sendKeys("Name1");
        WebElement lastName = driver.findElement(By.xpath("//input[@id=\"LastName\"]"));
        lastName.sendKeys("Name2");
        WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
        
        
        
        email.sendKeys("john"+rand_int+"@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
        pass.sendKeys("joe123");
        WebElement pass2 = driver.findElement(By.xpath("//input[@id=\"ConfirmPassword\"]"));
        pass2.sendKeys("joe123");
        WebElement conf = driver.findElement(By.xpath("//input[@id=\"register-button\"]"));
        conf.click();
        
        driver.quit();
    }	
	
	@Test		
    public void test1() {					
		EdgeDriver driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dvynu\\Downloads\\edgedriver_win64\\msedgedriver.exe");  
        driver.get("https://demowebshop.tricentis.com/"); 
        driver.manage().window().maximize();
        WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(90));

        
        WebElement log = driver.findElement(By.xpath("//a[@class=\"ico-login\"]"));
        log.click();
        
        WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
        email.sendKeys("john"+rand_int+"@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
        pass.sendKeys("joe123");
        WebElement login = driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
        login.click();
        WebElement digit = driver.findElement(By.xpath("//a[@href=\"/digital-downloads\"]"));
        digit.click();
        
        ClassLoader classLoader = JunitTest.class.getClassLoader();
        URL resourceURL = classLoader.getResource("test1.txt");
        
        try {
            File myObj = new File(resourceURL.getFile());
            Scanner myReader = new Scanner(myObj);
            
            int i=0;
            
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"cart-qty\" and text()=\"("+i+")\"]")));
              WebElement digitDow = driver.findElement(By.xpath("//div[@data-productid="+data+"]//input"));
              digitDow.click();
              i++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        WebElement cart = driver.findElement(By.xpath("//span[@class=\"cart-label\"]"));
        cart.click();
        WebElement term = driver.findElement(By.xpath("//input[@id=\"termsofservice\"]"));
        term.click();
        WebElement check = driver.findElement(By.xpath("//button[@id=\"checkout\"]"));
        check.click();
        
        WebElement country = driver.findElement(By.xpath("//option[@value=\"1\"]"));
        country.click();
        WebElement bill = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_City\"]"));
        bill.sendKeys("city");
        WebElement bill2 = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_Address1\"]"));
        bill2.sendKeys("address1");
        WebElement bill3 = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_ZipPostalCode\"]"));
        bill3.sendKeys("123");
        WebElement bill4 = driver.findElement(By.xpath("//input[@id=\"BillingNewAddress_PhoneNumber\"]"));
        bill4.sendKeys("123456789");
        WebElement cont1 = driver.findElement(By.xpath("//input[@wfd-id=\"id14\"]"));
        cont1.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wfd-id=\"id15\"]")));
        WebElement cont2 = driver.findElement(By.xpath("//input[@wfd-id=\"id15\"]"));
        cont2.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wfd-id=\"id16\"]")));
        WebElement cont3 = driver.findElement(By.xpath("//input[@wfd-id=\"id16\"]"));
        cont3.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@wfd-id=\"id17\"]")));
        WebElement cont4 = driver.findElement(By.xpath("//input[@wfd-id=\"id17\"]"));
        cont4.click();
        
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"title\"]/strong")));
        WebElement end = driver.findElement(By.xpath("//div[@class=\"title\"]/strong"));
        assertEquals("Your order has been successfully processed!", end.getText());
        driver.quit();
    }	 
	
	@Test		
    public void test2() {					
		EdgeDriver driver = new EdgeDriver();
		System.setProperty("webdriver.edge.driver", "C:\\Users\\dvynu\\Downloads\\edgedriver_win64\\msedgedriver.exe");  
        driver.get("https://demowebshop.tricentis.com/"); 
        driver.manage().window().maximize();
        WebDriverWait explicitWait=new WebDriverWait(driver, Duration.ofSeconds(90));

        
        WebElement log = driver.findElement(By.xpath("//a[@class=\"ico-login\"]"));
        log.click();
        
        WebElement email = driver.findElement(By.xpath("//input[@id=\"Email\"]"));
        email.sendKeys("john"+rand_int+"@gmail.com");
        WebElement pass = driver.findElement(By.xpath("//input[@id=\"Password\"]"));
        pass.sendKeys("joe123");
        WebElement login = driver.findElement(By.xpath("//input[@class=\"button-1 login-button\"]"));
        login.click();
        WebElement digit = driver.findElement(By.xpath("//a[@href=\"/digital-downloads\"]"));
        digit.click();
        
        ClassLoader classLoader = JunitTest.class.getClassLoader();
        URL resourceURL = classLoader.getResource("test2.txt");
        
        try {
            File myObj = new File(resourceURL.getFile());
            Scanner myReader = new Scanner(myObj);
            
            int i=0;
            
            while (myReader.hasNextLine()) {
              String data = myReader.nextLine();
              explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"cart-qty\" and text()=\"("+i+")\"]")));
              WebElement digitDow = driver.findElement(By.xpath("//div[@data-productid="+data+"]//input"));
              digitDow.click();
              i++;
            }
            myReader.close();
          } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
          }
        WebElement cart = driver.findElement(By.xpath("//span[@class=\"cart-label\"]"));
        cart.click();
        WebElement term = driver.findElement(By.xpath("//input[@id=\"termsofservice\"]"));
        term.click();
        WebElement check = driver.findElement(By.xpath("//button[@id=\"checkout\"]"));
        check.click();
        
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"button-1 new-address-next-step-button\"]")));
        WebElement cont1 = driver.findElement(By.xpath("//input[@class=\"button-1 new-address-next-step-button\"]"));
        cont1.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"payment-method-buttons-container\"]/input")));
        WebElement cont2 = driver.findElement(By.xpath("//div[@id=\"payment-method-buttons-container\"]/input"));
        cont2.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"payment-info-buttons-container\"]/input")));
        WebElement cont3 = driver.findElement(By.xpath("//div[@id=\"payment-info-buttons-container\"]/input"));
        cont3.click();
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id=\"confirm-order-buttons-container\"]")));
        WebElement cont4 = driver.findElement(By.xpath("//div[@id=\"confirm-order-buttons-container\"]/input"));
        cont4.click();
        
        explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"title\"]/strong")));
        WebElement end = driver.findElement(By.xpath("//div[@class=\"title\"]/strong"));
        assertEquals("Your order has been successfully processed!", end.getText());
        driver.quit();
    }
	
        /*
        WebElement manageConsent = driver.findElement(By.xpath("//button[@class=\"fc-button fc-cta-manage-options fc-secondary-button\"]"));
        manageConsent.click();
        
        List<WebElement> unCheck = driver.findElements(By.xpath("//div[div[@class=\"fc-header fc-dialog-restricted-content\"]/h1[text()=\"Manage your data\"]]//span[input[@checked]]/span"));
		for (WebElement a : unCheck) {
            a.click();
        }
        
		WebElement vendor = driver.findElement(By.xpath("//button[@class=\"fc-navigation-button fc-manage-vendors\"]"));
		vendor.click();
		
		List<WebElement> unCheck2 = driver.findElements(By.xpath("//div[div[@class=\"fc-header fc-dialog-restricted-content\"]/h1[text()=\"Confirm our vendors\"]]//span[input[@checked]]/span"));
		for (WebElement a : unCheck2) {
            a.click();
        } 
        
		WebElement confirm = driver.findElement(By.xpath("//div[@aria-label=\"Confirm our vendors, Vendors can use your data to provide services. Declining a vendor can stop them from using the data you shared.. Accept all, Confirm choices \"]//button[@class=\"fc-button fc-confirm-choices fc-primary-button\"]"));
		confirm.click();
		
		WebElement widget = driver.findElement(By.xpath("//div[.//h5[text()=\"Elements\"] and @class=\"card mt-4 top-card\"]"));
		widget.click();
		
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[span[text()=\"Web Tables\"]]")));
		
		//JavascriptExecutor js = (JavascriptExecutor) driver;
	    //js.executeScript("window.scrollBy(0,400)", "");
		
		WebElement prog = driver.findElement(By.xpath("//li[span[text()=\"Web Tables\"]]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", prog);
		prog.click();
		
	
		
		

		
		//Pakeist i FluentWait
		 Wait wait = new FluentWait(driver)
	                .withTimeout(Duration.ofSeconds(60))
	                .pollingEvery(Duration.ofSeconds(0,1))
	                .ignoring(org.openqa.selenium.NoSuchElementException.class);

	        // Use Fluent Wait in a conditional loop
		 
		 WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
	            public WebElement apply(WebDriver driver) {
	                // Find the element on the web page
	            	WebElement start = driver.findElement(By.xpath("//button[@id=\"addNewRecordButton\"]"));
	        		start.click();
	            	WebElement name = driver.findElement(By.xpath("//input[@id=\"firstName\"]"));
					WebElement name2 = driver.findElement(By.xpath("//input[@id=\"lastName\"]"));
					WebElement email = driver.findElement(By.xpath("//input[@id=\"userEmail\"]"));
					WebElement age = driver.findElement(By.xpath("//input[@id=\"age\"]"));
					WebElement salary = driver.findElement(By.xpath("//input[@id=\"salary\"]"));
					WebElement dep = driver.findElement(By.xpath("//input[@id=\"department\"]"));
					WebElement sub = driver.findElement(By.xpath("//button[@id=\"submit\"]"));
					name.sendKeys("Name1");
					name2.sendKeys("Name2");
					email.sendKeys("name@example.com");
					age.sendKeys("1");
					salary.sendKeys("1");
					dep.sendKeys("department");
					sub.click();

					
					WebElement value = driver.findElement(By.xpath("//span[@class=\"-totalPages\"]"));
	                // Check the condition, for example, whether the element is visible
	                if ("2".equals(value.getText())) {
	                    // If condition is met, return the element
	                    return name;
	                } else {
	                    // If condition is not met, return null (Fluent Wait will continue polling)
	                    return null;
	                }
	            }
	        });

	
	
			
			
		
		//js.executeScript("window.scrollBy(0,4000)", "");
		
		WebElement next = driver.findElement(By.xpath("//button[text()=\"Next\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", next);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[text()=\"Next\"]")));
		next.click();
		
		
		
		WebElement del = driver.findElement(By.xpath("//span[@id=\"delete-record-11\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", del);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id=\"delete-record-11\"]")));
		del.click();

		WebElement value = driver.findElement(By.xpath("//span[@class=\"-totalPages\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", value);
		if("1".equals(value.getText())) {
			System.out.println("value is 1'");
		}
		else {
			System.out.println("value is NOT 1 it is:"+value.getText());
		}
		
		*/
		
    
}
