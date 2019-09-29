package br.com.pageseguro;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

import br.com.pageseguro.remessas.Remessa;
import br.com.pageseguro.remessas.RemessaBoleto;
import br.com.pageseguro.remessas.RemessaCartaoCredito;
import br.com.pageseguro.remessas.RemessaCartaoDebito;

public class RemessaJSON implements RemessaArquivo {
	private List<Remessa> remessas = new ArrayList<Remessa>();
	
	@Override
	public List<Remessa> lerRemessas(String src) {
		Gson gson = new Gson();
		JsonObject[] remessasJson;
		
		try {
			remessasJson = gson.fromJson(new BufferedReader(new FileReader(src)), JsonObject[].class);
			
			for (int i = 0; i < remessasJson.length; i++) {
				JsonObject t = remessasJson[i];
				
				Remessa r = new Remessa();
				r = initAtributos(t);
				
				if(t.get("numeroBoleto") != null) {
					RemessaBoleto rb = copiarAtributosBoleto(r);
					rb.setNumeroBoleto(t.get("numeroBoleto").getAsString());
					
					remessas.add(rb);
				} else if(t.get("parcelas") != null) {
					RemessaCartaoCredito rcc = copiarAtributosCartaoCredito(r);
					rcc.setNumeroCartao(t.get("numeroCartao").getAsString());
					rcc.setParcelas(t.get("parcelas").getAsInt());
					rcc.setNomeTitular(t.get("nomeTitular").getAsString());
					
					remessas.add(rcc);
				} else {
					RemessaCartaoDebito rcd = copiarAtributosCartaoDebito(r);
					rcd.setNumeroCartao(t.get("numeroCartao").getAsString());
					rcd.setNomeTitular(t.get("nomeTitular").getAsString());
					
					remessas.add(rcd);
				}
			}
		} catch (JsonSyntaxException e) {
			System.out.println("Erro JsonSyntax\n[" + e.getMessage() + "]");
		} catch (JsonIOException e) {
			System.out.println("Erro JsonIO\n[" + e.getMessage() + "]");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo ausente\n[" + e.getMessage() + "]");
		}
		return remessas;
	}
	
	private Remessa initAtributos(JsonObject t) {
		Remessa r = new Remessa();
		r.setCPF(t.get("CPF").getAsString());
		r.setNome(t.get("nome").getAsString());
		r.setBancoPagamento(t.get("bancoPagamento").getAsString());
		r.setBancoRecebimento(t.get("bancoRecebimento").getAsString());
		r.setValor(t.get("valor").getAsDouble());
		r.setData(t.get("data").getAsString());
		r = adaptarRemessa(r);
		return r;
	}
	
	private RemessaBoleto copiarAtributosBoleto(Remessa r) {
		RemessaBoleto rb = new RemessaBoleto();
		rb.setCPF(r.getCPF());
		rb.setNome(r.getNome());
		rb.setBancoPagamento(r.getBancoPagamento());
		rb.setBancoRecebimento(r.getBancoRecebimento());
		rb.setData(r.getData());
		rb.setValor(r.getValor());
		return rb;
	}
	
	private RemessaCartaoCredito copiarAtributosCartaoCredito(Remessa r) {
		RemessaCartaoCredito rcc = new RemessaCartaoCredito();
		rcc.setCPF(r.getCPF());
		rcc.setNome(r.getNome());
		rcc.setBancoPagamento(r.getBancoPagamento());
		rcc.setBancoRecebimento(r.getBancoRecebimento());
		rcc.setData(r.getData());
		rcc.setValor(r.getValor());
		return rcc;
	}
	
	private RemessaCartaoDebito copiarAtributosCartaoDebito(Remessa r) {
		RemessaCartaoDebito rcd = new RemessaCartaoDebito();
		rcd.setCPF(r.getCPF());
		rcd.setNome(r.getNome());
		rcd.setBancoPagamento(r.getBancoPagamento());
		rcd.setBancoRecebimento(r.getBancoRecebimento());
		rcd.setData(r.getData());
		rcd.setValor(r.getValor());
		return rcd;
	}
	
	private Remessa adaptarRemessa(Remessa r) {
		RemessaAdapter padpt = new RemessaAdapter(r);
		r.setData(padpt.getDataFebrabanJSON());
		return r;
	}
}