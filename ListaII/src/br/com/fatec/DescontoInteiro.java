package br.com.fatec;

public class DescontoInteiro extends Desconto{


	public DescontoInteiro(double valorDesconto) {
		super(valorDesconto);
	}

	@Override
	public double getValorDesconto() {
		return valorDesconto;
	}

	

}
