package br.com.pageseguro;

import java.util.List;

import br.com.pageseguro.remessas.Remessa;

public interface RemessaArquivo {
	public List<Remessa> lerRemessas(String src);
}