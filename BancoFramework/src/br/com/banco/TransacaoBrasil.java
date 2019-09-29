package br.com.banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TransacaoBrasil extends Transacao {

	


		String formattedData;
		//boleto
			
		public TransacaoBrasil(String numeroBoleto, String nome, String CPF, String bancoRecebimento, String bancoPagamento,
				LocalDateTime data, double valor) {
			super(numeroBoleto, nome, CPF, bancoRecebimento, bancoPagamento, data, valor);
			convertDate();
		}
		
		//debito
		public TransacaoBrasil(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao) {
			super(nomeTitular, nome, CPF, bancoRecebimento, bancoPagamento, data, valor, numeroCartao);
			convertDate();
		}
		
		//credito
		public TransacaoBrasil(String nomeTitular, String nome, String CPF, String bancoRecebimento, String bancoPagamento, LocalDateTime data, double valor, String numeroCartao, Integer parcelas) {
			super(nomeTitular, nome, CPF, bancoRecebimento, bancoPagamento, data, valor, numeroCartao, parcelas);
			convertDate();
		}
		
	
	
	@Override
	public void convertDate() {
		LocalDateTime local = this.getData();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String date = local.format(formatter);
		formattedData = date; 
	}


	@Override
	public void imprimir() {
		// TODO Auto-generated method stub
		if(numeroBoleto.isEmpty()) {
			System.out.println("Número do cartão: "+numeroCartao);
			System.out.println("Nome do titular: "+nomeTitular);
			if(parcelas != 0) {
				System.out.println("Número de parcelas: "+parcelas);
			}
		}else{
			System.out.println("Número do boleto: "+numeroBoleto);
		}
		System.out.println("Nome: "+nome);
		System.out.println("CPF: "+CPF);
		System.out.println("Banco receptor: "+bancoRecebimento);
		System.out.println("Banco pagante: "+bancoPagamento);
		System.out.println("Valor: "+valor);
		System.out.println("Data: "+formattedData);
	}

}
