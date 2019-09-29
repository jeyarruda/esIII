package br.com.pageseguro.remessas;

import java.util.List;

public class Remessas {
	private List<RemessaCartaoCredito> remessasCredito;
	private List<RemessaCartaoDebito> remessasDebito;
	private List<RemessaBoleto> remessasBoleto;
	private List<Remessa> remessas;
	
	public List<RemessaBoleto> getRemessasBoleto() {
		return remessasBoleto;
	}
	
	public List<RemessaCartaoCredito> getRemessasCredito() {
		return remessasCredito;
	}
	
	public List<RemessaCartaoDebito> getRemessasDebito() {
		return remessasDebito;
	}
	
	public List<Remessa> getRemessas() {
		/*remessas.addAll(remessasDebito);
		remessas.addAll(remessasCredito);
		remessas.addAll(remessasBoleto);*/
		return remessas;
	}
}