package br.com.fatec;

public class CalculadorPreco {
	private Produto produto;

	public CalculadorPreco(Produto produto) {
		this.produto = produto;
	}

	public double calcularDescontos() {
		return produto.getValorProduto() - produto.desconto.getValorDesconto();
	}
}