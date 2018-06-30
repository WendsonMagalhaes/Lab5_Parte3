package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe Aposta.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ApostaTest {
	/**
	 * Aposta
	 */
	private Aposta aposta;
	/**
	 * Método que cria a aposta que será usada nos teste unitários.
	 */
	@Before
	public void preparaAposta() {
		this.aposta = new Aposta(1,"Francisco Cisco", 20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica os valores(Caso a aposta seja ganhadora) passados
	 * quando uma aposta é encerrada como Não ocorreu.
	 */
	@Test
	public void testVerificaAposta() {
		
		
		assertTrue(0 == aposta.verificaAposta("Finalizado (n ocorreu)")[0]);
		assertTrue(0 == aposta.verificaAposta("Finalizado (n ocorreu)")[1]);
		assertTrue(1 == aposta.verificaAposta("Finalizado (n ocorreu)")[2]);

	}
	/**
	 * Teste que verifica os valores(Caso a aposta seja perdedora) passados
	 * quando uma aposta é encerrada como Não ocorreu.
	 */
	@Test
	public void testVerificaApostaPerdedora() {
	
		
		assertTrue(20000 == aposta.verificaAposta("Finalizado (ocorreu)")[0]);
		assertTrue(0 == aposta.verificaAposta("Finalizado (ocorreu)")[1]);
		assertTrue(0 == aposta.verificaAposta("Finalizado (ocorreu)")[2]);
		
	}
	/**
	 * Teste que verifica se cria uma aposta , passando
	 * todos os parâmetros válidos.
	 */
	@Test
	public void testApostaComum() {
		 new Aposta(1,"Wendson Magalhães", 20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com número de identificação zero.
	 */
	@Test(expected =NumberFormatException.class)
	public void testApostaComumNumeroDeIdentificaoZero() {
		 new Aposta(0,"Wendson Magalhães", 2000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com número de identificação negativo.
	 */
	@Test(expected =NumberFormatException.class)
	public void testApostaComumNumeroDeIdentificacaoNegativo() {
		 new Aposta(-1,"Wendson Magalhães", 20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComumApostadorVazio() {
		 new Aposta(1,"", 20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComumApostadorNulo() {
		 new Aposta(1,null, 20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com o valor zero.
	 */
	@Test(expected =NumberFormatException.class)
	public void testApostaComumValorZero() {
		 new Aposta(1,"Wendson Magalhães", 0, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com o valor negativo.
	 */
	@Test(expected =NumberFormatException.class)
	public void testApostaComumValorNegativo() {
		 new Aposta(1,"Wendson Magalhães", -20000, "N VAI ACONTECER");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComumPrevisaoVazia() {
		 new Aposta(1,"Wendson Magalhães", 20000, "");
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComumPrevisaoNula() {
		 new Aposta(1,"Wendson Magalhães", 20000, null);
	}
	/**
	 * Teste que verifica se gerar uma exceção ao tentar criar uma aposta
	 * com a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaComumPrevisaoInvalida() {
		 new Aposta(1,"Wendson Magalhães", 20000, "NAO VAI ACONTECER");
	}
	/**
	 * Teste que verifica o método toString de uma aposta.
	 */
	@Test
	public void testToString() {
		assertEquals("Francisco Cisco - R$200,00 - N VAI ACONTECER",aposta.toString());
	}
	/**
	 * Teste que verifica o método getApostador parâmetros iguais
	 */
	@Test
	public void testGetApostador() {
		assertEquals("Francisco Cisco", aposta.getApostador());
	}
	/**
	 * Teste que verifica o método getApostador parâmetros diferentes.
	 */
	@Test
	public void testGetApostadorDiferentes() {
		assertNotEquals("Cisco", aposta.getApostador());
	}
	/**
	 * Teste que verifica o método getValor parâmetros iguais
	 */
	@Test
	public void testGetValor() {
		assertEquals(20000,aposta.getValor());
	}
	/**
	 * Teste que verifica o método getValor parâmetros diferentes.
	 */
	@Test
	public void testGetValorDiferentes() {
		assertNotEquals(0,aposta.getValor());
	}
	/**
	 * Teste que verifica o método getPrevisao parâmetros iguais
	 */
	@Test
	public void testGetPrevisao() {
		assertEquals("N VAI ACONTECER",aposta.getPrevisao());
	}
	/**
	 * Teste que verifica o método getPrevisao parâmetros diferentes.
	 */
	@Test
	public void testGetPrevisaoDiferentes() {
		assertNotEquals("VAI ACONTECER",aposta.getPrevisao());
	}
	/**
	 * Teste que verifica o método getIdApostas parâmetros iguais
	 */
	@Test
	public void testGetIdAposta() {
		assertEquals(1,aposta.getIdAposta());
	}
	/**
	 * Teste que verifica o método getIdAposta parâmetros diferentes.
	 */
	@Test
	public void testGetIdApostaDiferentes() {
		assertNotEquals(3,aposta.getIdAposta());
	}

}
