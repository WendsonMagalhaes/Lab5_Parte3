package Lab5;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Laboratório de Programação 2 - Lab 5
 * 
 * Representação de um Cenario.
 * 
 * @author Wendson Magalhães - 117210424
 */

public class Cenario {

	/**
	 * Descrição do cenário
	 */
	protected String descricao;
	/**
	 * Estado do cenário.
	 */
	protected String estado;
	/**
	 * Identificador do cenário
	 */
	protected int cenario;
	/**
	 * Lista de todas as apostas feitas no cenário.
	 */
	protected List<Aposta> apostasFeitas;
	/**
	 * Quantidade de apostas feitas no cenário.
	 */
	protected int qtdApostas;
	/**
	 * Valor Total das apostas feitas no cenário.
	 */
	protected int valorApostas;

	/**
	 * Quantidades de ganhadores do cenário.
	 */
	protected int qtdGanhadores;

	/**
	 * Método que constrói o objeto CENÁRIO, definindo sua descrição.
	 * 
	 * @param cenario
	 *            número de identificação do cenário.
	 * @param descricao
	 *            descrição do cenário
	 */

	public Cenario(int cenario, String descricao) {

		ValidaDados.validaNull(descricao,
				"Erro no cadastro de cenario: Descricao nao pode ser vazia");
		ValidaDados.validaZeroOuNegativo(cenario,
				"Erro no cadastro de cenario: Cenario invalido");

		this.descricao = descricao;
		this.estado = "Nao finalizado";
		this.cenario = cenario;
		this.apostasFeitas = new ArrayList<>();
		this.qtdApostas = 0;
		this.valorApostas = 0;
		this.qtdGanhadores = 0;
	}

	/**
	 * Método que cadastra uma aposta no cenário.
	 * 
	 * @param aposta
	 *            aposta a ser adicionada ao cenário.
	 */
	public void cadastraAposta(Aposta aposta) {

		apostasFeitas.add(aposta);

		this.qtdApostas++;
		this.valorApostas += aposta.getValor();

	}

	/**
	 * Método que retorna a representação em String de todas as apostas feitas
	 * em um cenário. A representação segue o formato “NOME - VALOR - PREVISÃO”
	 * “NOME - VALOR - PREVISÃO” “NOME - VALOR - PREVISÃO”
	 * 
	 * Ex. “Francisco Cisco - R$200,00 - N VAI ACONTECER” “Anonimo - R$1,99 - N
	 * VAI ACONTECER” “Matheus Gaudencio - R$100,00 - VAI ACONTECER” “Livia
	 * Maria - R$300,00 - VAI ACONTECER” “Raquel Lopes- R$200,00 - VAI
	 * ACONTECER” “Matheus Gaudencio - R$100,00 - VAI ACONTECER”
	 * 
	 * @return String - representação em String de todas as apostas feitas em um
	 *         cenário.
	 */
	public String exibeApostas() {
	
		String todasAsApostas = "";
		for (Aposta aposta : apostasFeitas) {
			todasAsApostas += aposta.toString() + System.lineSeparator();
	
		}
		return todasAsApostas;
	}

	/**
	 * Método que encerra um cénario, definindo se ele ocorreu ou não ocorreu.
	 * 
	 * @param ocorreu
	 *            boolean informado se o cenário ocorreu ou não.
	 */
	public void encerraCenario(boolean ocorreu) {

		ValidaDados.validaEstado(this.estado,
				"Erro ao fechar aposta: Cenario ja esta fechado");

		if (ocorreu == true) {

			this.estado = "Finalizado (ocorreu)";

		} else {

			this.estado = "Finalizado (n ocorreu)";

		}
		

	}

	/**
	 * Método que calcula a soma dos valores das apostas perdedoras e a soma dos
	 * valores assegurados das apostas com seguro retornando uma lista com esse
	 * dois valores em double.
	 * 
	 * @return double[] - soma - lista com os valores das somas.
	 */

	public double[] calculaResultado() {

		double[] soma = new double[2];
		
		for (Aposta aposta : this.apostasFeitas) {
			soma[0] += aposta.verificaAposta(this.estado)[0];
			soma[1] += aposta.verificaAposta(this.estado)[1];
			this.qtdGanhadores += aposta.verificaAposta(this.estado)[2];
		}
		return soma;
		

	}

