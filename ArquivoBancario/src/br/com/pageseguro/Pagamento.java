package br.com.pageseguro;

public class Pagamento {
	protected String id;
	protected String data;
	protected double valor;
	protected String bancoPagamento;
	protected String bancoRecebimento;
	protected String CPF;
	protected String nome;
	protected int parcelas;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getParcelas() {
		return parcelas;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public double getValor() {
		return valor;
	}
	
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public String getBancoPagamento() {
		return bancoPagamento;
	}
	
	public void setBancoPagamento(String bancoPagamento) {
		this.bancoPagamento = bancoPagamento;
	}
	
	public String getBancoRecebimento() {
		return bancoRecebimento;
	}
	
	public void setBancoRecebimento(String bancoRecebimento) {
		this.bancoRecebimento = bancoRecebimento;
	}
	
	public String getCpfTitular() {
		return CPF;
	}
	
	public void setCpfTitular(String cpfTitular) {
		this.CPF = cpfTitular;
	}
	
	public String getNomeTitular() {
		return nome;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nome = nomeTitular;
	}
}