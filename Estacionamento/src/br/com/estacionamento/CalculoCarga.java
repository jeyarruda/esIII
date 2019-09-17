package br.com.estacionamento;

public class CalculoCarga extends CalculoVeiculos {
	double acrescimo; 
	//Entradas: Tempo, tempo de estadia em milissegundos; 
	//Hora: valor da hora do tipo do veiculo; 
	//Diaria: valor da diaria do tipo do veiculo; 
	// Mensal: valor do mensal do tipo do veiculo; 
	
	
	public void setAcrescimo(double valor, int eixo) {
		
		
	}


	@Override
	public void imprimir(Veiculo veiculo, double tempo) {
		// TODO Auto-generated method stub
		Carga carga = (Carga) veiculo; 
		double valorAdd = carga.getAcrescimo(); 
		System.out.println("VALOR PELO PESO DA CARGA: "+valorAdd);
		int eixo = carga.getEixo();
		System.out.println("QUANTIDADE DE EIXOS: "+eixo);
		double valor = valorConta(tempo, 4, 35, 200);
		System.out.println("VALOR POR EIXO: "+valor);
		double finalValue = eixo * valor + valorAdd;
		System.out.println("-------------------------");
		System.out.println("VALOR FINAL: "+finalValue);
		
	}
	
	
	
}