	/**
	 * Método que calcula o valor total que sera rateado entre os ganhadores.
	 * 
	 * @param taxa
	 *             percentual do valor que será repassado para o caixa.
	 * 
	 * @return Int - Valor total a ser rateado entre os ganhadores.
	 */
	public int totalRateioCenario(double taxa) {

		if (this.getEstado().equals("Nao finalizado")) {
			throw new UnsupportedOperationException(
					"Erro na consulta do total de rateio do cenario: Cenario ainda esta aberto");
		}

		return (int) (this.calculaResultado()[0]) - (int) (this.calculaResultado()[0] * taxa);

	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura taxa para
	 * aposta segura valor.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * @param valor
	 *            valor que será assegurado.
	 */
	public int alteraApostaSeguroValor(int idAposta, int valor) {
		
		ValidaDados.validaAposta(idAposta, apostasFeitas.size(), "");
		ApostaSegura apostaAntiga = (ApostaSegura) buscaAposta(idAposta);
		ValidaDados.validaApostaSegura(apostaAntiga, "");
	
		ApostaSegura apostaNova = new ApostaSegura(idAposta,
				apostaAntiga.getApostador(), apostaAntiga.getValor(),
				apostaAntiga.getPrevisao(), valor, apostaAntiga.getCusto());
	
		this.apostasFeitas.remove(apostaAntiga);
		this.cadastraAposta(apostaNova);
		return apostaNova.getCusto();
	}

	/**
	 * Método que altera o tipo da aposta passando de aposta segura valor para
	 * aposta segura taxa.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * @param taxa
	 *            percentual do valor que será assegurado.
	 */
	public int alteraApostaSeguraTaxa(int idAposta, double taxa) {
		
		ValidaDados.validaAposta(idAposta, apostasFeitas.size(), "");
		ApostaSegura apostaAntiga = (ApostaSegura) buscaAposta(idAposta);
		ValidaDados.validaApostaSegura(apostaAntiga, "");
		ApostaSegura apostaNova = new ApostaSegura(idAposta,
				apostaAntiga.getApostador(), apostaAntiga.getValor(),
				apostaAntiga.getPrevisao(), taxa, apostaAntiga.getCusto());
	
		this.apostasFeitas.remove(apostaAntiga);
		this.cadastraAposta(apostaNova);
		return apostaNova.getCusto();
	}

	/**
	 * Método que faz a busca de uma aposta no cenário atraves do idAposta
	 * fornecido.
	 * 
	 * @param idAposta
	 *            número de identificação da aposta.
	 * 
	 * @return Aposta - aposta pesquisada.
	 */
	private Aposta buscaAposta(int idAposta) {
	
		return apostasFeitas.get(idAposta - 1);
	}

	/**
	 * { Método que retorna um Int representando a quantidade de apostas
	 * adiciona ao cenário.
	 * 
	 * @return Int - qtdApostas.
	 */
	public int getQtdApostas() {
		return qtdApostas;
	}

	/**
	 * Método que retorna um Double representando o valor total das apostas
	 * feitas no cenário.
	 * 
	 * @return Double - valorApostas
	 */
	public double getValorApostas() {
		return valorApostas;
	}

	/**
	 * Método que retorna uma String representando o estado do cenário.
	 * 
	 * @return String - estado.
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Método que retorna um Int representando a identificação do cenário.
	 * 
	 * @return Int - cenario.
	 */
	public int getCenario() {
		return this.cenario;
	}

	/**
	 * Método que retorna um Int representando a quantidade de ganhadores do
	 * cenário.
	 * 
	 * @return Int - qtdGanhadores.
	 */
	public int getQtdGanhadores() {
		this.calculaResultado();
		return this.qtdGanhadores;
	}

	/**
	 * Método que retorna o tamanho da lista de apostas feitas.
	 * 
	 * @return Int - apostasFeitas.size().
	 */
	public int getTamanho() {
		return this.apostasFeitas.size();
	}
	public String getDescricao(){
		return this.descricao;
	}
	

	/**
	 * Método que retorna a representação em String de um cenário. A
	 * representação segue o formato “NUMERAÇÃO - DESCRIÇÃO - ESTADO"
	 * 
	 * Ex. "1 - A maioria irá tirar mais do que 7 na prova! - Não finalizado”
	 * 
	 * @return String - representação em String de um cenário.
	 * 
	 */
	@Override
	public String toString() {
		return this.cenario + " - " + this.descricao.trim() + " - " + this.estado;
	}

	/**
	 * Método que retorna um Int que representa a posição do objeto na memória,
	 * essa posição é referente ao numero de identificação do cenário.
	 * 
	 * @return Int - hashCode.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cenario;
		return result;
	}

	/**
	 * Método que retorna um boolean que indica se um objeto é igual a um
	 * CENARIO, essa comparação é feita pelo numero de identificação, dois
	 * cenários são iguais se seus numeros de identificação são iguais.
	 * 
	 * @return boolean - "true" ou "false".
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cenario other = (Cenario) obj;
		if (cenario != other.cenario)
			return false;
		return true;
	}
	
}
