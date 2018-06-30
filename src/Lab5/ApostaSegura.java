package Lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação de uma ApostaSegura.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class ApostaSegura extends Aposta {
	/**
	 * Custo da aposta assegurada
	 */
	private int custo;
	/**
	 * Valor assegurado.
	 */
	private int valorSeguro;
	/**
	 * percentual do valor que será assegurado.
	 */
	private double taxa;
	/**
	 * Tipo da aposta assegurada (Valor ou Taxa).
	 */
	private Tipo tipo;

	/**
	 * Método que constrói o objeto ApostaSegura do tipo valor, definindo o número de
	 * identificação da aposta, nome do apostador, o valor da aposta, a previsão
	 * da aposta, o valor a ser assegurado e o custo da aposta.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 * @param valorSeguro
	 *            valor a ser assegurado.
	 * @param custo
	 *            custo da aposta.
	 */
	public ApostaSegura(int idAposta, String apostador, int valor,
			String previsao, int valorSeguro, int custo) {
		super(idAposta, apostador, valor, previsao);
		
		ValidaDados
				.validaNull(
						apostador,
						"Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(
						valor,
						"Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(
						previsao,
						"Previsao nao pode ser vazia ou nula");
		ValidaDados
				.validaPrevisao(previsao,
						"Previsao invalida");
	
		ValidaDados
		.validaZeroOuNegativo(
				idAposta,
				"Numero de identificação invalido");

		
		this.tipo = new Valor(valorSeguro, custo);

	}
	/**
	 * Método que constrói o objeto ApostaSegura do tipo taxa, definindo o número de
	 * identificação da aposta, nome do apostador, o valor da aposta, a previsão
	 * da aposta, a taxa do valor que será assegurado e o custo da aposta.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 * @param taxa
	 *            percentual do valor a ser assegurado.
	 * @param custo
	 *            custo da aposta.
	 */
	public ApostaSegura(int idAposta, String apostador, int valor,
			String previsao, double taxa, int custo) {
		super(idAposta, apostador, valor, previsao);
		ValidaDados
				.validaNull(
						apostador,
						"Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(
						valor,
						"Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(
						previsao,
						"Previsao nao pode ser vazia ou nula");
		ValidaDados
				.validaPrevisao(previsao,
						"Previsao invalida");
		ValidaDados
		.validaZeroOuNegativo(
				idAposta,
				"Numero de identificação invalido");

	
		this.tipo = new Taxa(taxa, custo);

	}
	
	/**
	 * Método que calcula o valor que será repassado caso a aposta seja perdedora.
	 * @return double - valor a ser repassado caso a aposta seja perdedora.
	 */
	public double calculaValor() {
		return tipo.calculaValor(this.valor);
	}
	/**
	 * Método que verifica se uma aposta foi vencedera ou perdedora, no caso da
	 * caso a aposta seja vencedora retorna o valor 1 que será adicionado na
	 * quantidade de ganhadores, caso seja perdedora retorna o valor que sera
	 * repassado para o rateio e o valor assegurado.
	 * 
	 * @return double[] - valores - [valor da aposta caso seja perdedora, valor assegurado da aposta caso seja perdedora, 1 caso seja ganhadora].
	 */
	@Override
	public double[] verificaAposta(String estado){
		double [] valores = new double[3];
		if(estado.equals("Finalizado (ocorreu)") && this.previsao.equals("VAI ACONTECER")){
			valores[0]=0;
			valores[1]=0;
			valores[2] = 1;
			return valores;
		}
		else if(estado.equals("Finalizado (n ocorreu)") && this.previsao.equals("N VAI ACONTECER")){
			valores[0]=0;
			valores[1]=0;
			valores[2] = 1;			
			return valores;
		}
		else{
			valores[0] = this.valor;
			valores[1] = this.calculaValor();
			valores[2] = 0;
 			return valores;	
		}
		
	}
	/**
	 * Método que retorna o valor do custo da aposta.
	 * @return Int - custo.
	 */
	public int getCusto() {
		return this.tipo.getCusto();
	}
	/**
	 * Método que retorna uma String com a representação da aposta. A
	 * representação segue o formato "APOSTADOR - R$ VALOR - PREVISAO - ASSEGURADA (TIPO) - VALOR".
	 * Ex.“Matheus Gaudencio - R$100,00 - VAI ACONTECER - ASSEGURADA (VALOR) - R$ 200,00”
	 *	  “Matheus Gaudencio - R$100,00 - VAI ACONTECER - ASSEGURADA (TAXA) - 5%”
	 * 
	 * @return String - representação em String da aposta.
	 */
	@Override
	public String toString() {

		double valor = this.valor / 100.00;
		BigDecimal valorRS = new BigDecimal(valor).setScale(2,
				RoundingMode.HALF_EVEN);
		String valorString = String.valueOf(valorRS).replace(".", ",");

		return this.apostador + " - R$" + valorString + " - " + this.previsao + " - "
				+ this.tipo.toString();
	}

	/**
	 * Método que retorna um Int que representa a posição do objeto na memória,
	 * essa posição é referente ao numero de identificação da aposta.
	 * 
	 * @return Int - hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAposta;
		return result;
	}

	/**
	 * Método que retorna um boolean que indica se um objeto é igual a uma
	 * aposta, essa comparação é feita pelo numero de identificação, duas
	 * apostas são iguais se seus numeros de identificação são iguais.
	 * 
	 * @return boolean - "true" ou "false".
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ApostaSegura other = (ApostaSegura) obj;
		if (idAposta != other.idAposta)
			return false;
		return true;
	}

	
}
