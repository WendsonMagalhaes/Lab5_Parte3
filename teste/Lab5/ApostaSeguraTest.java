package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe ApostaSegura.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ApostaSeguraTest {
	/**
	 * Aposta assegurada do tipo valor.
	 */
	private ApostaSegura apostaValor;
	/**
	 * Aposta assegurada do tipo taxa.
	 */
	private ApostaSegura apostaTaxa;

	/**
	 * Método que cria os objetos apostaValor e apostaTaxa que serão usados nos
	 * testes unitários.
	 */
	@Before
	public void preparaAposta() {
		this.apostaValor = new ApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		this.apostaTaxa = new ApostaSegura(2, "Francisco Cisco", 20000,
				"VAI ACONTECER", 0.05, 50);

	}

	/**
	 * Teste que verifica se o hashCode de duas apostas asseguradas são iguais,
	 * comparando o número de identificação das apostas.
	 */
	@Test
	public void testHashCode() {
		ApostaSegura aposta = new ApostaSegura(1, "Wendson Magalhaes", 200,
				"VAI ACONTECER", 10, 5);
		assertEquals(apostaValor.hashCode(), aposta.hashCode());
	}

	/**
	 * Teste que verifica se o hashCode de duas apostas asseguradas são
	 * diferentes, comparando o número de identificação das apostas.
	 */
	@Test
	public void testHashCodeDiferentes() {
		ApostaSegura aposta = new ApostaSegura(1, "Wendson Magalhaes", 200,
				"VAI ACONTECER", 10, 5);
		assertNotEquals(apostaTaxa.hashCode(), aposta.hashCode());
	}

	/**
	 * Teste que verifica os valores(Caso a aposta seja ganhadora)passados
	 * quando uma aposta assegurada por valor é encerrada como Não ocorreu.
	 */
	@Test
	public void testVerificaApostaValorGanhadora() {
		assertTrue(0 == apostaValor.verificaAposta("Finalizado (n ocorreu)")[0]);
		assertTrue(0 == apostaValor.verificaAposta("Finalizado (n ocorreu)")[1]);
		assertTrue(1 == apostaValor.verificaAposta("Finalizado (n ocorreu)")[2]);
	}

	/**
	 * Teste que verifica os valores(Caso a aposta seja ganhadora) passados
	 * quando uma aposta assegurada por taxa é encerrada como ocorreu.
	 */
	@Test
	public void testVerificaApostaTaxaGanhaadora() {
		assertTrue(0 == apostaTaxa.verificaAposta("Finalizado (ocorreu)")[0]);
		assertTrue(0 == apostaTaxa.verificaAposta("Finalizado (ocorreu)")[1]);
		assertTrue(1 == apostaTaxa.verificaAposta("Finalizado (ocorreu)")[2]);
	}

	/**
	 * Teste que verifica os valores(Caso a aposta seja perdedora) passados
	 * quando uma aposta assegurada por valor é encerrada como Ocorreu.
	 */
	@Test
	public void testVerificaApostaValorPerdedora() {
		assertTrue(20000 == apostaValor.verificaAposta("Finalizado (Ocorreu)")[0]);
		assertTrue(10000 == apostaValor.verificaAposta("Finalizado (Ocorreu)")[1]);
		assertTrue(0 == apostaValor.verificaAposta("Finalizado (Ocorreu)")[2]);
	}

	/**
	 * Teste que verifica os valores(Caso a aposta seja perdedora) passados
	 * quando uma aposta assegurada por taxa é encerrada como Não ocorreu.
	 */
	@Test
	public void testVerificaApostaTaxaPerdedora() {
		assertTrue(20000 == apostaTaxa
				.verificaAposta("Finalizado (Não ocorreu)")[0]);
		assertTrue(1000 == apostaTaxa
				.verificaAposta("Finalizado (Não ocorreu)")[1]);
		assertTrue(0 == apostaTaxa.verificaAposta("Finalizado (Não ocorreu)")[2]);
	}

	/**
	 * Teste que verifica se cria uma aposta assegurada do tipo valor, passando
	 * todos os parâmetros válidos.
	 */
	@Test
	public void testApostaSeguraValor() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "N VAI ACONTECER", 10000,
				50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com número de identificação zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorNumeroDeIdentificacaoZero() {
		new ApostaSegura(0, "Francisco Cisco", 20000, "N VAI ACONTECER", 10000,
				50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com número de identificação negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorNumeroDeIdentificacaoNegativo() {
		new ApostaSegura(-1, "Francisco Cisco", 20000, "N VAI ACONTECER",
				10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraValorNomeVazio() {
		new ApostaSegura(1, "", 20000, "N VAI ACONTECER", 10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraValorNomeNulo() {
		new ApostaSegura(1, null, 20000, "N VAI ACONTECER", 10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorValorZero() {
		new ApostaSegura(1, "Francisco Cisco", 0, "N VAI ACONTECER", 10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorValorNegativo() {
		new ApostaSegura(1, "Francisco Cisco", -20000, "N VAI ACONTECER",
				10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraValorPrevisaoVazia() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "", 10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraValorPrevisaoNula() {
		new ApostaSegura(1, "Francisco Cisco", 20000, null, 10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraValorPreivisaoInvalida() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "NAO VAI ACONTECER",
				10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor do segura da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorValorSeguroZero() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "N VAI ACONTECER", 0, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor do seguro da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorValorSeguroNegativo() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "N VAI ACONTECER",
				-10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor do custo da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorCustoZero() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "N VAI ACONTECER", 10000,
				0);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo valor com o valor do custo da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraValorCustoNegativo() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "N VAI ACONTECER", 10000,
				-50);
	}

	/**
	 * Teste que verifica se cria uma aposta assegurada do tipo taxa, passando
	 * todos os parâmetros válidos.
	 */
	@Test
	public void testApostaSeguraTaxa() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ACONTECER", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o número de identificação zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaNumeroDeIdenficacaoZero() {
		new ApostaSegura(0, "Francisco Cisco", 20000, "VAI ACONTECER", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o número de identificação negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaNumeroDeIdentificacaoNegativo() {
		new ApostaSegura(-1, "Francisco Cisco", 20000, "VAI ACONTECER", 0.05,
				50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com com o nome do apostador vazio.
	 */

	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraTaxaNomeVazio() {
		new ApostaSegura(1, "", 20000, "VAI ACONTECER", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraTaxaNomeNulo() {
		new ApostaSegura(1, null, 20000, "VAI ACONTECER", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o valor da aposta zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaValorZero() {
		new ApostaSegura(1, "Francisco Cisco", 0, "VAI ACONTECER", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o valor da aposta negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaValorNegativo() {
		new ApostaSegura(1, "Francisco Cisco", -20000, "VAI ACONTECER", 0.05,
				50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com a previsão vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraTaxaPrevisaoVazia() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraTaxaPrevisaoNula() {
		new ApostaSegura(1, "Francisco Cisco", 20000, null, 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testApostaSeguraTaxaPrevisaoInvalida() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ", 0.05, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com a taxa zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaTaxaZero() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ACONTECER", 0, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com a taxa negativa.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaTaxaNegativa() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ACONTECER", -0.05,
				50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o custo da aposta zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaCustoZero() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ACONTECER", 0.05, 0);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma aposta
	 * assegurada do tipo taxa com o custo da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testApostaSeguraTaxaCustoNegativo() {
		new ApostaSegura(1, "Francisco Cisco", 20000, "VAI ACONTECER", 0.05,
				-50);
	}

	/**
	 * Teste que verifica o método calculaValorAposta de uma aposta assegurada
	 * por valor.
	 */
	@Test
	public void testCalculaValorApostaValor() {

		assertTrue(10000 == apostaValor.calculaValor());
	}

	/**
	 * Teste que verifica o método calculaValorAposta de uma aposta assegurada
	 * por taxa.
	 */
	@Test
	public void testCalculaValorApostaTaxa() {
		double valor = (int) 20000 * 0.05;
		assertTrue(valor == apostaTaxa.calculaValor());
	}

	/**
	 * Teste que verifica o método getCusto de uma aposta assegurada por valor.
	 */
	@Test
	public void testGetCustoApostaValor() {
		assertEquals(50, apostaValor.getCusto());
	}

	/**
	 * Teste que verifica o método getCusto de uma aposta assegurada por taxa.
	 */
	@Test
	public void testGetCustoApostaTaxa() {
		assertEquals(50, apostaTaxa.getCusto());
	}

	/**
	 * Teste que verifica o método getCusto de uma aposta assegurada por valor
	 * com valores diferentes.
	 */
	@Test
	public void testGetCustoApostaValorDiferentes() {
		assertNotEquals(55, apostaValor.getCusto());
		;
	}

	/**
	 * Teste que verifica o método getCusto de uma aposta assegurada por taxa
	 * com valores diferentes.
	 */
	@Test
	public void testGetCustoApostaTaxaDiferentes() {
		assertNotEquals(55, apostaTaxa.getCusto());
		;
	}

	/**
	 * Teste que verifica o método toString de uma aposta assegurada por valor.
	 */
	@Test
	public void testToStringApostaValor() {

		assertEquals(
				"Francisco Cisco - R$200,00 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$100,00",
				apostaValor.toString());
	}

	/**
	 * Teste que verifica o método toString de uma aposta assegurada por taxa.
	 */
	@Test
	public void testToStringApostaTaxa() {

		assertEquals(
				"Francisco Cisco - R$200,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 5%",
				apostaTaxa.toString());
	}

	/**
	 * Teste que verifica se duas aposta asseguradas por valor são iguais usando
	 * o método equals.
	 */
	@Test
	public void testEqualsObjectApostaValor() {
		ApostaSegura aposta = new ApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		assertTrue(apostaValor.equals(aposta));
	}

	/**
	 * Teste que verifica se duas aposta asseguradas por valor são diferentes
	 * usando o método equals.
	 */
	@Test
	public void testEqualsObjectApostaValorDiferentes() {
		ApostaSegura aposta = new ApostaSegura(3, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		assertFalse(apostaValor.equals(aposta));
	}

	/**
	 * Teste que verifica se duas aposta asseguradas por taxa são iguais usando
	 * o método equals.
	 */
	@Test
	public void testEqualsObjectApostaTaxa() {
		ApostaSegura aposta = new ApostaSegura(2, "Francisco Cisco", 20000,
				"VAI ACONTECER", 0.05, 50);
		assertFalse(apostaValor.equals(aposta));
	}

	/**
	 * Teste que verifica se duas aposta asseguradas por taxa são diferentes
	 * usando o método equals.
	 */
	@Test
	public void testEqualsObjectApostaTaxaDiferentes() {
		ApostaSegura aposta = new ApostaSegura(4, "Francisco Cisco", 20000,
				"VAI ACONTECER", 0.05, 50);
		assertFalse(apostaValor.equals(aposta));
	}

	/**
	 * Teste que verifica o método getApostador parâmetros iguais.
	 */
	@Test
	public void testGetApostador() {
		assertEquals("Francisco Cisco", apostaValor.getApostador());
	}

	/**
	 * Teste que verifica o método getApostador parâmetros diferentes
	 */
	@Test
	public void testGetApostadorDiferentes() {
		assertNotEquals("Francisco", apostaValor.getApostador());
	}

	/**
	 * Teste que verifica o método getValor parâmetros iguais
	 */
	@Test
	public void testGetValor() {
		assertEquals(20000, apostaTaxa.getValor());
	}

	/**
	 * Teste que verifica o método getValor parâmetros diferentes
	 */
	@Test
	public void testGetValorDiferentes() {
		assertEquals(20000, apostaTaxa.getValor());
	}

	/**
	 * Teste que verifica o método getPrevisao parâmetros iguais
	 */
	@Test
	public void testGetPrevisao() {
		assertEquals("VAI ACONTECER", apostaTaxa.getPrevisao());
	}

	/**
	 * Teste que verifica o método getPrevisao parâmetros diferentes
	 */
	@Test
	public void testGetPrevisaoDiferentes() {
		assertNotEquals("N VAI ACONTECER", apostaTaxa.getPrevisao());
	}

	/**
	 * Teste que verifica o método getIdAposta parâmetros iguais.
	 */
	@Test
	public void testGetIdAposta() {
		assertEquals(1, apostaValor.getIdAposta());
		assertEquals(2, apostaTaxa.getIdAposta());
	}

	/**
	 * Teste que verifica o método getIdAposta parâmetros diferentes.
	 */
	@Test
	public void testGetIdApostaDiferentes() {
		assertNotEquals(3, apostaValor.getIdAposta());
		assertNotEquals(4, apostaTaxa.getIdAposta());
	}

}
