package br.com.estacionamento;


public class Carga extends Veiculo {
	double valor; 
	int eixo; 
	
	public Carga(double valor, int eixo) {
		this.valor = valor; 
		this.eixo = eixo; 
	}
	
	public double getValor() {
		return this.valor; 
	}
	
	public int getEixo() {
		return this.eixo; 
	}

	@Override
	public double getAcrescimo() {
		// TODO Auto-generated method stub
		double acrescimoValor = valor*0.1;
		return acrescimoValor; 
	}
	
}
