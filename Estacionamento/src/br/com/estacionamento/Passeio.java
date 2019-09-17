package br.com.estacionamento;


public class Passeio extends Veiculo {
	String tipo; 
	public Passeio(String tipo) {
		// TODO Auto-generated constructor stub
		this.tipo = tipo; 
	}
	
	public String getTipo(){
		return this.tipo; 
	}

	@Override
	public double getAcrescimo() {
		// TODO Auto-generated method stub
		return 0;
	}

}
