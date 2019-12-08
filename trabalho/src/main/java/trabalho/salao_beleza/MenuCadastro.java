package trabalho.salao_beleza;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class MenuCadastro implements Menu {

	public void printOptions() {
		 System.out.println( "========= MENU CADASTRO =========" );
	     System.out.println("Selecione as seguintes opções para navegar");
	     System.out.println("1 - Cadastrar Novo Cliente");
	     System.out.println("2 - Editar Cadastro/Adicionar Serviço");
	     System.out.println("3 - Remover Cadastro");
	     System.out.println("4 - Voltar");
	     System.out.println();
	     System.out.println("Digite: ");
		
	}

	public Menu applyOption(int pOption) {
		if(pOption == 1)
			applyOption1();

		if(pOption == 2)
			applyOption2();
		
		if(pOption == 3)
			applyOption3();

		if(pOption == 4)
			return new MenuPrincipal();
		
		return new MenuCadastro();
	}
	
	private void applyOption1() {
		String nome, genero, dataNascimento;
		Long telefone, numServicos;
		teclado.useDelimiter("\n");
		System.out.println("Digite o nome");
		nome = teclado.next();
		System.out.println("Digite o telefone");
		telefone = teclado.nextLong();
		System.out.println("1 - Feminino | 2 - Masculino");
		int optionGenero = teclado.nextInt();
		genero = (optionGenero == 1) ? "feminino" : "masculino";
		System.out.println("Digite data de nascimento (AAAA-MM-DD):");
		dataNascimento = teclado.next();
		showServicos();
		System.out.println("Digite a quantidade de serviços consumidos");
		numServicos = teclado.nextLong();

		Cliente cliente = new Cliente();
		for(int index = 0; index < numServicos; index++) {
			System.out.println("Digite o nome do serviço: ");
			String nomeServico = teclado.next();
			cliente.addServico(nomeServico);
		}
		cliente.setNome(nome);
		cliente.setGenero(genero);
		cliente.setDataNascimento(dataNascimento);
		cliente.setTelefone(telefone);
		jsonWriter.writeCliente(cliente);
	}

	private void applyOption2() {
		Long telefone, option, numServicos;
		String nome, genero, dataNascimento;
		teclado.useDelimiter("\n");
		System.out.println("Digite o telefone");
		telefone = teclado.nextLong();
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		JSONObject client = jsonWriter.getClientByTelephone(telefone);
		
		if(client == null)
			System.out.println("Cliente não encontrado");
		else {
			clientList.remove(client);
			nome = (String) client.get("nome");
			genero = (String) client.get("genero");
			dataNascimento = (String) client.get("dataNascimento");
			telefone = (Long) client.get("telefone");
			ArrayList<String> listServicos = (ArrayList<String>) client.get("servicos");

			nome = showUpdateOption("Nome", nome);
			genero = showUpdateOption("Genero", genero);
			dataNascimento = showUpdateOption("Data de Nascimento", dataNascimento);
			
			System.out.println("Telefone: " + telefone + "Atualizar - Digite 1 | Pular - Digite 2");
			option = teclado.nextLong();
			if(option == 1) {
				System.out.println("Digite o novo telefone");
				telefone = teclado.nextLong();
			}
			
			showServicos();
			System.out.println("Digite a quantidade de serviços consumidos");
			numServicos = teclado.nextLong();
			for(int index = 0; index < numServicos; index++) {
				System.out.println("Digite o nome do serviço: ");
				String nomeServico = teclado.next();
				listServicos.add(nomeServico);
			}
			
			client.put("nome", nome);
			client.put("genero", genero);
			client.put("dataNascimento", dataNascimento);
			client.put("telefone", telefone);
			client.put("servicos", listServicos);
			clientList.add(client);
			jsonWriter.updateClientList(clientList);
			System.out.println("Cliente atualizado");
		}
	}

	private void applyOption3() {
		Long telefone, option, numServicos;
		String nome, genero, dataNascimento;
		teclado.useDelimiter("\n");
		System.out.println("Digite o telefone");
		telefone = teclado.nextLong();
		ArrayList<JSONObject> clientList = jsonWriter.getJSONList();
		JSONObject client = jsonWriter.getClientByTelephone(telefone);
		
		if(client == null)
			System.out.println("Cliente não encontrado");
		else {
			clientList.remove(client);
			jsonWriter.updateClientList(clientList);
			System.out.println("Cliente removido!");
		}
	}
			
	/**
	 * Mostra a opção para atualizar o nome e atualiza de acordo.
	 *
	 * @param optionName
	 * @param nome
	 * @return
	 */
	public String showUpdateOption(String optionName, String nome) {
		Long option;
		System.out.println(optionName + " " + nome + " " + "Atualizar - Digite 1 | Pular - Digite 2");
		option = teclado.nextLong();
		if(option == 1) {
			System.out.println("Digite o " + optionName + " :");
			return teclado.next();
		}
		return nome;
	}

	public void showServicos() {
		System.out.println("Lista de serviços disponíveis ");
		System.out.println("1 - Manicure");
		System.out.println("2 - Pedicure");
		System.out.println("3 - Design de sobrancelhas");
		System.out.println("4 - Corte de cabelo");
		System.out.println("5 - Pintura de cabelo");
		System.out.println("6 - Remoção de rugas");
		System.out.println("7 - Remoção de manchas de pele");
		System.out.println("8 - Aplicação de Botox");
		System.out.println("9 - Tratamento para emagrecimento");
		System.out.println("10 - Redução de medidas");
		System.out.println("11 - Corte de cabelo masculino");
		System.out.println("12 - Corte de barba");
		System.out.println("13 - Tratamento de queda");
		System.out.println("14 - Produtos");
	}
}
