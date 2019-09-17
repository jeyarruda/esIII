package br.com.estacionamento;

public abstract class CalculoVeiculos implements CalculoValor {
	@Override
	public double valorConta(double tempo, int hora, int diaria, int mensal) {
		// TODO Auto-generated method stub
		long tempoSegundo = (int) Math.ceil(tempo/1000);
		long tempoMinuto = (int) Math.ceil(tempoSegundo/60);
		int tempoHora = (int) Math.ceil(tempoMinuto/60); 
		long tempoDia = (int) Math.ceil(tempoHora/24); 
		long tempoMes = (int) Math.ceil(tempoDia/30); 
		
		double value = 0 ; 
	
		if(tempoHora <12) {
			if(tempoHora < 1 &&(tempoSegundo>0||tempoMinuto>0)) {
				value = hora;
			}else {
				value = tempoHora*hora;
			}
		}else if(tempoHora > 12 && tempoDia < 15) {
			if(tempoHora > 12 && tempoDia < 1) {
				value = diaria;
			}else {
				value = tempoDia * diaria;
			}
		}else if(tempoDia > 15) {
			value = tempoMes * mensal; 
		}
		
		return value;

	}
	
	public abstract void imprimir(Veiculo veiculo, double tempo);

	

}
