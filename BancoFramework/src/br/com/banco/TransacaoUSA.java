package br.com.banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransacaoUSA extends Transacao {

	String formattedData;

	//boleto
	public TransacaoUSA(String numeroBoleto, String nome, String CPF, String bancoRecebimento, String bancoPagamento,
			LocalDateTime data, double valor) {
		super(numeroBoleto, nome, CPF, bancoRecebimento, bancoPagamento, data, valor);
		convertDate();
		// TODO Auto-generated constructor stub
	}
	
	//debito
	public TransacaoUSA(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao) {
		super(nomeTitular, nome, CPF, bancoRecebimento, bancoPagamento, data, valor, numeroCartao);
		convertDate();
	}
	
	//credito
	public TransacaoUSA(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao, Integer parcelas) {
		super(nomeTitular, nome, CPF, bancoRecebimento, bancoPagamento, data, valor, numeroCartao, parcelas);
		convertDate();
	}
	
	
	
	@Override
	public void convertDate() {
		// TODO Auto-generated method stub
		LocalDateTime local = this.getData();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		String date = local.format(formatter);
		formattedData = date; 
	}


	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		if(numeroBoleto.isEmpty()) {
			System.out.println("Card Number: "+numeroCartao);
			System.out.println("Card name: "+nomeTitular);
			if(parcelas != 0) {
				System.out.println("Portion number: "+parcelas);
			}
		}else{
			System.out.println("Billet number: "+numeroBoleto);
		}
		System.out.println("Name: "+nome);
		System.out.println("Social Security number: "+CPF);
		System.out.println("Receiving Bank: "+bancoRecebimento);
		System.out.println("Paying Bank: "+bancoPagamento);
		System.out.println("Value: "+valor);
		System.out.println("Date: "+formattedData);

	}

}
