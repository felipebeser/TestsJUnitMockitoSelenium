package br.com.senactestes.mockitoclass.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * Classe base para a criaçao das novas PageObjects
 * Todas as pages herdam esta classe
 *
 */

public class BasePO {

	protected static WebDriver driver;
	
	/**
	 * Construtor base para a criaçao da fábrica de elementos (PageFactory)
	 * @param driver (Driver do navegador atual)
	 */
	
	public BasePO (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
}
