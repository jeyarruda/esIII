package trabalho.salao_beleza;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;

public class MenuListagem implements Menu {

	@Override
	public void printOptions() {
		 System.out.println( "========= MENU LISTAGEM =========" );
	     System.out.println("Selecione as seguintes opções para navegar");
	     System.out.println("1 - Listar todos os clientes");
	     System.out.println("2 - Listar todos os clientes por gênero");
	     System.out.println("3 - Listar serviços por cliente");
	     System.out.println("4 - Voltar");
	     System.out.println();
	     System.out.println("Digite: ");
		
	}

	@Override
	public Menu applyOption(int pOption) {
		if(pOption == 1)
			applyOption1();
		if(pOption == 2)
			applyOption2();
		if(pOption == 3)
			applyOption3();
		if(pOption == 4)
			return new MenuPrincipal();

		return new MenuListagem();
	}

	public void applyOption1() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		List<JSONObject> sortedList = clientList.stream()
				.sorted((o1, o2) -> ((String) o1.get("nome")).toLowerCase().compareTo(((String) o2.get("nome")).toLowerCase()))
				.collect(Collectors.toList());
		for(JSONObject json : sortedList) {
			System.out.println("Nome: " + (String) json.get("nome"));
		}
	}
	
	public void applyOption2() {
		String genero;
		teclado.useDelimiter("\n");
		System.out.println("Selecione o gênero: masculino ou feminino");
		genero = teclado.next();
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		List<JSONObject> sortedList = clientList.stream()
				.sorted((o1, o2) -> ((String) o1.get("nome")).toLowerCase().compareTo(((String) o2.get("nome")).toLowerCase()))
				.collect(Collectors.toList());
		
		List<JSONObject> genderList = new ArrayList<>();
		for(JSONObject item : sortedList) {
			String gender = (String) item.get("genero");
			if(gender.equals(genero)) {
				genderList.add(item);
			}
		}
		for(JSONObject json : genderList) {
			System.out.println("Nome: " + (String) json.get("nome"));
		}
		
	}
	
	public void applyOption3() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();

		for(JSONObject client : clientList) {
			System.out.println("Cliente: " + (String) client.get("nome"));
			ArrayList<String> servicos = (ArrayList<String>) client.get("servicos");
			if(servicos == null) {
				System.out.println("Nao ha serviços para esse cliente");
			}
			else {
				for(String servico : servicos) {
					System.out.println(servico);
				}
			}
		}
	}
}
