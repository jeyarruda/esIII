package br.com.fatec;

public class CalculadorPreco {
	private Produto produto;
	private CalculoDesconto calculo;
	
	public CalculadorPreco(Produto produto, CalculoDesconto calculo) {
		this.produto = produto;
		this.calculo = calculo;
	}
	
	public double calcularDescontos() {
		return calculo.calcularDesconto(produto);
	}
}