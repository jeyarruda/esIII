package br.com.pageseguro;

import java.util.HashMap;

import br.com.pageseguro.remessas.Remessa;

public abstract class RemessaFebraban {
	protected Remessa remessa;
	
	protected final HashMap<String, String> meses = new HashMap<String, String>() {
		{
			put("Jan", "Jan");
			put("Feb", "Fev");
			put("Mar", "Mar");
			put("Apr", "Abr");
			put("May", "Mai");
			put("Jun", "Jun");
			put("Jul", "Jul");
			put("Aug", "Ago");
			put("Sep", "Set");
			put("Oct", "Out");
			put("Nov", "Nov");
			put("Dec", "Dez");
		}
	};
	
	protected final HashMap<String, String> horasPM = new HashMap<String, String>() {
		{
			put("1", "13");
			put("2", "14");
			put("3", "15");
			put("4", "16");
			put("5", "17");
			put("6", "18");
			put("7", "19");
			put("8", "20");
			put("9", "21");
			put("10", "22");
			put("11", "23");
		}
	};
	
	public RemessaFebraban(Remessa remessa) {
		this.remessa = remessa;
	}
	
	public abstract String getDataFebrabanJSON();
	
	public abstract String getDataFebrabanXML();
	
	public Remessa getPagamento() {
		return remessa;
	}
}