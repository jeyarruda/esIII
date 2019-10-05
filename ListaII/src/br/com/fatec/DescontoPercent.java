package br.com.fatec;

public class DescontoPercent extends Desconto{
	private double valorProduto;
	

	public DescontoPercent(double valorDesconto, double valorProduto) {
		super(valorDesconto);
		this.valorProduto = valorProduto;
	}

	@Override
	public double getValorDesconto() {
		return valorProduto / 100 * valorDesconto;
	}
	
	public double getPorcentagem() {
		return valorDesconto;
	}

}
