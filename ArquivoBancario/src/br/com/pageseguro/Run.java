package br.com.pageseguro;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import br.com.pageseguro.remessas.Remessa;
import br.com.pageseguro.remessas.RemessaBoleto;
import br.com.pageseguro.remessas.RemessaCartaoCredito;
import br.com.pageseguro.remessas.RemessaCartaoDebito;

public class Run {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Remessa> remessas = new ArrayList<Remessa>();
		
		RemessaJSON remessaJson = new RemessaJSON();
		RemessaXML remessaXml = new RemessaXML();
		
		int op;
		do {
			System.out.print("==============\n"
				+ "1 - Remessas em JSON\n"
				+ "2 - Remessas em XML\n"
				+ "=================\n>");
			op = sc.nextInt();
			
			switch (op) {
				case 1:
					remessas = remessaJson.lerRemessas("files/remessa.json");
					break;
				
				case 2:
					remessas = remessaXml.lerRemessas("files/remessa.xml");
					break;
					
				default:
					System.out.println("[ Opção inválida! ]");
					break;
			}
		} while(op != 1 && op != 2);
		listarRemessas(remessas);
	}
	
	public static void listarRemessas(List<Remessa> remessas) {
		System.out.println("============== Pagamentos XML =============");
		for(Remessa r : remessas) {
			if(r instanceof RemessaBoleto) {
				System.out.println("---| Pagamento via boleto |---");
				RemessaBoleto rb = (RemessaBoleto) r;
				System.out.println("[Número Boleto] = " + rb.getNumeroBoleto());
			}
			
			if(r instanceof RemessaCartaoCredito) {
				System.out.println("---| Pagamento via cartão de crédito |---");
				RemessaCartaoCredito rcc = (RemessaCartaoCredito) r;
				System.out.println("[Titular] = " + rcc.getNomeTitular());
				System.out.println("[Número Cartão] = " + rcc.getNumeroCartao());
				System.out.println("[Parcelas] = " + rcc.getParcelas());
			}
			
			if(r instanceof RemessaCartaoDebito) {
				System.out.println("---| Pagamento via cartão de débito |---");
				RemessaCartaoDebito rcd = (RemessaCartaoDebito) r;
				System.out.println("[Titular] = " + rcd.getNomeTitular());
				System.out.println("[Número Cartão] = " + rcd.getNumeroCartao());
			}
			
			System.out.println("[CPF] = " + r.getCPF());
			System.out.println("[Nome] = " + r.getNome());
			System.out.println("[Banco Pagamento] = " + r.getBancoPagamento());
			System.out.println("[Banco Recebimento] = " + r.getBancoPagamento());
			System.out.println("[Valor] = " + r.getValor());
			System.out.println("[Data] = " + r.getData());
			System.out.println("--- -------------------------------- ---");
		}
		System.out.println("=========================================");
	}
}