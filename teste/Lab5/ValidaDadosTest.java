package Lab5;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe de testes logicos da classe ValidaDados.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ValidaDadosTest {

	/**
	 * Teste que verifica o uso do método validaNull() passando um parâmetro
	 * válido.
	 */
	@Test
	public void testValidaNullCampoValido() {
		ValidaDados.validaNull("Teste", "");

	}

	/**
	 * Teste que verifica se gera uma execação ao usar o método validaNull() com
	 * parâmetro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNullCampoVazio() {
		ValidaDados.validaNull("", "");

	}

	/**
	 * Teste que verifica se gera uma execação ao usar o método validaNull() com
	 * parâmetro nulo
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaNullCampoNulo() {
		ValidaDados.validaNull(null, "");

	}

	/**
	 * Teste que verifica o uso do método validaZeroOuNegativo()com um valor
	 * válido.
	 */
	@Test
	public void testValidaZeroOuNegativoValorCampoValido() {
		ValidaDados.validaZeroOuNegativo(10, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método
	 * validaZeroOuNegativo() passando um valor zero.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValidaZeroOuNegativoValorCampoZero() {
		ValidaDados.validaZeroOuNegativo(0, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método
	 * validaZeroOuNegativo() passando um valor negativo.
	 */
	@Test(expected = NumberFormatException.class)
	public void testValidaZeroOuNegativoValorCampoNegativo() {
		ValidaDados.validaZeroOuNegativo(-10, "");
	}

	/**
	 * Teste que verifica o uso do método validaNegativo() passando um valor
	 * válido.
	 */
	@Test
	public void testValidaValorNegativoCampoValido() {
		ValidaDados.validaValorNegativo(10, "");
	}

	/**
	 * Teste que verifica o uso do método validaNegativo() passando o valor
	 * zero.
	 */
	@Test
	public void testValidaValorNegativoCampoZero() {
		ValidaDados.validaValorNegativo(0, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaNegativo()
	 * passando um valor negativo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaValorNegativoCampoNegativo() {
		ValidaDados.validaValorNegativo(-10, "");

	}

	/**
	 * Teste que verifica o uso do método validaPrevisao() passando uma previsão
	 * válida.
	 */
	@Test
	public void testValidaPrevisaoValidaVaiAcontecer() {
		ValidaDados.validaPrevisao("VAI ACONTECER", "");

	}

	/**
	 * Teste que verifica o uso do método validaPrevisao() passando uma previsão
	 * válida.
	 */
	@Test
	public void testValidaPrevisaoValidaVaiNaoAcontecer() {
		ValidaDados.validaPrevisao("N VAI ACONTECER", "");

	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaPrevisao()
	 * passando uma previsão inválida.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaPrevisaoInvalida() {
		ValidaDados.validaPrevisao("ACONTECER", "");
	}

	/**
	 * Teste que verifica o uso do método validaEstado() passando um estado não
	 * finalizado.
	 */
	@Test
	public void testValidaEstadoValido() {
		ValidaDados.validaEstado("Nao finalizado", "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaEstado()
	 * passando uma estado finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testValidaEstadoInvalidoOcorreu() {
		ValidaDados.validaEstado("Finalizado (ocorreu)", "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaEstado()
	 * passando uma estado finalizado.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testValidaEstadoInvalidoNaoOcorreu() {
		ValidaDados.validaEstado("Finalizado (n ocorreu)", "");
	}

	/**
	 * Teste que verifica se o uso do método validaCenario() passando um índice
	 * menor que o tamanho da lista.
	 */
	@Test
	public void testValidaCenario() {
		ValidaDados.validaCenario(1, 2, "");
	}

	/**
	 * Teste que verifica se o uso do método validaCenario() passando um índice
	 * igual que o tamanho da lista.
	 */
	@Test
	public void testValidaCenarioLimite() {
		ValidaDados.validaCenario(1, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaCenario()
	 * passando um índice maior que o tamanho da lista.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaCenarioNaoCadastrado() {
		ValidaDados.validaCenario(2, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaCenario()
	 * passando um índice igual a zero.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaCenarioZero() {
		ValidaDados.validaCenario(0, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaCenario()
	 * passando um índice negativo.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaCenarioNegativo() {
		ValidaDados.validaCenario(-1, 1, "");
	}

	/**
	 * Teste que verifica se o uso do método validaAposta() passando um índice
	 * menor que o tamanho da lista.
	 */
	@Test
	public void testValidaAposta() {
		ValidaDados.validaAposta(1, 2, "");
	}

	/**
	 * Teste que verifica se o uso do método validaAposta() passando um índice
	 * igual que o tamanho da lista.
	 */
	@Test
	public void testValidaApostaLimite() {
		ValidaDados.validaAposta(1, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaAposta()
	 * passando um índice maior que o tamanho da lista.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaApostaNaoCadastrada() {
		ValidaDados.validaAposta(2, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaAposta()
	 * passando um índice zero.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaApostaZero() {
		ValidaDados.validaAposta(0, 1, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaAposta()
	 * passando um índice negativo.
	 */
	@Test(expected = IndexOutOfBoundsException.class)
	public void testValidaApostaNegativo() {
		ValidaDados.validaAposta(-1, 1, "");
	}

	/**
	 * Teste que verifica o uso do método validaCaixa(), passando um valor de
	 * bônus menor que o valor do caixa.
	 */
	@Test
	public void testValidaCaixa() {
		ValidaDados.validaCaixa(20000, 1000, "");
	}

	/**
	 * Teste que verifica o uso do método validaCaixa(), passando um valor de
	 * bônus igual ao valor do caixa.
	 */
	@Test
	public void testValidaCaixaZero() {
		ValidaDados.validaCaixa(20000, 20000, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao usar o método validaCaixa()
	 * passando um valor de bônus maior que o valor do caixa.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testValidaCaixaNegativo() {
		ValidaDados.validaCaixa(20000, 30000, "");
	}

	/**
	 * Teste que verifica o uso do método validaApostaSegura() passando uma
	 * aposta assegurada.
	 */
	@Test
	public void testValidaApostaSegura() {
		ApostaSegura aposta = new ApostaSegura(1, "Teste", 100,
				"VAI ACONTECER", 100, 100);
		ValidaDados.validaApostaSegura(aposta, "");
	}

	/**
	 * Teste que verifica se gera uma execeção ao usar o método
	 * validaApostaSegura() passando uma aposta comum.
	 */
	@Test(expected = ClassCastException.class)
	public void testValidaApostaSeguraApostaComum() {
		Aposta aposta = new Aposta(1, "Teste", 100, "N VAI ACONTECER");
		ValidaDados.validaApostaSegura(aposta, "");
	}

	/**
	 * Teste que verifica o método validaOrdem(), passando a string cadastro
	 * como parâmetro.
	 */
	@Test
	public void testValidaOrdemCadastro() {
		ValidaDados.validaOrdem("cadastro", "");
	}

	/**
	 * Teste que verifica o método validaOrdem(), passando a nome cadastro como
	 * parâmetro.
	 */
	@Test
	public void testValidaOrdemNome() {
		ValidaDados.validaOrdem("nome", "");
	}

	/**
	 * Teste que verifica o método validaOrdem(), passando a apostas cadastro
	 * como parâmetro.
	 */
	@Test
	public void testValidaOrdemApostas() {
		ValidaDados.validaOrdem("apostas", "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * validaOrdem() passando um parâmetro vazio.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaOrdemVazio() {
		ValidaDados.validaNull("", "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * validaOrdem() passando um parâmetro nulo.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaOrdemNulo() {
		ValidaDados.validaNull(null, "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * validaOrdem() passando um parâmetro inválido.
	 */
	@Test(expected = IllegalArgumentException.class)
	public void testValidaOrdemInvalido() {
		ValidaDados.validaOrdem("Cadastro", "");
	}

	/**
	 * Teste que verifica se gera uma exceção ao tentar usar o método
	 * validaEstadoNaoFinalizado() passando um parâmetro inválido.
	 */
	@Test(expected = UnsupportedOperationException.class)
	public void testValidaEstadoNaoFinalizado() {
		ValidaDados.validaEstadoNaoFinalizado("Nao finalizado", "");
	}

	/**
	 * Teste que verifica o método validaEstadoNaoFinalizado() passando um
	 * parâmetro válido.
	 */
	@Test
	public void testValidaEstadoNaoFinalizadoDiferente() {
		ValidaDados.validaEstadoNaoFinalizado("Finalizado (ocoreu)", "");
	}
}
