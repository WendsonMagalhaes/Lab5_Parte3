package Lab5;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe Taxa.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class TaxaTest {
	/**
	 * Taxa percentual do valor assegurado.
	 */
	private Taxa taxa;
	/**
	 * Método que cria a taxa que sera usada durante os testes unitários.
	 */
	@Before
	public void preparaTaxa() {
		
		this.taxa = new Taxa(0.05,50);
	} 
	/**
	 * Teste que verifica o método calculaValor() para o tipo Taxa  com parâmetros iguais.
	 */
	@Test
	public void testCalculaValor() {
		assertEquals(500,taxa.calculaValor(10000),0.0001);
	}
	/**
	 * Teste que verifica o método calculaValor() para o tipo Taxa com parâmetros diferentes.
	 */
	@Test
	public void testCalculaValorDiferentes() {
		assertNotEquals(50,taxa.calculaValor(10000),0.0001);
	}
	/**
	 * Teste que verifica se cria uma taxa passando parâmetros válidos.
	 */
	@Test
	public void testTaxa() {
		new Taxa(0.05,50);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma taxa com taxa zero.
	 */
	@Test(expected =NumberFormatException.class)
	public void testTaxaTaxaZero() {
		new Taxa(0,50);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma taxa com taxa negativa.
	 */
	@Test(expected =NumberFormatException.class)
	public void testTaxaTaxaNegativa() {
		new Taxa(-0.05,50);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma taxa com custo zero.
	 */
	@Test(expected =NumberFormatException.class)
	public void testTaxaCustoZero() {
		new Taxa(0.05,0);
	}
	/**
	 * Teste que verifica se gera uma exceção ao tentar criar uma taxa com custo negativo.
	 */
	@Test(expected =NumberFormatException.class)
	public void testTaxaCustoNegativo() {
		new Taxa(0.05,-50);
	}
	/**
	 * Teste que verifica o método getCusto() com parâmetros iguais.
	 */
	@Test
	public void testGetCusto(){
		assertEquals(50,taxa.getCusto());
	}
	/**
	 * Teste que verifica o método getCusto() com parâmetros diferentes.
	 */
	@Test
	public void testGetTaxaDiferentes(){
		assertNotEquals(10,taxa.getCusto());
	}
	/**
	 * Teste que verifica o método toString da taxa.
	 */
	@Test
	public void testToString() {
		assertEquals("ASSEGURADA (TAXA) - 5%",taxa.toString());
	}

}
