package Lab5;

public interface Tipo {

	/**
	 * Método que calcula o valor que será repassado caso a aposta seja
	 * perdedora.
	 * 
	 * @param valor
	 *            valor da aposta feita.
	 * @return double calcula o valor que será repassado caso a posta seja
	 *         perdedora.
	 */
	
	public double calculaValor(double valor);
	/**
	 * Método que retorna o custo da aposta assegurada
	 * 
	 * @return int - valor do custo.
	 */
	public int getCusto();

}