package Lab5;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Classe responavel pela validação dos dados..
 * 
 * @author Wendson Magalhães - 117210424
 */
public class ValidaDados {

	/**
	 * Método que cria o objeto validador de dados.
	 */
	public ValidaDados() {

	}

	/**
	 * Método que verifica se um objeto é nulo ou vazio.
	 * 
	 * @param obj
	 *            objeto a ser válidado
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaNull(Object obj, String mensagem) {
		if (obj == null || ((String) obj).trim().equals("")) {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Método que verifica se um valor é menor ou igual a zero.
	 * 
	 * @param valor
	 *            valor a ser válidado.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaZeroOuNegativo(double valor, String mensagem) {
		if (valor <= 0) {
			throw new NumberFormatException(mensagem);
		}
	}

	/**
	 * Método que verifica se um valor é menor que zero.
	 * 
	 * @param valor
	 *            valor a ser válidado.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaValorNegativo(double valor, String mensagem) {
		if (valor < 0) {
			throw new NumberFormatException(mensagem);
		}
	}

	/**
	 * Método que verifica se uma previsão é inválida.
	 * 
	 * @param previsao
	 *            previsão a ser válidada
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaPrevisao(String previsao, String mensagem) {
		if (previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER")) {
		} else {
			throw new IllegalArgumentException(mensagem);
		}
	}

	/**
	 * Método que verifica se o estado de um cénario foi finalizado ou não.
	 * 
	 * @param string
	 *            estado a ser válidado.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaEstado(String string, String mensagem) {

		if (string.equals("Finalizado (n ocorreu)") || string.equals("Finalizado (ocorreu)")) {
			throw new UnsupportedOperationException(mensagem);
		}
	}
	/**
	 * Método que verifica se o estado de um cénario é Nao finalizado.
	 * 
	 * @param string
	 *            estado a ser válidado.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaEstadoNaoFinalizado(String string,String mensagem){
		if (string.equals("Nao finalizado")) {
			throw new UnsupportedOperationException(mensagem);
		}
	}
	/**
	 * Método que verifica se um cénario foi cadastrado.
	 * 
	 * @param indice
	 *            número de identificação do cénario.
	 * @param tamanho
	 *            tamanho da lista de todos os cénarios cadastrados.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaCenario(int indice,int tamanho, String mensagem) {

		
		if (indice <= 0 || indice > tamanho) {
			throw new IndexOutOfBoundsException(mensagem);
		}

	}

	/**
	 * Método que verifica se uma aposta foi cadastrada.
	 * 
	 * @param indice
	 *            número de identificação da aposta.
	 * @param tamanho
	 *            tamanho da lista de todas as apostas cadastradas.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaAposta(int indice, int tamanho, String mensagem) {

		if (indice <= 0 || indice > tamanho) {
			throw new IndexOutOfBoundsException(mensagem);
		}
	}

	/**
	 * Método que valida se um cenário com bônus pode ser cadastrado sem deixar o
	 * valor da caixa negativo.
	 * 
	 * @param caixa
	 *            valor do caixa do sistema.
	 * @param bonus
	 *            bônus do cenário com bânus
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaCaixa(int caixa, int bonus, String mensagem) {
		if (caixa - bonus < 0) {
			throw new UnsupportedOperationException(mensagem);
		}
	}

	/**
	 * Método que valida se uma aposta é do tipo segura.
	 * 
	 * @param aposta
	 *            aposta a ser verificada.
	 * @param mensagem
	 *            mensagem apresentada ao usuário.
	 */
	public static void validaApostaSegura(Aposta aposta, String mensagem) {
		if (!(aposta instanceof ApostaSegura)) {
			throw new ClassCastException(mensagem);
		}
	}
	/**
	 * Método que valida  se uma ordem é inválida.
	 * @param ordem ordem a ser verificada
	 * @param mensagem mensagem apresentada ao usuário.
	 */
	public static void validaOrdem(String ordem, String mensagem) {
		if (ordem.equals("cadastro") || ordem.equals("nome")||ordem.equals("apostas")) {
		}
		else{
			throw new IllegalArgumentException(mensagem);
		}
		}
	}

