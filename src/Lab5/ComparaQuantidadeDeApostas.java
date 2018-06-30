package Lab5;

import java.util.Comparator;
/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação da classe CompareQuantidadeDeApostas, reponsavel por comparar os cenários
 * atraves no número de apostas cadastradas.
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ComparaQuantidadeDeApostas implements Comparator<Cenario>{
	/**
	 * Método que compara dois cenários pelo número de apostas cadastradas.
	 */
	@Override
	public int compare(Cenario c1, Cenario c2) {
		if(c2.getQtdApostas() - c1.getQtdApostas() == 0){
			return c1.getCenario() - c2.getCenario();
		}
		return c2.getQtdApostas() - c1.getQtdApostas();
	}

}
