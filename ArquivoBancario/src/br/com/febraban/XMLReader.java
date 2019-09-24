package br.com.febraban;

import java.util.ArrayList;

public class XMLReader implements ArquivoBancario {
	ArrayList<Pagamento> pagamentos;
	
	@Override
	public ArrayList<Pagamento> readFile(String src) {
		return pagamentos;
	}
}
