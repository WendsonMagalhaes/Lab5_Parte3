package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe Cenario.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class CenarioTest {
	/**
	 * Cenario
	 */
	private Cenario cenario;

	/**
	 * Método que cria o cenário que será usado durante os testes unitários.
	 */
	@Before
	public void preparaCenario() {

		this.cenario = new Cenario(1,
				"A maioria irá tirar mais do que 7 na prova!");
	}

	/**
	 * Teste que verifica se o hashCode de dois cenários são iguais, comparando
	 * o número de identificação dos cenários.
	 */
	@Test
	public void testHashCode() {
		Cenario c = new Cenario(1,
				"A maioria irá tirar mais do que 7 na prova!");
		assertEquals(c.hashCode(), cenario.hashCode());
	}

	/**
	 * Teste que verifica se o hashCode de dois cenários são diferentes,
	 * comparando o número de identificação dos cenários.
	 */
	@Test
	public void testHashCodeDiferentes() {
		Cenario c = new Cenario(2,
				"A maioria irá tirar mais do que 7 na prova!");
		assertNotEquals(c.hashCode(), cenario.hashCode());
	}

	/**
	 * Teste que verifica se cria um cenário, passando todos os parâmetros
	 * válidos.
	 */
	@Test
	public void testCenario() {
		new Cenario(1, "A maioria irá tirar mais do que 7 na prova!");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um cenário com o
	 * número de identificação zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioPosicaoZero() {
		new Cenario(0, "A maioria irá tirar mais do que 7 na prova!");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um cenário com o
	 * número de identificação negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioPosicaoNegativa() {
		new Cenario(-1, "A maioria irá tirar mais do que 7 na prova!");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um cenário com a
	 * descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoVazia() {
		new Cenario(1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um cenário com a
	 * descrição nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioDescricaoNula() {
		new Cenario(1, null);
	}

	/**
	 * Teste que verifica se cadastra uma aposta, passando todos os parâmetros
	 * válidos.
	 */
	@Test
	public void testCadastraAposta() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o número de identificação zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaNumeroDeIdentificacaoZero() {
		
		cenario.cadastraAposta(0, "Francisco Cisco", 200, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o número de identificação negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaNumeroDeIdentificacaoNegativo() {
		
		cenario.cadastraAposta(-1, "Francisco Cisco", 200,
				"N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaApostadorVazio() {
		
		cenario.cadastraAposta(1, "", 200, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaApostadorNulo() {
		
		cenario.cadastraAposta(1, null, 200, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaValorZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 0, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com o vaor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaValorNegativo() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", -200,
				"N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com a previsão vazia
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoVazia() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, "");
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com a previsão nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoNula() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, null);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * com a previsão inválida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaPrevisaoInvalida() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"NAO VAI ACONTECER");
	}

	/**
	 * Teste que verifica se cadastra uma aposta assegurada, passando todos os
	 * parâmetros válidos
	 */
	@Test
	public void testCadastraApostaSeguraValor() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o número de identificação zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorNumeroDeIdentificacaoZero() {
		
		cenario.cadastraAposta(0, "Francisco Cisco", 200,
				"N VAI ACONTECER", 100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o número de identificação negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorNumeroDeIdentificacaoNegativo() {
		
		cenario.cadastraAposta(-1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorApostadorVazio() {
		
		cenario.cadastraAposta(1, "", 200, "N VAI ACONTECER",
				100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorApostadorNulo() {
		
		cenario.cadastraAposta(1, null, 200, "N VAI ACONTECER",
				100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 0,
				"N VAI ACONTECER", 100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorNegativo() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", -200,
		"N VAI ACONTECER", 100, 1);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoVazia() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, "",
				100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoNula() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, null,
				100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão inválida
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoInvalida() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"NAO VAI ACONTECER", 100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor assegurado zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorSeguradoZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor assegurado negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorSeguradoNegativo() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", -100, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o custo zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCustoZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 100, 0);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por valor com o custo negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCustoNegativo() {
	
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 100, -10);
	}

	/**
	 * Teste que verifica se cadastra uma aposta assegurada por taxa, passando
	 * todos os parâmetros válidos.
	 */
	@Test
	public void testCadastraApostaSeguraTaxa() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o número de identificação zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaNumeroDeIdentificacaoZero() {
		
		cenario.cadastraAposta(0, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o número de identificação negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaNumeroDeIdentificacaoNegativo() {
		
		cenario.cadastraAposta(-1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o nome do apostador vazio
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaApostadorVazio() {
		
		cenario.cadastraAposta(1, "", 200, "N VAI ACONTECER",
				0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaApostadorNulo() {
		
		cenario.cadastraAposta(1, null, 200, "N VAI ACONTECER",
				0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaValorZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 0,
				"N VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaValorNegativo() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", -200,
				"N VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoVazia() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, "",
				0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoNula() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200, null,
				0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoInvalida() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"NAO VAI ACONTECER", 0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a taxa zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaTaxaZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a taxa negativa.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaTaxaNegativa() {
	
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", -0.05, 10);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o custo zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCustoZero() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0.05, 0);
	}

	/**
	 * Teste que verifica se gera uma execeção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o custo negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCustoNegativo() {
		
		cenario.cadastraAposta(1, "Francisco Cisco", 200,
				"N VAI ACONTECER", 0.05, -10);
	}

	/**
	 * Teste que verifica o método exibeAposta() de um cenário com apostas
	 * cadastradas
	 */
	@Test
	public void testExibeApostas() {
		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");

		assertEquals(
				"Francisco Cisco - R$200,00 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$10,00"
						+ System.lineSeparator()
						+ "Anonimo - R$1,99 - N VAI ACONTECER"
						+ System.lineSeparator()
						+ "Matheus - R$100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 1%"
						+ System.lineSeparator()
						+ "Livia - R$300,00 - VAI ACONTECER"
						+ System.lineSeparator(), cenario.exibeApostas());

	}

	/**
	 * Teste que verifica o método exibeApostas() de um cenário sem apostas.
	 */
	@Test
	public void testExibeApostasSemApostas() {

		assertEquals("", cenario.exibeApostas());
	}

	/**
	 * Teste que verifica o método encerraCenario() quando o cenário ocorreu.
	 */
	@Test
	public void testEncerraCenarioOcorreu() {
		cenario.encerraCenario(true);
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Finalizado (ocorreu)",
				cenario.toString());
	}

	/**
	 * Teste que verifica o método encerraCenario() quando o cenário não
	 * ocorreu.
	 */
	@Test
	public void testEncerraCenarioNaoOcorreu() {
		cenario.encerraCenario(false);
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Finalizado (n ocorreu)",
				cenario.toString());
	}

	/**
	 * Teste que verifica o método calculaResultado() de um cenário com apostas
	 * cadastradas.
	 */
	@Test
	public void testCalculaResultado() {
		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");
		cenario.encerraCenario(true);
		assertEquals(20199, cenario.calculaResultado()[0], 0.00001);
		assertEquals(1000, cenario.calculaResultado()[1], 0.00001);
	}

	/**
	 * Teste que verifica o método calculaResultado() de um cenário sem apostas.
	 */
	@Test
	public void testCalculaResultadoSemApostas() {

		cenario.encerraCenario(true);
		assertEquals(0, cenario.calculaResultado()[0], 0.00001);
		assertEquals(0, cenario.calculaResultado()[1], 0.00001);
	}

	/**
	 * Teste que verifica o método totalRateioCenario() de um cenário com
	 * apostas cadastradas.
	 */
	@Test
	public void testTotalRateioCenario() {

		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");
		cenario.encerraCenario(true);
		assertEquals(19998, cenario.totalRateioCenario(0.01));

	}

	/**
	 * Teste que verifica o método totalRateioCenario() de um cenário sem
	 * apostas.
	 */
	@Test
	public void testTotalRateioCenarioSemApostas() {

		cenario.encerraCenario(true);
		assertEquals(0, cenario.totalRateioCenario(0.01));

	}

	/**
	 * Teste que verifica o método alteraApostaSeguroValor(), alterando a aposta
	 * assegurada por taxa para uma aposta assegurada por valor.
	 */
	@Test
	public void testAlteraApostaSeguroValor() {
		cenario.cadastraAposta(1, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.alteraApostaSeguroValor(1, 1000);
		assertEquals(
				"Matheus - R$100,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$10,00"
						+ System.lineSeparator(), cenario.exibeApostas());

	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar alterar uma aposta não
	 * cadastrada.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraApostaSeguroValorApostaNaoCadastrada() {
		cenario.cadastraAposta(1, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.alteraApostaSeguroValor(2, 1000);

	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar alterar uma aposta não
	 * assegurada.
	 */
	@Test(expected = ClassCastException.class)
	public void testAlteraApostaSeguroValorApostaComum() {
		cenario.cadastraAposta(1, "Matheus", 10000, "VAI ACONTECER");
		cenario.alteraApostaSeguroValor(1, 1000);

	}

	/**
	 * Teste que verifica o método alteraApostaSeguroTaxa(), alterando a aposta
	 * assegurada por valor para uma aposta assegurada por taxa.
	 */
	@Test
	public void testAlteraApostaSeguraTaxa() {
		cenario.cadastraAposta(1, "Matheus", 10000,
				"VAI ACONTECER", 1000, 40);
		cenario.alteraApostaSeguraTaxa(1, 0.01);
		assertEquals(
				"Matheus - R$100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 1%"
						+ System.lineSeparator(), cenario.exibeApostas());

	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar alterar uma aposta não
	 * cadastrada.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testAlteraApostaSeguraTaxaApostaNaoCadastrada() {
		cenario.cadastraAposta(1, "Matheus", 10000,
				"VAI ACONTECER", 1000, 40);
		cenario.alteraApostaSeguraTaxa(2, 0.01);

	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar alterar uma aposta não
	 * assegurada.
	 */
	@Test(expected = ClassCastException.class)
	public void testAlteraApostaSeguraTaxaApostaComum() {
		cenario.cadastraAposta(1, "Matheus", 10000, "VAI ACONTECER");
		cenario.alteraApostaSeguraTaxa(1, 0.01);

	}

	/**
	 * Teste que verifica o método getAposta(), cénario sem apostas.
	 */
	@Test
	public void testGetQtdApostasSemAposta() {
		assertEquals(0, cenario.getQtdApostas());
	}

	/**
	 * Teste que verifica o método getAposta(), cénario com apostas.
	 */
	@Test
	public void testGetQtdApostasApostasCadastradas() {
		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");
		assertEquals(4, cenario.getQtdApostas());
	}

	/**
	 * Teste que verifica o método getAposta(), parâmetros diferentes.
	 */
	@Test
	public void testGetQtdApostasDeiferente() {
		assertNotEquals(1, cenario.getQtdApostas());
	}

	/**
	 * Teste que verifica o método getValorApostas(), cénario sem apostas.
	 */
	@Test
	public void testGetValorApostasSemApostas() {
		assertEquals(0, cenario.getValorApostas(), 0.00001);
	}

	/**
	 * Teste que verifica o método getValorApostas(), cénario com apostas.
	 */
	@Test
	public void testGetValorApostasApostasCadastradas() {
		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");

		assertEquals(60199, cenario.getValorApostas(), 0.00001);
	}

	/**
	 * Teste que verifica o método getValorApostas(), parâmetros diferentes.
	 */
	@Test
	public void testGetValorApostasDiferentes() {
		assertNotEquals(1, cenario.getValorApostas());
	}

	/**
	 * Teste que verifica o método getEstado() com parâmetros iguais.
	 */
	@Test
	public void testGetEstado() {
		assertEquals("Nao finalizado", cenario.getEstado());
	}

	/**
	 * Teste que verifica o método getEstado() com parâmetros diferentes.
	 */
	@Test
	public void testGetEstadoDifenretes() {
		assertNotEquals("Nao Finalizado", cenario.getEstado());
	}

	/**
	 * Teste que verifica o método getCenario() com parâmetros iguais.
	 */
	@Test
	public void testGetCenario() {
		assertEquals(1, cenario.getCenario());
	}

	/**
	 * Teste que verifica o método getCenario() com parâmetros diferentes.
	 */
	@Test
	public void testGetCenarioDiferentes() {
		assertNotEquals(0, cenario.getCenario());
	}

	/**
	 * Teste que verifica o método getQtdGanhadores() cenário vazio.
	 */
	@Test
	public void testGetQtdGanhadoresCenarioVazio() {
		assertEquals(0, cenario.getQtdGanhadores());
	}

	/**
	 * Teste que verifica o método getQtdGanhadores() cenário com apostas.
	 */
	@Test
	public void testGetQtdGanhadoresCenarioApostasCadastradas() {
		cenario.cadastraAposta(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		cenario.cadastraAposta(2, "Anonimo", 199, "N VAI ACONTECER");
		cenario.cadastraAposta(3, "Matheus", 10000,
				"VAI ACONTECER", 0.01, 40);
		cenario.cadastraAposta(4, "Livia", 30000, "VAI ACONTECER");

		cenario.encerraCenario(true);
		assertEquals(2, cenario.getQtdGanhadores());
	}

	/**
	 * Teste que verifica o método getQtdGanhadores() parâmetros diferentes.
	 */
	@Test
	public void testGetQtdGanhadoresDiferente() {
		assertNotEquals(1, cenario.getQtdGanhadores());
	}

	

	/**
	 * Teste que verifica o método toString()
	 */
	@Test
	public void testToString() {
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado",
				cenario.toString());
	}

	/**
	 * Teste que verifica se dois cénarios são iguais usando o método equals
	 * comparando seu número de identificação.
	 */
	@Test
	public void testEqualsObject() {
		Cenario c = new Cenario(1,
				"A maioria irá tirar mais do que 8 na prova!");
		assertTrue(cenario.equals(c));
	}
	/**
	 * Teste que verifica se dois cénarios são diferentes usando o método equals
	 * comparando seu número de identificação.
	 */
	@Test
	public void testEqualsObjectDiferentes() {
		Cenario c = new Cenario(2,
				"A maioria irá tirar mais do que 8 na prova!");
		assertFalse(cenario.equals(c));
	}

}
