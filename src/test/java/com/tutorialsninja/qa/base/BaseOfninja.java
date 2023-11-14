package com.tutorialsninja.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.BeforeMethod;

import com.rediff.qa.utils.Utilities;
import com.tutorialsninja.qa.utils.Utilites;



public class BaseOfninja {
	
	
	WebDriver driver;
	public Properties prop;
	public Properties dataProp;
	
	public BaseOfninja() throws IOException  {
		prop = new Properties();
		File propFile = new File(System.getProperty("user.dir")+"config.properties");
		dataProp = new Properties();
		File dataPropFile = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		FileInputStream dataFis = new FileInputStream(dataPropFile);
		dataProp.load(dataFis);
		
		try {
		FileInputStream fis = new FileInputStream(propFile );
		prop.load(fis);
		}catch(Throwable e) {
			e.printStackTrace();
		}
		
	}
	public WebDriver initializeBrowserAndopenApplicationURL(String browserName) {
		/*
		 * if(browserName.equalsIgnoreCase("chrome")) { driver =new ChromeDriver();
		 * }else if(browserName.equalsIgnoreCase("firefox")){ driver=new
		 * FirefoxDriver(); }else if(browserName.equalsIgnoreCase("edge")) { driver =
		 * new EdgeDriver();
		 * 
		 * }
		 */
		    driver =new ChromeDriver();
			driver.manage().window().maximize();
			//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.IMPLICIT_WAIT_TIME));
			//driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.PAGE_load_TIME));
			driver.get(prop.getProperty("url"));
			return driver;
	}

}
