package trabalho.salao_beleza;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import org.json.simple.JSONObject;

public class MenuRelatorios implements Menu{

	@Override
	public void printOptions() {
		System.out.println("1 - Veja média de idade do público");
		System.out.println("2 - Veja média de idade do público por gênero");
		System.out.println("3 - Veja o serviço mais consumido do público");
		System.out.println("4 - Veja o serviço mais consumido do público por gênero");
		System.out.println("5 - Voltar");
		
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
			applyOption4();
		
		if(pOption == 5)
			return new MenuPrincipal();

		return new MenuRelatorios();
	}

	public void applyOption1() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		int totalAges = 0;
		for(JSONObject json : clientList) {
			System.out.println((String) json.get("dataNascimento"));
			LocalDate birthdayDate =LocalDate.parse((String) json.get("dataNascimento"));
			
			totalAges += Period.between(birthdayDate, LocalDate.now()).getYears();
		}
		int media = totalAges / clientList.size();
		System.out.println("Média de idade do público: "+ media);
	}
	
	public void applyOption2() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		ArrayList<JSONObject> genderList = new ArrayList<>();
		String genero;
		teclado.useDelimiter("\n");
		System.out.println("Digite o gênero: masculino ou feminino");
		genero = teclado.next();
		for(JSONObject client : clientList) {
			String gender = (String) client.get("genero");
			if(gender.equals(genero)) {
				genderList.add(client);
			}
		}
		
		int totalAges = 0;
		for(JSONObject json : genderList) {
			System.out.println((String) json.get("dataNascimento"));
			LocalDate birthdayDate =LocalDate.parse((String) json.get("dataNascimento"));
			
			totalAges += Period.between(birthdayDate, LocalDate.now()).getYears();
		}
		int media = totalAges / genderList.size();
		System.out.println("Média de idade do público: "+ media);
	}
	
	public void applyOption3() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		ArrayList<String> servicosTotal = new ArrayList<>();
		for(JSONObject json : clientList) {
			ArrayList<String> servicos = (ArrayList<String>) json.get("servicos");
			servicosTotal.addAll(servicos);
		}
		servicosTotal.stream()
					 .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
					 .entrySet()
					 .stream()
					 .max(Comparator.comparing(Entry::getValue))
					 .ifPresent(System.out::println);
	}
	
	public void applyOption4() {
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		ArrayList<JSONObject> genderList = new ArrayList<>();
		String genero;
		teclado.useDelimiter("\n");
		System.out.println("Selecione o gênero: masculino ou feminino");
		genero = teclado.next();
		for(JSONObject item : clientList) {
			String gender = (String) item.get("genero");
			if(gender.equals(genero)) {
				genderList.add(item);
			}
		}
		
		
		ArrayList<String> servicosTotal = new ArrayList<>();
		for(JSONObject json : genderList) {
			ArrayList<String> servicos = (ArrayList<String>) json.get("servicos");
			servicosTotal.addAll(servicos);
		}
		servicosTotal.stream()
					 .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
					 .entrySet()
					 .stream()
					 .max(Comparator.comparing(Entry::getValue))
					 .ifPresent(System.out::println);
	}
	
}
