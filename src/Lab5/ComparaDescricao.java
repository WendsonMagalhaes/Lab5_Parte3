package Lab5;

import java.util.Comparator;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação da classe CompareCenario, reponsavel por comparar os cenários
 * atraves da descrição do cenário.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ComparaDescricao implements Comparator<Cenario>{
	/**
	 * Método que compara dois cenários pela descrição do cenário.
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if(c1.getDescricao().compareTo(c2.getDescricao()) == 0){
			return c1.getCenario() - c2.getCenario();
		}
		return c1.getDescricao().compareTo(c2.getDescricao());
	}
}
