package Lab5;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação de um Cenario.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class CenarioBonus extends Cenario {
	/**
	 * Bônus da cenário.
	 */
	private int bonus;

	/**
	 * Método que constrói o objeto CenarioBonus, definindo o número de
	 * identificação do cenário, a descrição do cenário e o bônus do cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param descricao
	 *            descrição do cenário.
	 * @param bonus
	 *            bônus do cenário.
	 */
	public CenarioBonus(int cenario, String descricao, int bonus) {

		super(cenario, descricao);
		ValidaDados.validaZeroOuNegativo(bonus,
				"Erro no cadastro de cenario: Bonus invalido");
		this.bonus = bonus;

	}

	/**
	 * Método que calcula o valor total que sera rateado entre os ganhadores com
	 * o bônus do cenário acrescido.
	 * 
	 * @param taxa
	 *            percentual do valor que será repassado para o caixa.
	 * 
	 * @return Int - Valor total a ser rateado entre os ganhadores.
	 */
	@Override
	public int totalRateioCenario(double taxa) {

		ValidaDados
		.validaEstadoNaoFinalizado(this.getEstado(),
				"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");

		return (int) ((int) (this.calculaResultado()[0] + this.bonus - this
				.calculaResultado()[0] * taxa));

	}

	/**
	 * Método que retorna a representação em String de um cenário. A
	 * representação segue o formato “NUMERAÇÃO - DESCRIÇÃO - ESTADO - BÔNUS”.
	 * 
	 * Ex. "1 - O resultado do dado será maior que três - Nao finalizado - R$ 100,00”
	 * 
	 * @return String - representação em String de um cenário.
	 * 
	 */
	@Override
	public String toString() {

		double valor = this.bonus / 100.00;
		BigDecimal bonus = new BigDecimal(valor).setScale(2,
				RoundingMode.HALF_EVEN);
		String bonusString = String.valueOf(bonus).replace(".", ",");

		return super.toString()
				+ " - R$ " + bonusString;
	}

	/**
	 * Método que retorna o valor do bônus do cenário.
	 * 
	 * @return int - bonus.
	 */
	public int getBonus() {
		return this.bonus;
	}

}
