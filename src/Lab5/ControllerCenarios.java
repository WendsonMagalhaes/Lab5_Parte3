package Lab5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação do Controller de Cenarios, classe responsavel por gerenciar
 * todas as apostas e cenários.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class ControllerCenarios {

	/**
	 * Lista com todos os cenários.
	 */
	private List<Cenario> listaCenarios;
	/**
	 * Valor do caixa.
	 */
	private int caixa;
	/**
	 * Taxa que será retirado do montante dos perdedores.
	 */
	private double taxa;

	/**
	 * Ordem de exibição do sistema de apostas
	 */
	private Comparator tipoDeComparacao;

	/**
	 * Método que contrói o objeto CONTROLLERCENARIOS, definindo o valor inicial
	 * do caixa e a taxa a ser depositada no caixa em caso de perda da aposta.
	 * 
	 * @param caixa
	 *            valor de inicialização do caixa.
	 * @param taxa
	 *            taxa que sera retirado do montante dos perdedores.
	 */
	public ControllerCenarios(int caixa, double taxa) {

		ValidaDados.validaValorNegativo(caixa,
				"Erro na inicializacao: Caixa nao pode ser inferior a 0");
		ValidaDados.validaValorNegativo(taxa,
				"Erro na inicializacao: Taxa nao pode ser inferior a 0");

		this.listaCenarios = new ArrayList<>();
		this.caixa = caixa;
		this.taxa = taxa;
		this.tipoDeComparacao = new ComparaCenario();
	}

	/**
	 * Método que retorna um Int representando valor do caixa.
	 * 
	 * @return Int - caixa
	 */
	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * Método que retorna um Double representando o valor da taxa de percentual
	 * do sistema.
	 * 
	 * @return
	 */
	public double getTaxa() {

		return this.taxa;
	}

	/**
	 * Método que cadastra um cenário e retorna um Int representando a posição
	 * que o cenário foi salvo na lista de cenários.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * 
	 * @return Int - número de identificação do cenário.
	 */
	public int cadastraCenario(String descricao) {

		Cenario cenario = new Cenario(this.listaCenarios.size() + 1, descricao);
		listaCenarios.add(cenario);
		return listaCenarios.size();

	}

	/**
	 * Método que cadastra um cenário com bônus e retorna um Int representando a
	 * posição que o cénario foi salvo na lista de cenários.
	 * 
	 * @param descricao
	 *            descrição do cenário.
	 * @param bonus
	 *            valor do bônus do cenário.
	 * 
	 * @return Int - número de identificação do cenário.
	 */
	public int cadastraCenario(String descricao, int bonus) {

		ValidaDados.validaCaixa(caixa, bonus,
				"Erro no caixa valor vai ficar negativo");
		Cenario cenario = new CenarioBonus(this.listaCenarios.size() + 1,
				descricao, bonus);
		listaCenarios.add(cenario);

		this.caixa -= bonus;
		return this.listaCenarios.size();

	}

	/**
	 * Método que cadastra uma aposta em um cenário.
	 * 
	 * @param cenario
	 *            numero de identificação do cenário em que será salva a aposta.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 */
	public void cadastraAposta(int cenario, String apostador, int valor,
			String previsao) {

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro no cadastro de aposta: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro no cadastro de aposta: Cenario nao cadastrado");
		ValidaDados
				.validaNull(apostador,
						"Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(valor,
						"Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(previsao,
						"Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		ValidaDados.validaPrevisao(previsao,
				"Erro no cadastro de aposta: Previsao invalida");

		ValidaDados.validaZeroOuNegativo(
				buscaCenario(cenario).getQtdApostas() + 1,
				"Erro no cadastro de aposta: Numero de identificação invalido");

		buscaCenario(cenario).cadastraAposta(
				buscaCenario(cenario).getQtdApostas() + 1, apostador, valor,
				previsao);

	}

	/**
	 * Método que cadastra uma aposta segura por valor, retornando um int
	 * representando a posição que a aposta foi salva.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
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
	 * @return Int - número de identificação da aposta.
	 */
	public int cadastraApostaSegura(int cenario, String apostador, int valor,
			String previsao, int valorSeguro, int custo) {

		ValidaDados
				.validaZeroOuNegativo(cenario,
						"Erro no cadastro de aposta assegurada por valor: Cenario invalido");
		ValidaDados
				.validaCenario(cenario, listaCenarios.size(),
						"Erro no cadastro de aposta assegurada por valor: Cenario nao cadastrado");
		ValidaDados
				.validaNull(
						apostador,
						"Erro no cadastro de aposta assegurada por valor: Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(
						valor,
						"Erro no cadastro de aposta assegurada por valor: Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(
						previsao,
						"Erro no cadastro de aposta assegurada por valor: Previsao nao pode ser vazia ou nula");
		ValidaDados
				.validaPrevisao(previsao,
						"Erro no cadastro de aposta assegurada por valor: Previsao invalida");

		ValidaDados
				.validaZeroOuNegativo(
						buscaCenario(cenario).getQtdApostas() + 1,
						"Erro no cadastro de aposta assegurada por valor: Numero de identificação invalido");

		buscaCenario(cenario).cadastraAposta(
				buscaCenario(cenario).getQtdApostas() + 1, apostador, valor,
				previsao, valorSeguro, custo);
		this.caixa += custo;
		return buscaCenario(cenario).getQtdApostas();
	}

	/**
	 * Método que cadastra uma aposta segura por taxa, retornando um int
	 * representando a posição que a aposta foi salva.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param apostador
	 *            nome do apostador.
	 * @param valor
	 *            valor da aposta.
	 * @param previsao
	 *            previsão da aposta.
	 * @param taxa
	 *            percentual do valor que será assegurado.
	 * @param custo
	 *            custo da aposta.
	 * @return Int - número de identificação da aposta.
	 */
	public int cadastraApostaSegura(int cenario, String apostador, int valor,
			String previsao, double taxa, int custo) {

		ValidaDados
				.validaZeroOuNegativo(cenario,
						"Erro no cadastro de aposta assegurada por taxa: Cenario invalido");
		ValidaDados
				.validaCenario(cenario, listaCenarios.size(),
						"Erro no cadastro de aposta assegurada por taxa: Cenario nao cadastrado");
		ValidaDados
				.validaNull(
						apostador,
						"Erro no cadastro de aposta assegurada por taxa: Apostador nao pode ser vazio ou nulo");
		ValidaDados
				.validaZeroOuNegativo(
						valor,
						"Erro no cadastro de aposta assegurada por taxa: Valor nao pode ser menor ou igual a zero");
		ValidaDados
				.validaNull(
						previsao,
						"Erro no cadastro de aposta assegurada por taxa: Previsao nao pode ser vazia ou nula");
		ValidaDados
				.validaPrevisao(previsao,
						"Erro no cadastro de aposta assegurada por taxa: Previsao invalida");

		ValidaDados
				.validaZeroOuNegativo(
						buscaCenario(cenario).getQtdApostas() + 1,
						"Erro no cadastro de aposta assegurada por taxa: Numero de identificação invalido");

		buscaCenario(cenario).cadastraAposta(
				buscaCenario(cenario).getQtdApostas() + 1, apostador, valor,
				previsao, taxa, custo);
		this.caixa += custo;
		return buscaCenario(cenario).getQtdApostas();
	}

	/**
	 * Método que retorna um Int representando o valor total das apostas feitas
	 * em um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - valorApostas.
	 */
	public int valorTotalApostas(int cenario) {

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta do valor total de apostas: Cenario invalido");
		ValidaDados
				.validaCenario(cenario, listaCenarios.size(),
						"Erro na consulta do valor total de apostas: Cenario nao cadastrado");

		return (int) (buscaCenario(cenario).getValorApostas());
	}

	/**
	 * Método que retorna um Int representando a quantidade de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Int - qtdApostas.
	 */
	public int totalDeApostas(int cenario) {
		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta do total de apostas: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro na consulta do total de apostas: Cenario nao cadastrado");

		return buscaCenario(cenario).getQtdApostas();
	}

	/**
	 * Método que retorna uma String com a representação das apostas de um
	 * cenário.A representação segue o formato “NOME - VALOR - PREVISÃO” “NOME -
	 * VALOR - PREVISÃO” “NOME - VALOR - PREVISÃO”
	 * 
	 * Ex. “Francisco Cisco - R$200,00 - N VAI ACONTECER” “Anonimo - R$1,99 - N
	 * VAI ACONTECER” “Matheus Gaudencio - R$100,00 - VAI ACONTECER” “Livia
	 * Maria - R$300,00 - VAI ACONTECER” “Raquel Lopes- R$200,00 - VAI
	 * ACONTECER” “Matheus Gaudencio - R$100,00 - VAI ACONTECER”
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

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta de cenario: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro na consulta de cenario: Cenario nao cadastrado");

		return buscaCenario(cenario).exibeApostas();
	}

	/**
	 * Método que retorna a representação em String de um cenário. A
	 * representação segue o formato “NUMERO DE IDENTIFICAÇÃO - DESCRIÇÃO -
	 * ESTADO"
	 * 
	 * Ex. "1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado”
	 * 
	 * @return String - representação em String de um cenário.
	 * 
	 */
	public String exbibeCenario(int cenario) {

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta de cenario: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro na consulta de cenario: Cenario nao cadastrado");

		return buscaCenario(cenario).toString();
	}

	/**
	 * Método que retorna uma String com representação de todos os cenário
	 * cadastrados. A representação segue o formato. "NUMERO DE IDENTIFICAÇÃO -
	 * DESCRIÇÃO - ESTADO. "NUMERO DE IDENTIFICAÇÃO - DESCRIÇÃO - ESTADO. Ex.
	 * 
	 * “1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado” “2 - O
	 * professor irá para a aula sobre GRASP com um café! - Finalizado
	 * (ocorreu)”
	 * 
	 * @return String - representação em String de todos os cenários
	 *         cadastrados.
	 */
	public String exibeCenarios() {
		String toString = "";

		for (Cenario cenario : listaCenarios) {
			toString += cenario.toString() + System.lineSeparator();

		}
		return toString;
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
	public void encerraCenario(int cenario, boolean ocorreu) {

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro ao fechar aposta: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro ao fechar aposta: Cenario nao cadastrado");

		buscaCenario(cenario).encerraCenario(ocorreu);

		this.caixa += getCaixaCenario(cenario);
		this.caixa -= buscaCenario(cenario).calculaResultado()[1];

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

		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta do caixa do cenario: Cenario invalido");
		ValidaDados.validaCenario(cenario, listaCenarios.size(),
				"Erro na consulta do caixa do cenario: Cenario nao cadastrado");

		if (buscaCenario(cenario).getEstado().equals("Nao finalizado")) {
			throw new UnsupportedOperationException(
					"Erro na consulta do caixa do cenario: Cenario ainda esta aberto");
		}
		return (int) (buscaCenario(cenario).calculaResultado()[0] * this.taxa);
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

		ValidaDados
				.validaZeroOuNegativo(cenario,
						"Erro na consulta do total de rateio do cenario: Cenario invalido");
		ValidaDados
				.validaCenario(cenario, listaCenarios.size(),
						"Erro na consulta do total de rateio do cenario: Cenario nao cadastrado");
		Cenario c = buscaCenario(cenario);

		return c.totalRateioCenario(this.taxa);

	}

	/**
	 * Método que retorna um Cenario.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * 
	 * @return Cenario - cenário pesquisado atraves do número de identificação.
	 */
	private Cenario buscaCenario(int cenario) {

		return listaCenarios.get(cenario - 1);
	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura taxa para
	 * aposta segura valor.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param apostaAssegurada
	 *            número de identificação da aposta
	 * @param valor
	 *            valor que será assegurado.
	 * @return número de identificação da aposta.
	 */
	public int alteraApostaSeguraValor(int cenario, int apostaAssegurada,
			int valor) {

		Cenario c = buscaCenario(cenario);

		c.alteraApostaSeguroValor(apostaAssegurada, valor);

		return apostaAssegurada;
	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura valor para
	 * aposta segura taxa.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param apostaAssegurada
	 *            número de identificação da aposta
	 * @param taxa
	 *            percentual do valor que será assegurado.
	 * @return número de identificação da aposta.
	 */
	public int alteraApostaSeguraTaxa(int cenario, int apostaAssegurada,
			double taxa) {
		Cenario c = buscaCenario(cenario);

		c.alteraApostaSeguraTaxa(apostaAssegurada, taxa);
		return apostaAssegurada;
	}

	/**
	 * Método que altera a ordem de exibição de um cenário.
	 * 
	 * @param ordem
	 *            nova ordem.
	 */
	public void alterarOrdem(String ordem) {
		ValidaDados.validaNull(ordem,
				"Erro ao alterar ordem: Ordem nao pode ser vazia ou nula");
		ValidaDados.validaOrdem(ordem, "Erro ao alterar ordem: Ordem invalida");
		switch (ordem.trim()){
		case "cadastro":
			this.tipoDeComparacao = new ComparaCenario();
			break;
		case "nome":
			this.tipoDeComparacao = new ComparaDescricao();
			break;
		case "apostas":
			this.tipoDeComparacao = new ComparaQuantidadeDeApostas();
			break;
		}
		
	}

	/**
	 * Método que exibe um cenário de acordo com a ordem de exibição.
	 * 
	 * @param cenario
	 *            posição em que se encontra o cenário a ser exibido.
	 * @return a representação em String do cenário.
	 * 
	 */
	public String exibirCenarioOrdenado(int cenario) {
		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro na consulta de cenario ordenado: Cenario invalido");
		ValidaDados.validaCenario(cenario, this.listaCenarios.size(),
				"Erro na consulta de cenario ordenado: Cenario nao cadastrado");

		String cenarioOrdenado = "";
	
			Collections.sort(listaCenarios, this.tipoDeComparacao);
			cenarioOrdenado = this.exbibeCenario(cenario);
			Collections.sort(listaCenarios, new ComparaCenario());
			
			return cenarioOrdenado;

	}

}
