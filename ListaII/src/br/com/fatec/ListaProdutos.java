package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutos {
	private List<Produto> produtos = new ArrayList<>();
	
	public void setProdutoLista(Produto produto) {
		produtos.add(produto);
	}
	public void removeProdutoLista(Produto produto) {
		produtos.remove(produto);
	}
	public List<Produto> getLista() {
		return produtos;
	}
}
