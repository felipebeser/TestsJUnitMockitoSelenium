package br.com.senactestes.mockitoclass;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
	
	protected static WebDriver driver;
	private static final String URL_BASE = "https://www.google.com";
	private static final String PATH_DRIVE = "src/test/resources/chromedriver";

	@BeforeAll
	public static void iniciar() {
		System.out.println("iniciou");
		System.setProperty("webdriver.chrome.driver", PATH_DRIVE);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL_BASE);
	}
	
	@AfterAll
	public static void finalizar() {
		driver.quit();
	}
	
}
