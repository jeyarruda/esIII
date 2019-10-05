package br.com.fatec;

public class Produto {
	private String nome;
	private double valorProduto;
	public Desconto desconto;
	private CalculadorPreco calculadorPreco;

	public Produto(String nome, double valorProduto, Desconto deconto) {
		this.nome = nome;
		this.valorProduto = valorProduto;
		this.desconto = deconto;
	}

	public String getNome() {
		return nome;
	}

	public double getValorProduto() {
		return valorProduto;
	}

	public double getValorComDesconto() {
		calculadorPreco = new CalculadorPreco(this);
		return calculadorPreco.calcularDescontos();
	}
}