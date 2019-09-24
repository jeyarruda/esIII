package br.com.febraban;

public class DataPagamentoAdapter extends PagamentoFebraban {
	
	public DataPagamentoAdapter(Pagamento p) {
		super(p);
	}

	@Override
	public String getDataFebraban() {
		//String[] data = "Sep 1, 2018 11:54:13 PM".split(",");
		String[] data = pagamento.getData().split(",");
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
			periodo.equals("PM")? horas.get(hora) + horario.substring(2) : horario);
	}
}