package br.com.fatec;

import java.util.List;

public class ProdutoComposto extends Produto {
	private List<Produto> listaProdutos;
	private List<Desconto> listaDescontos;
	
	public ProdutoComposto(String nome, List<Produto> produtos, List<Desconto> descontos) {
		this.nome = nome;
		listaProdutos = produtos;
		listaDescontos = descontos;
		calcularValorTotal();
	}
	
	private void calcularValorTotal() {
		double total = this.valorProduto;
		
		for(Produto p : listaProdutos) {
			total += p.getValorProduto();
		}
		
		this.valorProduto = total;
	}
	
	public double calcularDescontoTotal() {
		double total = 0.0;
		
		for(Desconto d : listaDescontos) {
			total += d.getValorDesconto();
		}
		
		return total;
	}
}