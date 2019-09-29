package br.com.pageseguro.remessas;

public class Remessa {
	protected String CPF;
	protected String nome;
	protected String bancoPagamento;
	protected String bancoRecebimento;
	protected double valor;
	protected String data;
	
	public String getCPF() {
		return CPF;
	}
	
	public void setCPF(String CPF) {
		this.CPF = CPF;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
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
}