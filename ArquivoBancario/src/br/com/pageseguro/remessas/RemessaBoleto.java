package br.com.pageseguro.remessas;

public class RemessaBoleto extends Remessa {
	private String numeroBoleto;
	
	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}
	
	public String getNumeroBoleto() {
		return numeroBoleto;
	}
}