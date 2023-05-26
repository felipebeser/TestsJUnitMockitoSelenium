package br.com.senactestes.mockitoclass;

public class Conta {
	
	private int saldo;
	
	public Conta(int saldo) {
		this.saldo = saldo;
	}
	
	public void pagarBoleto(int valorAPagar) {
		validarSaldo(valorAPagar);
		debitarSaldo(valorAPagar);
		enviarCreditoParaEmissor(valorAPagar);
	}
	
	public void validarSaldo(int valorAPagar) {
		if(valorAPagar > saldo) {
			throw new IllegalStateException("Saldo insuficiente");
		}
	}

	public void debitarSaldo(int valorAPagar) {
		this.saldo -= valorAPagar;
	}

	public void enviarCreditoParaEmissor(int valorAPagar) {
		// consome a API para enviar valor para emissor do boleto;
	}

	public int getSaldo() {
		return this.saldo;
	}
}
