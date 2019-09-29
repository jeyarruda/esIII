package br.com.pageseguro;

import java.util.List;

import br.com.pageseguro.remessas.Remessa;

public interface PagamentoArquivo {
	public List<Remessa> lerRemessas(String src);
}