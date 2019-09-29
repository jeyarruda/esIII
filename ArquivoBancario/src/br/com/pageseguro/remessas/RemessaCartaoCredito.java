package br.com.pageseguro.remessas;

public class RemessaCartaoCredito extends Remessa {
	private String numeroCartao;
	private String nomeTitular;
	private int parcelas;
	
	public String getNumeroCartao() {
		return numeroCartao;
	}
	
	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}
	
	public String getNomeTitular() {
		return nomeTitular;
	}
	
	public void setNomeTitular(String nomeTitular) {
		this.nomeTitular = nomeTitular;
	}

	public void setParcelas(int parcelas) {
		this.parcelas = parcelas;
	}

	public int getParcelas() {
		return parcelas;
	}
}