package Lab5;

import java.util.Comparator;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação da classe CompareCenario, reponsavel por comparar os cenários
 * atraves no número de identificação.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class ComparaCenario implements Comparator<Cenario> {
	/**
	 * Método que compara dois cenários pelo número de identificação.
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		return c1.getCenario() - c2.getCenario();
	}

}
