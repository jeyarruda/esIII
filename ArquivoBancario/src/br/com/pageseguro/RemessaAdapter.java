package br.com.pageseguro;

import br.com.pageseguro.remessas.Remessa;

public class RemessaAdapter extends RemessaFebraban {
	
	public RemessaAdapter(Remessa r) {
		super(r);
	}

	@Override
	public String getDataFebrabanJSON() {
		// "Sep 1, 2018 11:54:13 PM".split(",");
		String[] data = remessa.getData().split(",");
		String mes = data[0].split(" ")[0];
		String dia = data[0].split(" ")[1];
		String horario = data[1].split(" ")[2];
		String hora = horario.substring(0,2);
		String ano = data[1].split(" ")[1];
		String periodo = data[1].split(" ")[3];
		
		return String.format("%s de %s de %s às %s",
			dia,
			meses.get(mes),
			ano,
			periodo.equals("PM")? horasPM.get(hora) + horario.substring(2) : horario);
	}

	@Override
	public String getDataFebrabanXML() {
		// 2018-09-02 02:58:10.96 UTC
		String[] data = remessa.getData().split(" ");
		String ano = data[0].split("-")[0];
		String mes = data[0].split("-")[1];
		String dia = data[0].split("-")[2];
		String horario = data[1];
		
		return String.format("%s/%s/%s às %s",
			dia,
			mes,
			ano,
			horario);
	}
}