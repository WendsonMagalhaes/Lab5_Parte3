package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe Valor.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ValorTest {
	/**
	 * Valor assegurado
	 */
	private Valor valor;

	/**
	 * Método que cria o valor que ser usado durantes os testes unitários.
	 */
	@Before
	public void preparaValor() {

		this.valor = new Valor(10000, 50);
	}

	/**
	 * Teste que verifica o método calculaValor() para o tipo Valor com
	 * parâmetros iguais.
	 */
	@Test
	public void testCalculaValor() {
		assertEquals(10000, valor.calculaValor(100), 0.0001);
	}

	/**
	 * Teste que verifica o método calculaValor() para o tipo Valor com
	 * parâmetros diferentes.
	 */
	@Test
	public void testCalculaValorDiferente() {
		assertNotEquals(1000, valor.calculaValor(100), 0.0001);
	}

	/**
	 * Teste que verifica se cria um valor passando parâmetros válidos.
	 */
	@Test
	public void testValor() {
		new Valor(10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um valor com valor
	 * assegurado zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValorValorSeguroZero() {
		new Valor(0, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um valor com valor
	 * assegurado negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValorValorSeguroNegativo() {
		new Valor(-10000, 50);
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um valor com custo zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValorCustoZero() {
		new Valor(10000, 0);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar criar um valor com custo negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValorcustoNegativo() {
		new Valor(10000, -50);
	}
	/**
	 * Teste que verifica o método toString de um Valor
	 */
	@Test
	public void testToString() {
		assertEquals("ASSEGURADA (VALOR) - R$100,00", valor.toString());
	}
	/**
	 * Teste que verifica o método getCusto() do tipo valor com os parâmetros iguais.
	 */
	@Test
	public void testGetCusto() {
		assertEquals(50, valor.getCusto());
	}
	/**
	 * Teste que verifica o método getCusto() do tipo valor com os parâmetros diferentes.
	 */
	@Test
	public void testGetCustoDiferentes() {
		assertNotEquals(0, valor.getCusto());
	}

}
