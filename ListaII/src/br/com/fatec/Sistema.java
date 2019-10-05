package br.com.fatec;

import java.util.Scanner;

public class Sistema {
	public static void main(String[] args) {
		int opcao = 0;
		int sair = 0;

		String nome = "";
		double desc = 0, valorProduto = 0;
		Desconto desconto = null;
		Produto produto = null;
		ListaProdutos lista = new ListaProdutos();
		Print print = new Print();
		Menu menu = new Menu();
		Scanner scanner = new Scanner(System.in);
		print.setLista(lista.getLista());
		while (sair == 0) {
			switch (opcao) {
			case -1:
				produto = new Produto(nome, valorProduto, desconto);
				lista.setProdutoLista(produto);
				opcao = 0;
				break;
			case 0:
				menu.Principal();
				opcao = scanner.nextInt();
				scanner.nextLine();
				if (opcao != 4) {
					menu.NomeProduto();
					nome = scanner.nextLine();
					menu.Preco();
					valorProduto = scanner.nextDouble();
				}
				break;
			case 1:
				desconto = new DescontoInteiro(0);
				opcao = -1;
				break;
			case 2:
				menu.Desconto(opcao);
				desc = scanner.nextDouble();
				desconto = new DescontoInteiro(desc);
				opcao = -1;
				break;

			case 3:
				menu.Desconto(opcao);
				desc = scanner.nextDouble();
				desconto = new DescontoPercent(desc, valorProduto);
				opcao = -1;
				break;
			case 4:
				print.printLIstaProdutos();
				opcao = -1;
				break;
			case 5:
				sair = 1;
				System.out.println("ATÉ MAIS!\n;)");
				break;

			default:
				opcao = 0;
				break;
			}
		}
		scanner.close();

	}

}
