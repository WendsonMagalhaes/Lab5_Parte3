package Lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação de uma Aposta.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class Aposta {

		/**
		 * Nome do apostador.
		 */
		protected String apostador;
		/**
		 * Valor da aposta.
		 */
		protected int valor;
		/**
		 * Previsão da aposta.
		 */
		protected String previsao;
		/**
		 * Número de identificação da aposta.
		 */
		protected int idAposta;
		
		/**
		 * Método que retorna o nome do apostador.
		 * 
		 * @return String - apostador 
		 */
		public String getApostador() {

			return this.apostador;
		}
		/**
		 * Método que retorna o valor da aposta.
		 * 
		 * @return Int - valor
		 */
		public int getValor() {
			return this.valor;
		}
		/**
		 * Método que retorna a previsão da aposta.
		 * 
		 * @return String - previsao
		 */
		public String getPrevisao() {
			return this.previsao;
		}
		/**
		 * Método que retorna o número de identificação da aposta.
		 */
		public int getIdAposta(){
			return this.idAposta;
		}
		
	/**
	 * Método que constrói o objeto ApostaComum, definindo o número de
	 * identificação da aposta, o nome do apostador, o valor da aposta e a
	 * previsão da aposta.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * 
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 */
	public Aposta(int idAposta, String apostador, int valor,
			String previsao) {

		ValidaDados
				.validaNull(apostador,
						"Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(valor,
						"Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(previsao,
						"Previsao nao pode ser vazia ou nula");
		ValidaDados.validaPrevisao(previsao,
				"Previsao invalida");

		ValidaDados
				.validaZeroOuNegativo(
						idAposta,
						"Numero de identificação invalido");

		this.idAposta = idAposta;
		this.apostador = apostador;
		this.valor = valor;
		this.previsao = previsao.toUpperCase();
	}

	/**
	 * Método que verifica se uma aposta foi vencedera ou perdedora, no caso da
	 * caso a aposta seja vencedora retorna o valor 1 que será adicionado na
	 * quantidade de ganhadores caso seja perdedora retorna o valor que sera
	 * repassado para o rateio.
	 * 
	 * @return double[] - valores - [valor da aposta caso seja perdedora, 0, 1
	 *         caso seja ganhadora].
	 */
	
	public double[] verificaAposta(String estado) {
		double[] valores = new double[3];

		if (estado.equals("Finalizado (ocorreu)")
				&& this.previsao.equals("VAI ACONTECER")) {
			valores[0] = 0;
			valores[1] = 0;
			valores[2] = 1;
			return valores;
		} else if (estado.equals("Finalizado (n ocorreu)")
				&& this.previsao.equals("N VAI ACONTECER")) {
			valores[0] = 0;
			valores[1] = 0;
			valores[2] = 1;
			return valores;
		} else {
			valores[0] = this.valor;
			valores[1] = 0;
			valores[2] = 0;
			return valores;
		}

	}

	/**
	 * Método que retorna uma String com a representação da aposta. A
	 * representação segue o formato "APOSTADOR - R$ VALOR - PREVISAO".
	 * Ex."Francisco Cisco - R$200,00 - N VAI ACONTECER".
	 * 
	 * @return String - representação em String da aposta.
	 */
	@Override
	public String toString() {

		double valor = this.valor / 100.00;
		BigDecimal valorRS = new BigDecimal(valor).setScale(2,
				RoundingMode.HALF_EVEN);
		String valorString = String.valueOf(valorRS).replace(".", ",");
		return this.apostador + " - R$" + valorString + " - " + this.previsao;
	}

}
