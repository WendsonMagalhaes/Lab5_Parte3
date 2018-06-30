package Lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Represetação de um Valor.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class Valor implements Tipo {

	private int valorSeguro;
	private int custo;


	/**
	 * Método que constrói o objeto Valor, definindo o valor a ser assegurado e
	 * o custo da aposta.
	 * 
	 * @param valorSeguro
	 *            valor assegurado.
	 * @param custo
	 *            custo da aposta.
	 */
	
	public Valor(int valorSeguro, int custo) {
		
		ValidaDados
		.validaZeroOuNegativo(
				custo,
				"Erro no cadastro de aposta assegurada por valor: Custo nao pode ser menor ou igual a zero");
		ValidaDados
		.validaZeroOuNegativo(
				valorSeguro,
				"Erro no cadastro de aposta assegurada por valor: Valor Assegurado nao pode ser menor ou igual a zero");
		
		this.valorSeguro = valorSeguro;
		this.custo = custo;
	}
	

	/**
	 * Método que calcula o valor que será repassado caso a aposta seja
	 * perdedora.
	 * 
	 * @param valor
	 *            valor da aposta feita.
	 * @return double calcula o valor que será repassado caso a posta seja
	 *         perdedora.
	 */
	
	public double calculaValor(double valor) {
		return this.valorSeguro;
	}
	/**
	 * Método que retorna o custo da aposta assegurada
	 * 
	 * @return int - valor do custo.
	 */
	@Override
	public int getCusto() {
		
		return this.custo;
	}

	/**
	 * Método que retorna a representação em String do Valor. A representação
	 * segue o formato "ASSEGURADA (VALOR) - R$VALOR".
	 * Ex."ASSEGURADA (VALOR) - R$200,00"
	 * 
	 */
	@Override
	public String toString() {

		double valor = this.valorSeguro / 100.00;
		BigDecimal valorRS = new BigDecimal(valor).setScale(2,
				RoundingMode.HALF_EVEN);
		String valorString = String.valueOf(valorRS).replace(".", ",");

		return "ASSEGURADA (VALOR) - R$" + valorString;
	}

	

}
