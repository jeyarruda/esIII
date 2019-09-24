package br.com.febraban;

public class Pagamento {
	protected String id;
	protected String data;
	protected double valor;
	protected String bancoPagamento;
	protected String bancoRecebimento;
	protected String cpfTitular;
	protected String nomeTitular;
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
		return cpfTitular;
	}
	
	public void setCpfTitular(String cpfTitular) {
		this.cpfTitular = cpfTitular;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}
}