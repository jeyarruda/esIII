package br.com.fatec;

public class Menu {
	public void Principal(){
		System.out.println("Escolha uma das opções:\n");
		System.out.println("1-Novo produto sem desconto.");
		System.out.println("2-Novo produto com desconto com valor inteiro.");
		System.out.println("3-Novo produto com desconto em porcentagem.");
		System.out.println("4-Imprimir lista de produtos.");
		System.out.println("5-Sair.");
	}
	public void NomeProduto(){
		System.out.println("Insira o nome do produto:");
	}
	public void Preco(){
		System.out.println("Insira o valor do produto");
	}
	public void Desconto(int opcao){
		if(opcao == 2){
			System.out.println("Insira o valor do desconto:");
		}else{
			System.out.println("Insira a porcentagem de desconto:");
		}
		
	}
	public void menuPlacas(){
		System.out.print("Insira a placa do veiculo: ");
	}
}
