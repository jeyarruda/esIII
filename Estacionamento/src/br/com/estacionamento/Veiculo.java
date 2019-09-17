package br.com.estacionamento;


public abstract class Veiculo {
	protected long tempoEntrada;
	protected double tempo;
	protected double acrescimo;
	
	public Veiculo() {
			
	}
	
	public abstract double getAcrescimo();



}
