package br.com.febraban;

import java.util.ArrayList;

public interface ArquivoBancario {
	public ArrayList<Pagamento> readFile(String src);
}