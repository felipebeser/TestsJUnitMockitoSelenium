package br.com.senactestes.mockitoclass;

import static org.mockito.ArgumentMatchers.anyString;
import java.time.LocalDate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTest {
	//1 Criacao de cenário
	//1.1 Instrumentacao para o mock
	//1.1.1 Insercao do descritor do mock
	@Mock
	private ApiDosCorreios apiDosCorreios;
	//1.1.2 Injecao de dependencia da regra de negocio a ser testada
	@InjectMocks
	private CadastrarPessoa cadastrarPessoa;
	
	@Test
	void testCadastrarPessoa() {
		//1.2 Insercao dos dados a serem mockados
		//Dados ficticios do objeto que eu estou mocando
		DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("RJ", "Rio de Janeiro", "Rua Arnaldo", "Casa", "Botafogo");
		
		//1.3 Execucao do mock
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenReturn(dadosLocalizacao);
		
		Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Felipe", "doc", LocalDate.of(2000,1,25) ,"123");
		
		//2. Execucao e analise do teste
		Assertions.assertEquals(pessoa.getEndereco(), dadosLocalizacao);
		
		Assertions.assertEquals(pessoa.getNome(), "Felipe");
		
		Assertions.assertEquals(pessoa.getDocumento(), "doc");
		
		Assertions.assertEquals(pessoa.getNascimento().getYear(), 2000);
		Assertions.assertEquals(pessoa.getNascimento().getMonthValue(), 01);
		Assertions.assertEquals(pessoa.getNascimento().getDayOfMonth(), 25);
	}
	
	//Teste de mock para o fluxo de exceçao do caso de uso, deve disparar uma exception por falha na API
	@Test
	void testCadastrarPessoaMasSistemaDosCorreiosForaDoAr() {
		Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep(anyString())).thenThrow(RuntimeException.class);
		
		Assertions.assertThrows(RuntimeException.class, () -> cadastrarPessoa.cadastrarPessoa("Jose", "123", LocalDate.now(),"1234123" ));
	}
}
