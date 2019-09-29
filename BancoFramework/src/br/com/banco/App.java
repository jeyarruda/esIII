package br.com.banco;

import java.time.LocalDateTime;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDateTime data =
			    LocalDateTime.of(2015, 11, 26, 13, 55, 36, 123);
		
		Transacao transacao = new TransacaoBrasil("1234567", "João Vitor", "46425406879", "Nubank", "Inter", data, 437); 
		transacao.imprimir();
		System.out.println("===================");
		Transacao transaction = new TransacaoUSA("1234567", "João Vitor", "46425406879", "Nubank", "Inter", data, 437); 
		transaction.imprimir();
		
		
		System.out.println("===================");
		transacao.compare();
		
	}

}
