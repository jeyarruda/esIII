package br.com.febraban;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;

public class JSONReader implements ArquivoBancario {
	ArrayList<Pagamento> pagamentos;
	
	@Override
	public ArrayList<Pagamento> readFile(String src) {
		Gson gson = new Gson();
		JsonObject[] transacoes;
		pagamentos = new ArrayList<Pagamento>();
		
		try {
			transacoes = gson.fromJson(new BufferedReader(new FileReader(src)), JsonObject[].class);
			
			for (int i = 0; i < transacoes.length; i++) {
				JsonObject t = transacoes[i];
				
				Pagamento p = new Pagamento();
				
				String id, titular;
				if(t.get("numeroBoleto") != null) {
					id = t.get("numeroBoleto").toString();
					titular = t.get("nome").getAsString();
				} else {
					id = t.get("numeroCartao").getAsString();
					titular = t.get("nomeTitular").getAsString();
					if(t.get("parcelas") != null) p.setParcelas(t.get("parcelas").getAsInt());
				}
				
				p.setId(id);
				p.setNomeTitular(titular);
				p.setBancoPagamento(t.get("bancoPagamento").getAsString());
				p.setBancoRecebimento(t.get("bancoRecebimento").getAsString());
				p.setCpfTitular(t.get("CPF").getAsString());
				p.setData(t.get("data").getAsString());
				p.setValor(t.get("valor").getAsDouble());
				
				pagamentos.add(p);
			}
		} catch (JsonSyntaxException e) {
			System.out.println("Erro JsonSyntax\n[" + e.getMessage() + "]");
		} catch (JsonIOException e) {
			System.out.println("Erro JsonIO\n[" + e.getMessage() + "]");
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo ausente\n[" + e.getMessage() + "]");
		}
		return pagamentos;
	}
}