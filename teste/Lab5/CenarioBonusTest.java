package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe CenarioBonus.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class CenarioBonusTest {

	/**
	 * Cenário Bônus
	 */
	private CenarioBonus cenario;

	/**
	 * Método que cria o cenário bônus que será usado durante os teste
	 * unitários.
	 */
	@Before
	public void preparaCenarioBonus() {

		this.cenario = new CenarioBonus(1,
				"O resultado do dado será maior que três", 10000);
	}

	/**
	 * Teste que verifica o método totalRateioCenario() cenário finalizado.
	 */
	@Test
	public void testTotalRateioCenario() {
		cenario.encerraCenario(true);
		assertEquals(10000, cenario.totalRateioCenario(0.001));
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * totalRateioCenario() em um cenário não finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testTotalRateioCenarioCenarioNaoFinalizado() {
		assertEquals(10000, cenario.totalRateioCenario(0.001));
	}

	/**
	 * Teste que verifica o método toString de um cenário.
	 */
	@Test
	public void testToString() {
		assertEquals(
				"1 - O resultado do dado será maior que três - Nao finalizado - R$ 100,00",
				cenario.toString());
	}

	/**
	 * Teste que verifica se cadastra um cenário com boônus, passando todos os
	 * parâmetros válidos.
	 */
	@Test
	public void testCenarioBonus() {
		new CenarioBonus(1, "O resultado do dado será maior que três", 10000);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com o número de identificação zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioBonusPosicaoZero() {
		new CenarioBonus(0, "O resultado do dado será maior que três", 10000);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com o número de identificação negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioBonusPosicaoNegativa() {
		new CenarioBonus(-1, "O resultado do dado será maior que três", 10000);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com a descrição vazia.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusDescircaoVazia() {
		new CenarioBonus(1, "", 10000);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com a descrição nula.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testCenarioBonusDescircaoNula() {
		new CenarioBonus(1, null, 10000);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com o valor do bônus zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioBonusBonusZero() {
		new CenarioBonus(1, "O resultado do dado será maior que três", 0);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar cadastrar um cenário com
	 * bônus com o valor do bônus negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testCenarioBonusBonusNegativo() {
		new CenarioBonus(1, "O resultado do dado será maior que três", -10000);
	}
	/**
	 * Teset que verifica o método getBonus() com parâmetros iguais.
	 */
	@Test
	public void testGetBonus() {
		assertEquals(10000, cenario.getBonus());
	}
	/**
	 * Teset que verifica o método getBonus() com parâmetros diferentes..
	 */
	@Test
	public void testGetBonusDiferente() {
		assertNotEquals(0, cenario.getBonus());
	}

}
