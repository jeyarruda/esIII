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
			System.out.print("=================\n"
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
		sc.close();
		listarRemessas(remessas);
	}
	
	public static void listarRemessas(List<Remessa> remessas) {
		System.out.println("================= Remessas ================");
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
			
			System.out.printf("[CPF] = %s %s\n", r.getCPF(), validarCPF(r.getCPF())? "(Válido)":"(Inválido)");
			System.out.println("[Nome] = " + r.getNome());
			System.out.println("[Banco Pagamento] = " + r.getBancoPagamento());
			System.out.println("[Banco Recebimento] = " + r.getBancoPagamento());
			System.out.println("[Valor] = " + r.getValor());
			System.out.println("[Data] = " + r.getData());
			System.out.println("--- -------------------------------- ---");
		}
		System.out.println("=========================================");
	}

	public static boolean validarCPF(String cpf) {
		int[] pesos = {10,9,8,7,6,5,4,3,2};
		int[] npesos = {11,10,9,8,7,6,5,4,3,2};
		char[] cpfArray = cpf.toCharArray();
		int soma = 0, primeiroDigito, segundoDigito;
		
		for(int i = 0; i < 9; i++) {
			soma += Character.getNumericValue(cpfArray[i]) * pesos[i];
		}
		
		primeiroDigito = soma % 11 < 2 ? 0 : 11 - soma % 11;
		
		soma = 0;
		for(int i = 0; i < 10; i++) {
			soma += Character.getNumericValue(cpfArray[i]) * npesos[i];
		}
		
		segundoDigito = soma % 11 < 2 ? 0 : 11 - soma % 11;
		
		return (Character.getNumericValue(cpfArray[9]) == primeiroDigito && 
				Character.getNumericValue(cpfArray[10]) == segundoDigito);
	}
}