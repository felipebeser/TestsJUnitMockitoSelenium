package br.com.senactestes.mockitoclass;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import br.com.senactestes.mockitoclass.pageObject.GooglePO;

public class GoogleRefatorado2Test extends BaseTest{
	
	private static GooglePO googlePage;
	
	@BeforeAll
	public static void prepararTestes() {
		driver.get("http://www.google.com");
		googlePage = new GooglePO(driver);
	}
	
	@Test
	public void pesquisaNoGoogleTest() {
		
		googlePage.inputPesquisa.sendKeys("bolo de cenoura" + Keys.ENTER);
		
		Assertions.assertTrue(googlePage.result.getText().contains("Aproximadamente"));
	}
}
