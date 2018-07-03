package Lab5;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Represetação de uma Taxa.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class Taxa implements Tipo {
	/**
	 * Percentual do valor que será assegurado
	 */
	private double taxa;
	

	/**
	 * Método que costrói o objeto Taxa, definindo seu custo e sua taxa.
	 * 
	 * @param taxa
	 *            percentual do valor que será assegurado.
	 */
	public Taxa(double taxa) {
		ValidaDados
		.validaZeroOuNegativo(
				taxa,
				"Erro no cadastro de aposta assegurada por taxa: Taxa nao pode ser menor ou igual a zero");
		
		this.taxa = taxa;
		
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
	@Override
	public double calculaValor(double valor) {
		return  (int) (valor * this.taxa);
	}
	

	/**
	 * Método que retorna a representação em String da Taxa. A representação
	 * segue o formato "ASSEGURADA (TAXA) - TAXA%". Ex."ASSEGURADA (TAXA) - 5%"
	 * 
	 */
	@Override
	public String toString() {
		return "ASSEGURADA (TAXA) - " + (int) (this.taxa * 100) + "%";
	}
	
}
