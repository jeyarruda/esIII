package br.com.fatec;

public class Produto {
	protected String nome;
	protected String descricao;
	protected double valorProduto;
	
	public String getNome() {
		return nome;
	}
	
	public double getValorProduto() {
		return valorProduto;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
}