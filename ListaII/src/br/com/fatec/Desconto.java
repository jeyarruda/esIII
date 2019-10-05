package br.com.fatec;

public abstract class Desconto {
	protected double valorDesconto;
	
	public Desconto(double valorDesconto) {
		this.valorDesconto = valorDesconto; 
	}

	public abstract double getValorDesconto();
}