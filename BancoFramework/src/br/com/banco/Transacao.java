package br.com.banco;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public abstract class Transacao {
	
	//boleto
	String numeroBoleto;
	
	//cartoes
	//credito 
	Integer parcelas;

	//debito
	String numeroCartao;
	
	//geral
	String nomeTitular; 
	String nome;
	String CPF;
	String bancoRecebimento;
	String bancoPagamento;
	LocalDateTime data; 
	double valor;	
	
	
	
	
	//boleto
	public Transacao(String numeroBoleto,  String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor) {
		this.nome = nome; 
		this.CPF = CPF; 
		this.bancoRecebimento = bancoRecebimento; 
		this.bancoPagamento = bancoPagamento; 
		this.data = data; 
		this.valor = valor; 
		this.numeroBoleto = numeroBoleto; 
	}
	
	
	//debito
	public Transacao(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao) {
		this.nomeTitular = nomeTitular; 
		this.nome = nome; 
		this.CPF = CPF; 
		this.bancoRecebimento = bancoRecebimento; 
		this.bancoPagamento = bancoPagamento; 
		this.data = data; 
		this.valor = valor; 
		this.numeroCartao = numeroCartao; 
	}
	
	
	//credito
	public Transacao(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao, Integer parcelas) {
		this.nomeTitular = nomeTitular; 
		this.nome = nome; 
		this.CPF = CPF; 
		this.bancoRecebimento = bancoRecebimento; 
		this.bancoPagamento = bancoPagamento; 
		this.data = data; 
		this.valor = valor; 
		this.numeroCartao = numeroCartao; 
		this.parcelas = parcelas; 
	}
	
	
	public abstract void imprimir(); 
	
	public void compare() {
		LocalDateTime dataTransacao = this.getData(); 
		LocalDateTime hoje = LocalDateTime.now();
		LocalDateTime tempDateTime = LocalDateTime.from( dataTransacao );
    	LocalDateTime toDateTime = LocalDateTime.from( hoje );


    	long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS);
    	tempDateTime = tempDateTime.plusYears( years );

    	long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
    	tempDateTime = tempDateTime.plusMonths( months );

    	long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
    	tempDateTime = tempDateTime.plusDays( days );


    	long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
    	tempDateTime = tempDateTime.plusHours( hours );

    	long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
    	tempDateTime = tempDateTime.plusMinutes( minutes );

    	long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);

    	System.out.println( "Essa transação ocorreu fazem: "+years + " anos " + 
    	        months + " meses " + 
    	        days + " dias " +
    	        hours + " horas " +
    	        minutes + " minutos " +
    	        seconds + " segundos.");
		
	}
	
	
//	
//	public void setDataTransacao() {
//		LocalDateTime now = LocalDateTime.now();
//		int year = now.getYear();
//		int month = now.getMonthValue();
//		int day = now.getDayOfMonth();
//		int hour = now.getHour();
//		int minute = now.getMinute();
//		int second = now.getSecond();
//	}
//	
//	public LocalDateTime getDataTransacao() {
//		return dataTransacao;
//	}

	
	
	public String getNumeroBoleto() {
		return numeroBoleto;
	}


	public void setNumeroBoleto(String numeroBoleto) {
		this.numeroBoleto = numeroBoleto;
	}


	public Integer getParcelas() {
		return parcelas;
	}


	public void setParcelas(Integer parcelas) {
		this.parcelas = parcelas;
	}


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


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getCPF() {
		return CPF;
	}


	public void setCPF(String cPF) {
		CPF = cPF;
	}


	public String getBancoRecebimento() {
		return bancoRecebimento;
	}


	public void setBancoRecebimento(String bancoRecebimento) {
		this.bancoRecebimento = bancoRecebimento;
	}


	public String getBancoPagamento() {
		return bancoPagamento;
	}


	public void setBancoPagamento(String bancoPagamento) {
		this.bancoPagamento = bancoPagamento;
	}


	public LocalDateTime getData() {
		return data;
	}


	public void setData(LocalDateTime data) {
		this.data = data;
	}


	public double getValor() {
		return valor;
	}


	public void setValor(double valor) {
		this.valor = valor;
	}


	public abstract void convertDate();
}
