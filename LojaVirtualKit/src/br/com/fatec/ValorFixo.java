package br.com.fatec;

public class ValorFixo implements CalculoDesconto {
	private Desconto desconto;
	
	public ValorFixo(Desconto desconto) {
		this.desconto = desconto;
	}
	
	@Override
	public double calcularDesconto(Produto produto) {
		return produto.getValorProduto() - desconto.getValorDesconto();
	}

}
