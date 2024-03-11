package testA;

import java.time.Duration;
import java.util.List;
import java.util.Random;
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

public class Main {
	
	
	public static void main(String[] args) throws InterruptedException {									
		      Result result = JUnitCore.runClasses(JunitTest.class);					
					for (Failure failure : result.getFailures()) {							
		         System.out.println(failure.toString());					
		      }		
		      System.out.println("Result=="+result.wasSuccessful());							
    }
}
