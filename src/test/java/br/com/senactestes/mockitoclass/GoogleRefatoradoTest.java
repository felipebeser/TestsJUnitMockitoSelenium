package br.com.senactestes.mockitoclass;



import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleRefatoradoTest extends BaseTest{
	
	@Test
	public void pesquisaNoGoogleTest() {
		WebElement inputPesquisa = driver.findElement(By.name("q"));
		
		inputPesquisa.sendKeys("bolo de cenoura" + Keys.ENTER);
		
		String result = driver.findElement(By.id("result-stats")).getText();
		
		assertTrue(result.contains("Aproximadamente"));
	}
}
