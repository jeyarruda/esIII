package br.com.febraban;

import java.util.ArrayList;

public class Run {
	public static void main(String[] args) {
		JSONReader jra = new JSONReader();
		ArrayList<Pagamento> pagamentos = jra.readFile("files/remessa.json");
		
		for(Pagamento p : pagamentos) {
			DataPagamentoAdapter dataAdapter = new DataPagamentoAdapter(p);
			System.out.println(dataAdapter.getDataFebraban());
		}
	}
}