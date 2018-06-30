package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe ControllerCenarios.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ControllerCenariosTest {

	/**
	 * Sistema de apostas.
	 */
	private ControllerCenarios sistema;

	/**
	 * Método que cria o sistema de apostas com dois cenários cadastrados que
	 * serão usados durante os testes unitários.
	 */
	@Before
	public void criaControllerCenario() {
		this.sistema = new ControllerCenarios(2000, 0.05);
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!");
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!",
				1000);
	}

	/**
	 * Teste cria um controllerCenario com parâmetrosválidos.
	 */
	@Test
	public void testControllerCenarios() {
		new ControllerCenarios(2000, 0.5);
	}

	/**
	 * Teste cria um controllerCenario com o valor do caixa zero.
	 */
	@Test
	public void testControllerCenariosCaixaZero() {
		new ControllerCenarios(0, 0.5);
	}

	/**
	 * Teste cria um controllerCenario com o valor da taxa zero.
	 */
	@Test
	public void testControllerCenariosTaxaZero() {
		new ControllerCenarios(2000, 0);
	}

	/**
	 * Teste que gera uma exceção ao tentar criar um controllerCenario com o
	 * valor do caixa negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testControllerCenariosCaixaNegativo() {
		new ControllerCenarios(-2000, 0.5);
	}

	/**
	 * Teste que gera uma exceção ao tentar criar um controllerCenario com o
	 * valor da taxa negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testControllerCenariosTaxaNegativa() {
		new ControllerCenarios(2000, -0.5);
	}

	/**
	 * Teste que verifica o método getCaixa() com parâmetros iguais.
	 */
	@Test
	public void testGetCaixa() {
		assertEquals(1000, sistema.getCaixa());
	}

	/**
	 * Teste que verifica o método getCaixa() com parâmetros diferentes.
	 */
	@Test
	public void testGetCaixaDiferente() {
		assertNotEquals(0, sistema.getCaixa());
	}

	/**
	 * Teste que verifica o método getTaxa() com parâmetros iguais.
	 */
	@Test
	public void testGetTaxa() {
		assertEquals(0.05, sistema.getTaxa(), 0.00001);
	}

	/**
	 * Teste que verifica o método getTaxa() com parâmetros diferentes.
	 */
	@Test
	public void testGetTaxaDiferentes() {
		assertNotEquals(0, sistema.getTaxa(), 0.00001);
	}

	/**
	 * Teste que cadastra um cénario com os parâmetros válidos
	 */
	@Test
	public void testCadastraCenario() {
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!");
	}

	/**
	 * Teste que gera um exceção ao tentar cadastra um cénario com a discrição
	 * vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioDescricaoVazia() {
		sistema.cadastraCenario("");
	}

	/**
	 * Teste que gera um exceção ao tentar cadastra um cénario com a discrição
	 * nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioDescricaoNulo() {
		sistema.cadastraCenario(null);
	}

	/**
	 * Teste que verifica se cadastra um cenário com bônus passando parâmetros
	 * válidos.
	 */
	@Test
	public void testCadastraCenarioBonus() {
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!",
				1000);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioBonusDescricaoVazia() {
		sistema.cadastraCenario("", 1000);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com descrição nula
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraCenarioBonusDescricaoNula() {
		sistema.cadastraCenario(null, 1000);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com bônus zero
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraCenarioBonusBonusZero() {
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!",
				0);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com bônus negativo
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraCenarioBonusBonusNegativo() {
		sistema.cadastraCenario("A maioria irá tirar mais do que 7 na prova!",
				-10000);
	}

	/**
	 * Teste que verifica se cadastra uma aposta passando parâmetros válidos.
	 */
	@Test
	public void testCadastraApostaComum() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o número do cenário zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaComumCenarioZero() {
		sistema.cadastraAposta(0, "Francisco Cisco", 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o número do cenário negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaComumCenarioNegativo() {
		sistema.cadastraAposta(-1, "Francisco Cisco", 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o número do cénario não cadastrado.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastraApostaComumCenarioNaoCadastrado() {
		sistema.cadastraAposta(3, "Francisco Cisco", 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaComumApostadorVazio() {
		sistema.cadastraAposta(1, "", 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaComumApostadorNulo() {
		sistema.cadastraAposta(1, null, 20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaComumValorZero() {
		sistema.cadastraAposta(1, "Francisco Cisco", 0, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaComumValorNegativo() {
		sistema.cadastraAposta(1, "Francisco Cisco", -20000, "N VAI ACONTECER");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaComumPrevisaoVazia() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaComumPrevisaoNula() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, null);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar uma aposta com
	 * a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaComumPrevisaoInvalida() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "NAO VAI ACONTECER");
	}

	/**
	 * Teste que verifica se cadastra uma aposta assegurada por valor passando
	 * parâmetros válidos.
	 */
	@Test
	public void testCadastraApostaSeguraValor() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o número do cenário zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCenarioZero() {
		sistema.cadastraApostaSegura(0, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o número do cenário negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCenarioNegativo() {
		sistema.cadastraApostaSegura(-1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o número de um cenário não cadastrado.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastraApostaSeguraValorCenarioNaoCadastrado() {
		sistema.cadastraApostaSegura(3, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorApostadorVazio() {
		sistema.cadastraApostaSegura(1, "", 20000, "N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorApostadorNulo() {
		sistema.cadastraApostaSegura(1, null, 20000, "N VAI ACONTECER", 1000,
				50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 0,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorNegativo() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", -20000,
				"N VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoVazia() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000, "", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoNula() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000, null, 1000,
				50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraValorPrevisaoInvalida() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"NAO VAI ACONTECER", 1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor assegurado zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorAsseguradoZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o valor assegurado negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorValorAsseguradoNegativo() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", -1000, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o custo zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCustoZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 0);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por valor com o custo negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorCustoNegativo() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, -50);
	}

	/**
	 * Teste que verifica se cadastrar uma aposta assegurada por taxa passando
	 * todos os parâmetros válidos.
	 */
	@Test
	public void testCadastraApostaSeguraTaxa() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o número do cenário zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCenarioZero() {
		sistema.cadastraApostaSegura(0, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o número do cenário negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCenarioNegativo() {
		sistema.cadastraApostaSegura(-1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o número de um cenário não cadastrado.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testCadastraApostaSeguraTaxaCenarioNaoCadastrado() {
		sistema.cadastraApostaSegura(3, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o nome do apostador vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaApostadorVazio() {
		sistema.cadastraApostaSegura(1, "", 20000, "N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o nome do apostador nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaApostadorNulo() {
		sistema.cadastraApostaSegura(1, null, 20000, "N VAI ACONTECER", 0.01,
				50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o valor da aposta zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaValorZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 0,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o valor da aposta negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraValorTaxaNegativo() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", -20000,
				"N VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoVazia() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000, "", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoNula() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000, null, 0.01,
				50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCadastraApostaSeguraTaxaPrevisaoInvalida() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"NAO VAI ACONTECER", 0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a taxa zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaTaxaZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com a taxa negativa.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaTaxaNegativa() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", -0.01, 50);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o custo zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCustoZero() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 0);
	}

	/**
	 * Teste que verifica se gera um exceção ao tentar cadastrar uma aposta
	 * assegurada por taxa com o custo negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCadastraApostaSeguraTaxaCustoNegativo() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, -50);
	}

	/**
	 * Teste que verifica o uso do método valorTotalApostas() cenário vazio.
	 */
	@Test
	public void testValorTotalApostasCenarioVazio() {
		assertEquals(0, sistema.valorTotalApostas(1));
	}

	/**
	 * Teste que verifica o uso do método valorTotalApostas() cenário com
	 * aposas.
	 */
	@Test
	public void testValorTotalApostas() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		assertEquals(20000, sistema.valorTotalApostas(1));
	}

	/**
	 * Teste que verifica o uso do método valorTotalApostas() com parâmetros
	 * diferentes.
	 */
	@Test
	public void testValorTotalApostasDiferente() {

		assertNotEquals(3, sistema.valorTotalApostas(1));
	}

	/**
	 * Teste que verifica o uso do método totalApostasCenario() de um cenario
	 * vazio.
	 */
	@Test
	public void testTotalDeApostasCenarioVazio() {

		assertEquals(0, sistema.totalDeApostas(1));
	}

	/**
	 * Teste que verifica o uso do método totalApostasCenario() de um cenario
	 * com apostas cadastradas.
	 */
	@Test
	public void testTotalDeApostas() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "N VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		assertEquals(3, sistema.totalDeApostas(1));
	}

	/**
	 * Teste que verifica o uso do método totalApostasCenario() com parâmetros
	 * diferentes.
	 */
	public void testTotalDeApostasDiferentes() {

		assertEquals(1, sistema.totalDeApostas(1));
	}

	/**
	 * Teste que verifica o uso do método exibeApostas() de um cenário vazio.
	 */
	@Test
	public void testExibeApostasCenarioVazio() {
		assertEquals("", sistema.exibeApostas(1));
	}

	/**
	 * Teste que verifica o uso do método exibeApostas() de um cenário com
	 * apostas cadastradas.
	 */
	@Test
	public void testExibeApostasCenario() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);
		sistema.cadastraAposta(1, "Anonimo", 199, "N VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Matheus", 10000, "VAI ACONTECER",
				0.01, 40);
		sistema.cadastraAposta(1, "Livia", 30000, "VAI ACONTECER");

		assertEquals(
				"Francisco Cisco - R$200,00 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$10,00"
						+ System.lineSeparator()
						+ "Anonimo - R$1,99 - N VAI ACONTECER"
						+ System.lineSeparator()
						+ "Matheus - R$100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 1%"
						+ System.lineSeparator()
						+ "Livia - R$300,00 - VAI ACONTECER"
						+ System.lineSeparator(), sistema.exibeApostas(1));

	}

	/**
	 * Teste que verifica o método exibeCenario() passando um cenário
	 * cadastrado.
	 */
	@Test
	public void testExbibeCenario() {
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado",
				sistema.exbibeCenario(1));
	}

	/**
	 * Teste que verifica o método exibeCenario() passando um cenário não
	 * cadastrado.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testExbibeCenarioIvalido() {
		sistema.exbibeCenario(3);
	}

	/**
	 * Teste que verifica o método exibeCenarios()
	 */
	@Test
	public void testExibeCenarios() {
		sistema.cadastraCenario("O resultado do dado será maior que três ",
				1000);
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado"
						+ System.lineSeparator()
						+ "2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado - R$ 10,00"
						+ System.lineSeparator()
						+ "3 - O resultado do dado será maior que três - Nao finalizado - R$ 10,00"
						+ System.lineSeparator(), sistema.exibeCenarios());
	}

	/**
	 * Teste que verifica o método encerraCenario() passando que o cenário
	 * ocorreu.
	 */
	@Test
	public void testEncerraCenarioTrue() {
		sistema.encerraCenario(1, true);
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Finalizado (ocorreu)",
				sistema.exbibeCenario(1));

	}

	/**
	 * Teste que verifica o método encerraCenario() passando que o cenário não
	 * ocorreu.
	 */
	@Test
	public void testEncerraCenarioFalse() {
		sistema.encerraCenario(1, false);
		assertEquals(
				"1 - A maioria irá tirar mais do que 7 na prova! - Finalizado (n ocorreu)",
				sistema.exbibeCenario(1));

	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetCaixaCenario() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(1, false);
		assertEquals(1000, sistema.getCaixaCenario(1));
	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetCaixaCenarioVerdadeiro() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(1, true);
		assertEquals(2000, sistema.getCaixaCenario(1));
	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando um cenário não
	 * finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetCaixaCenarioCenarioNaoFinalizado() {
		sistema.getCaixaCenario(2);
	}

	/**
	 * Teste que verifica o método getTotalRateio() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetTotalRateioCenario() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(1, true);
		assertEquals(38000, sistema.getTotalRateioCenario(1));
	}

	/**
	 * Teste que verifica o método getTotalRateio() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetTotalRateioCenarioFalse() {
		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(1, false);
		assertEquals(19000, sistema.getTotalRateioCenario(1));
	}

	/**
	 * Teste que verifica o método getTotalRateio() passando um cenário não
	 * finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetTotalRateioCenarioCenarioNaoFinalizado() {
		sistema.getTotalRateioCenario(1);
	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetCaixaCenarioBonus() {
		sistema.cadastraAposta(2, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(2, false);
		assertEquals(1000, sistema.getCaixaCenario(2));
	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando parâmetros de
	 * comparação iguais.
	 */
	@Test
	public void testGetCaixaCenarioVerdadeiroBonus() {
		sistema.cadastraAposta(2, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(2, true);
		assertEquals(2000, sistema.getCaixaCenario(2));
	}

	/**
	 * Teste que verifica o método getCaixaCenario() passando um cenário não
	 * finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetCaixaCenarioCenarioBonusNaoFinalizado() {
		sistema.getCaixaCenario(1);
	}

	/**
	 * Teste que verifica o método getTotalRateio() de um cenário com bônus e
	 * passando os parâmetros de comparação iguais.
	 */
	@Test
	public void testGetTotalRateioCenarioBonus() {
		sistema.cadastraAposta(2, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(2, true);
		assertEquals(39000, sistema.getTotalRateioCenario(2));
	}

	/**
	 * Teste que verifica o método getTotalRateio() de um cenário com bônus e
	 * passando os parâmetros de comparação iguais.
	 */
	@Test
	public void testGetTotalRateioCenarioBonusFalse() {
		sistema.cadastraAposta(2, "Francisco Cisco", 20000, "VAI ACONTECER");
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.01, 50);
		sistema.cadastraApostaSegura(2, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 10000, 50);
		sistema.encerraCenario(2, false);
		assertEquals(20000, sistema.getTotalRateioCenario(2));
	}

	/**
	 * Teste que verifica o método getTotalRateio() de um cenário com bônus
	 * passando um cenário não finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testGetTotalRateioCenarioCenarioBonusNaoFinalizado() {
		sistema.getTotalRateioCenario(2);
	}

	/**
	 * Teste que verifica o método alteraApostaSeguroValor(), alterando a aposta
	 * assegurada por taxa para uma aposta assegurada por valor.
	 */
	@Test
	public void testAlteraApostaSeguraValor() {

		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 1000, 50);

		sistema.alteraApostaSeguraTaxa(1, 1, 0.05);
		assertEquals(
				"Francisco Cisco - R$200,00 - N VAI ACONTECER - ASSEGURADA (TAXA) - 5%"
						+ System.lineSeparator(), sistema.exibeApostas(1));
	}

	/**
	 * Teste que verifica o método alteraApostaSeguroTaxa(), alterando a aposta
	 * assegurada por valor para uma aposta assegurada por taxa.
	 */
	@Test
	public void testAlteraApostaSeguraTaxa() {
		sistema.cadastraApostaSegura(1, "Francisco Cisco", 20000,
				"N VAI ACONTECER", 0.5, 50);

		sistema.alteraApostaSeguraValor(1, 1, 10000);
		assertEquals(
				"Francisco Cisco - R$200,00 - N VAI ACONTECER - ASSEGURADA (VALOR) - R$100,00"
						+ System.lineSeparator(), sistema.exibeApostas(1));
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar alterar uma aposta não
	 * assegurada.
	 */
	@Test(expected = ClassCastException.class)
	public void testAlteraApostaSeguraApostaComum() {

		sistema.cadastraAposta(1, "Francisco Cisco", 20000, "N VAI ACONTECER");

		sistema.alteraApostaSeguraTaxa(1, 1, 0.05);
	}

	/**
	 * Teste que verifica o método alteraOrdem(), passando a string cadastro
	 * como parâmetro.
	 */
	@Test
	public void testAlteraOrdemCadastro() {
		sistema.alterarOrdem("cadastro");

	}

	/**
	 * Teste que verifica o método alteraOrdem(), passando a string nome como
	 * parâmetro.
	 */

	@Test
	public void testAlteraOrdemNome() {
		sistema.alterarOrdem("nome");

	}

	/**
	 * Teste que verifica o método alteraOrdem(), passando a string apostas como
	 * parâmetro.
	 */

	@Test
	public void testAlteraOrdemQuantidadeDeApostas() {
		sistema.alterarOrdem("apostas");

	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * alteraOrdem() passando um parâmetro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemVazio() {
		sistema.alterarOrdem("");

	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * alteraOrdem() passando um parâmetro nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemNulo() {
		sistema.alterarOrdem(null);

	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * alteraOrdem() passando um parâmetro inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testAlteraOrdemInvalido() {
		sistema.alterarOrdem("Cadastro");

	}

	/**
	 * Teste que verifica o método exibirCenarioOrdenado(), passando a ordem de
	 * cadastro como parâmetro.
	 */
	@Test
	public void testExibirCenarioOrdenado() {
		sistema.cadastraCenario("O aluno Viktor Borgino vai pagar PLP");
		sistema.cadastraCenario("Hoje vai fazer -30 graus em Campina");
		sistema.cadastraCenario("Todos os alunos comparecerao a aula de LP2 nessa terca");
		sistema.cadastraAposta(1, "Matheus Melanio", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(1, "Viktor Borgino", 10000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Mandela Ursula", 100000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Davson Sadman", 150000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Taigo Leonel", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(3, "Viktor Borgino", 20000, "VAI ACONTECER");

		sistema.alterarOrdem("cadastro");
		assertEquals(sistema.exibirCenarioOrdenado(1),
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(2),
				"2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado - R$ 10,00");
		assertEquals(sistema.exibirCenarioOrdenado(3),
				"3 - O aluno Viktor Borgino vai pagar PLP - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(4),
				"4 - Hoje vai fazer -30 graus em Campina - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(5),
				"5 - Todos os alunos comparecerao a aula de LP2 nessa terca - Nao finalizado");

	}

	/**
	 * Teste que verifica o método exibirCenarioOrdenado(), passando a ordem de
	 * nome como parâmetro.
	 */
	@Test
	public void testExibirCenarioOrdenadoNome() {
		sistema.cadastraCenario("O aluno Viktor Borgino vai pagar PLP");
		sistema.cadastraCenario("Hoje vai fazer -30 graus em Campina");
		sistema.cadastraCenario("Todos os alunos comparecerao a aula de LP2 nessa terca");
		sistema.cadastraAposta(1, "Matheus Melanio", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(1, "Viktor Borgino", 10000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Mandela Ursula", 100000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Davson Sadman", 150000, "VAI ACONTECER");
		sistema.cadastraAposta(2, "Taigo Leonel", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(3, "Viktor Borgino", 20000, "VAI ACONTECER");

		sistema.alterarOrdem("nome");
		assertEquals(sistema.exibirCenarioOrdenado(1),
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(2),
				"2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado - R$ 10,00");
		assertEquals(sistema.exibirCenarioOrdenado(4),
				"3 - O aluno Viktor Borgino vai pagar PLP - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(3),
				"4 - Hoje vai fazer -30 graus em Campina - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(5),
				"5 - Todos os alunos comparecerao a aula de LP2 nessa terca - Nao finalizado");

	}

	/**
	 * Teste que verifica o método exibirCenarioOrdenado(), passando a ordem de
	 * quantidade de apostas como parâmetro.
	 */
	@Test
	public void testExibirCenarioOrdenadoApostas() {
		sistema.cadastraCenario("O aluno Viktor Borgino vai pagar PLP");
		sistema.cadastraCenario("Hoje vai fazer -30 graus em Campina");
		sistema.cadastraCenario("Todos os alunos comparecerao a aula de LP2 nessa terca");
		sistema.cadastraAposta(1, "Matheus Melanio", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(1, "Viktor Borgino", 10000, "VAI ACONTECER");
		sistema.cadastraAposta(4, "Mandela Ursula", 100000, "VAI ACONTECER");
		sistema.cadastraAposta(4, "Davson Sadman", 150000, "VAI ACONTECER");
		sistema.cadastraAposta(4, "Taigo Leonel", 10000, "N VAI ACONTECER");
		sistema.cadastraAposta(5, "Viktor Borgino", 20000, "VAI ACONTECER");

		sistema.alterarOrdem("apostas");

		assertEquals(sistema.exibirCenarioOrdenado(1),
				"4 - Hoje vai fazer -30 graus em Campina - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(2),
				"1 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(3),
				"5 - Todos os alunos comparecerao a aula de LP2 nessa terca - Nao finalizado");
		assertEquals(sistema.exibirCenarioOrdenado(4),
				"2 - A maioria irá tirar mais do que 7 na prova! - Nao finalizado - R$ 10,00");
		assertEquals(sistema.exibirCenarioOrdenado(5),
				"3 - O aluno Viktor Borgino vai pagar PLP - Nao finalizado");

	}
}
