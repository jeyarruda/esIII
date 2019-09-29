package br.com.pageseguro;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import com.thoughtworks.xstream.XStream;

import br.com.pageseguro.remessas.Remessa;
import br.com.pageseguro.remessas.Remessas;
import br.com.pageseguro.remessas.RemessaBoleto;
import br.com.pageseguro.remessas.RemessaCartaoCredito;
import br.com.pageseguro.remessas.RemessaCartaoDebito;

public class PagamentoXML implements PagamentoArquivo {
	List<Remessa> remessas;
	
	@Override
	public List<Remessa> lerRemessas(String src) {
		XStream xstream = new XStream();

		try {
			xstream.alias("list", Remessas.class);
			xstream.alias("br.com.pageseguro.RemessaCartaoCredito", RemessaCartaoCredito.class);
			xstream.alias("br.com.pageseguro.RemessaCartaoDebito", RemessaCartaoDebito.class);
			xstream.alias("br.com.pageseguro.RemessaBoleto", RemessaBoleto.class);
			xstream.addImplicitCollection(Remessas.class, "remessasCredito", RemessaCartaoCredito.class);
			xstream.addImplicitCollection(Remessas.class, "remessasDebito", RemessaCartaoDebito.class);
			xstream.addImplicitCollection(Remessas.class, "remessasBoleto", RemessaBoleto.class);
			xstream.addImplicitCollection(Remessas.class, "remessas", Remessa.class);
			
			Remessas remessasList = (Remessas) xstream.fromXML(new FileReader(src));
			
			remessas = remessasList.getRemessas();
			for(int i = 0; i < remessas.size(); i++) {
				Remessa novaRemessa = adaptarRemessa(remessas.get(i));
				remessas.set(i, novaRemessa);
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo ausente\n [" + e.getMessage() + "]");
		}
		return remessas;
	}

	private Remessa adaptarRemessa(Remessa r) {
		PagamentoAdapter padpt = new PagamentoAdapter(r);
		r.setData(padpt.getDataFebrabanXML());
		return r;
	}
}