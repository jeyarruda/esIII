package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Print {
	private List<Produto> produtos = new ArrayList<>();
	public void printLIstaProdutos() {
		for(Produto p : produtos) {
			System.out.println("Nome: "+p.getNome()+"\n"+"Valor do produto: "+p.getValorProduto());
			if(p.desconto instanceof DescontoPercent) {
				System.out.println("Porcertagem de desconto: "+((DescontoPercent) p.desconto).getPorcentagem());
			}
			System.out.println("Total de desconto: "+p.desconto.getValorDesconto());
			System.out.println("Valor com desconto:"+p.getValorComDesconto()+"\n");
		}
	}
	public void setLista(List<Produto> list) {
		this.produtos = list;
	}
}
