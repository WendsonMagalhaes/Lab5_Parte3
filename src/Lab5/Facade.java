package Lab5;

import easyaccept.EasyAccept;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação de uma Facade.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class Facade {

	/**
	 * Controller de cénarios.
	 */
	private ControllerCenarios sistema;

	public static void main(String[] args) {

		args = new String[] { "Lab5.Facade", "acceptance_test/us1_test.txt",
				"acceptance_test/us2_test.txt", "acceptance_test/us3_test.txt",
				"acceptance_test/us4_test.txt", "acceptance_test/us5_test.txt",
				"acceptance_test/us6_test.txt","acceptance_test/us7_test.txt" };
		EasyAccept.main(args);

	}

	/**
	 * Contrói o objeto facade
	 */
	public Facade() {

	}

	/**
	 * Método que inicializa o sistema de apostas.
	 * 
	 * @param caixa
	 *            valor inicial do caixa.
	 * @param taxa
	 *            taxa de porcentagem do valor das apostas perdedoras que serão
	 *            passadas para o caixa.
	 */
	public void inicializa(int caixa, double taxa) {

		sistema = new ControllerCenarios(caixa, taxa);
	}

	/**
	 * Método que cadastra um cénario e retorna um Int representando a posição
	 * que o cenário foi cadastrado na lista de cenários.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * 
	 * @return Int - número de identificação do cénario cadastrado.
	 */
	public int cadastrarCenario(String descricao) {

		return sistema.cadastraCenario(descricao);

	}

	/**
	 * Método que cadastra um cénario com bônus e retorna um Int representando a
	 * posição que o cenário foi cadastrado na lista de cenários.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * @param bonus
	 *            bônus do cenário.
	 * @return Int - número de identificação do cénario cadastrado.
	 */
	public int cadastrarCenario(String descricao, int bonus) {

		return sistema.cadastraCenario(descricao, bonus);

	}

	/**
	 * Método que retorna a representação em String de um cenário. A
	 * representação segue o formato “NUMERAÇÃO - DESCRIÇÃO - ESTADO" ou
	 * “NUMERAÇÃO - DESCRIÇÃO - ESTADO - BÔNUS"
	 * 
	 * Ex. "1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado” ou
	 * "2 - O resultado do dado será maior que três - Não finalizado - R$
	 * 100,00”
	 * 
	 * @return String - representação em String de um cenário.
	 * 
	 */
	public String exibirCenario(int cenario) {
		return sistema.exbibeCenario(cenario);
	}

	/**
	 * Método que retorna uma String com representação de todos os cenário
	 * cadastrados. A representação segue o formato. "NUMERAÇÃO - DESCRIÇÃO -
	 * ESTADO. "NUMERAÇÃO - DESCRIÇÃO - ESTADO. Ex.
	 * 
	 * “1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado” “2 - O
	 * resultado do dado será maior que três - Finalizado - R$ 100,00 (ocorreu)”
	 * 
	 * @return String - representação em String de todos os cenários
	 *         cadastrados.
	 */
	public String exibirCenarios() {
		return sistema.exibeCenarios();
	}

	/**
	 * Método que cadastra uma aposta em um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário em que a aposta será
	 *            cadastrada.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 */
	public void cadastrarAposta(int cenario, String apostador, int valor,
			String previsao) {
		sistema.cadastraAposta(cenario, apostador, valor, previsao);
	}

	/**
	 * Método que cadastra uma aposta segura do tipo valor em um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário em que a aposta será
	 *            cadastrada.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsao da aposta.
	 * @param valorSeguro
	 *            valor que será assegurado.
	 * @param custo
	 *            custo da aposta.
	 * @return Int - número de identificação da aposta.
	 */
	public int cadastrarApostaSeguraValor(int cenario, String apostador,
			int valor, String previsao, int valorSeguro, int custo) {
		return sistema.cadastraApostaSegura(cenario, apostador, valor,
				previsao, valorSeguro, custo);
	}

	/**
	 * Método que cadastra uma aposta segura do tipo valor em um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário em que a aposta será
	 *            cadastrada.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsao da aposta.
	 * @param taxa
	 *            percentual do valor que será assegurado.
	 * @param custo
	 *            custo da aposta.
	 * @return Int - número de identificação da aposta.
	 */
	public int cadastrarApostaSeguraTaxa(int cenario, String apostador,
			int valor, String previsao, double taxaSeguro, int custo) {
		return sistema.cadastraApostaSegura(cenario, apostador, valor,
				previsao, taxaSeguro, custo);

	}

	/**
	 * Método que retorna uma String com a representação das apostas de um
	 * cenário.A representação segue o formato “APOSTADOR - R$ VALOR - PREVISAO”
	 * “NOME - VALOR - PREVISÃO” APOSTADOR - R$ VALOR - PREVISAO - ASSEGURADA
	 * (TIPO) - VALOR
	 * 
	 * Ex. “Francisco Cisco - R$200,00 - N VAI ACONTECER” “Anonimo - R$1,99 - N
	 * VAI ACONTECER - ASSEGURADA (VALOR) - R$100,00” “Matheus Gaudencio - R$100,00 - VAI ACONTECER” “Livia
	 * Maria - R$300,00 - VAI ACONTECER” “Raquel Lopes- R$200,00 - VAI
	 * ACONTECER” “Matheus Gaudencio - R$100,00 - VAI ACONTECER- ASSEGURADA (TAXA) - 5%”
	 * 
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * 
	 * @return String - representação em String de todas as apostas feitas em um
	 *         cenário.
	 */
	public String exibeApostas(int cenario) {
		return sistema.exibeApostas(cenario);
	}

	/**
	 * Método que retorna um Int representando o valor total das apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - valor total das apostas feitas em um cénario.
	 */
	public int valorTotalDeApostas(int cenario) {
		return sistema.valorTotalApostas(cenario);
	}

	/**
	 * Método que retorna um Int representando a quantidade de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - total de apostas feitas em um cénario.
	 */
	public int totalDeApostas(int cenario) {
		return sistema.totalDeApostas(cenario);
	}

	/**
	 * Método que encerra um cenário alterando o estado do cenario para
	 * "Finalizado (ocorreu)" ou "Finalizado (Não ocorreu)"
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param ocorreu
	 *            boolean informado se o cenário ocorreu ou não.
	 */
	public void fecharAposta(int cenario, boolean ocorreu) {
		sistema.encerraCenario(cenario, ocorreu);
	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura taxa para
	 * aposta segura valor.
	 * 
	 * @param cenario número de identificação do cenário.
	 * @param apostaAssegurada número de identificação da aposta
	 * @param valor valor que será assegurado.
	 * @return número de identificação da aposta.
	 */
	public int alterarSeguroValor(int cenario, int apostaAssegurada, int valor) {
		sistema.alteraApostaSeguraValor(cenario, apostaAssegurada, valor);
		return apostaAssegurada;
	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura valor para
	 * aposta segura taxa.
	 * 
	 * @param cenario número de identificação do cenário.
	 * @param apostaAssegurada número de identificação da aposta
	 * @param taxa percentual do valor que será assegurado.
	 * @return número de identificação da aposta.
	 */
	public int alterarSeguroTaxa(int cenario, int apostaAssegurada, double taxa) {
		sistema.alteraApostaSeguraTaxa(cenario, apostaAssegurada, taxa);
		return apostaAssegurada;
	}

	/**
	 * Método que retorna um Int representando o valor que será repassado para o
	 * caixa.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - Valor a ser repassado para o caixa.
	 */
	public int getCaixaCenario(int cenario) {
		return sistema.getCaixaCenario(cenario);
	}

	/**
	 * Método que retorna um Int representando o valor que será rateado com o
	 * ganhadores do cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - Valor total a ser rateado com os ganhadores.
	 */
	public int getTotalRateioCenario(int cenario) {

		return sistema.getTotalRateioCenario(cenario);
	}

	/**
	 * Método que retorna um Int representando valor do caixa.
	 * 
	 * @return Int - valor do caixa.
	 */
	public int getCaixa() {
		return sistema.getCaixa();
	}
	public void alterarOrdem(String ordem){
		sistema.alterarOrdem(ordem);
	}
	public String exibirCenarioOrdenado(int cenario){
		return sistema.exibirCenarioOrdenado(cenario);
	}

}
