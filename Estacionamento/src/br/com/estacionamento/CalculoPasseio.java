package br.com.estacionamento;

public class CalculoPasseio extends CalculoVeiculos {

	@Override
	public void imprimir(Veiculo veiculo, double tempo) {
		// TODO Auto-generated method stub
		Passeio passeio = (Passeio) veiculo;
		System.out.println("Tipo de veículo: "+passeio.getTipo());
		double valor = 0;
		if(((Passeio) veiculo).getTipo().equals("comum")) {
			valor = valorConta(tempo, 2, 20, 100);
		}else {
			valor = valorConta(tempo, 3, 25, 150);
		}
		System.out.println("Valor final: R$"+valor);
		
	}

	
	//Entradas: Tempo, tempo de estadia em milissegundos; 
	//Hora: valor da hora do tipo do veiculo; 
	//Diaria: valor da diaria do tipo do veiculo; 
	// Mensal: valor do mensal do tipo do veiculo; 
	



}
