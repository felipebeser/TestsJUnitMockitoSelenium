package br.com.senactestes.mockitoclass;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InOrder;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith (MockitoExtension.class)
public class ContaTeste {

	@Spy
	private Conta conta = new Conta(1000);
	
	@Test
	void verificarComportamentoDaClasse() {
		Mockito.verifyNoInteractions(conta);
		
		conta.pagarBoleto(39);
		
		InOrder inOrder = Mockito.inOrder(conta);
		inOrder.verify(conta).pagarBoleto(39);
		inOrder.verify(conta).validarSaldo(39);
		inOrder.verify(conta).debitarSaldo(39);
		inOrder.verify(conta).enviarCreditoParaEmissor(39);
	}
	
	@Test
	void validarQuantidadeDeChamadas() { 
		conta.validarSaldo(300);
		conta.debitarSaldo(100);
		conta.validarSaldo(200);
		conta.debitarSaldo(50);
		conta.validarSaldo(150);
		
		Mockito.verify(conta, Mockito.times(3)).validarSaldo(ArgumentMatchers.anyInt());
		Mockito.verify(conta, Mockito.times(2)).debitarSaldo(ArgumentMatchers.anyInt());
	}
	
}
