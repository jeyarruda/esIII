package br.com.fatec;

public class ValorPorcentagem implements CalculoDesconto {
	private Desconto desconto;
	
	public ValorPorcentagem(Desconto desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public double calcularDesconto(Produto produto) {
		return produto.getValorProduto() - produto.getValorProduto() * (desconto.getValorDesconto() / 100);
	}

}
