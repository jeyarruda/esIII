package trabalho.salao_beleza;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONWriter {

	public void writeCliente(Cliente cliente) {
	
		ArrayList<JSONObject> jsonClienteList = getJSONList();
		JSONObject jsonCliente = new JSONObject();
		jsonCliente.put("nome", cliente.getNome());
		jsonCliente.put("telefone", cliente.getTelefone());
		jsonCliente.put("genero", cliente.getGenero());
		jsonCliente.put("dataNascimento", cliente.getDataNascimento());
		jsonCliente.put("servicos", cliente.getServico());
		jsonClienteList.add(jsonCliente);

		JSONObject finalList = new JSONObject();
		finalList.put("clientes", jsonClienteList);

		try {
			FileWriter writeFile = new FileWriter("saida.json");
			// Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(finalList.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<JSONObject> getJSONList() {
		JSONParser parser = new JSONParser();
		JSONObject jsonArquivo;
		try {
			jsonArquivo = (JSONObject) parser.parse(new FileReader("saida.json"));
		} catch (Exception e1) {
			jsonArquivo = null;
		}
		return (jsonArquivo == null) ? new ArrayList<JSONObject>() :  (ArrayList<JSONObject> ) jsonArquivo.get("clientes");
	}

	public JSONObject getClientByTelephone(Long telefone) {
		ArrayList<JSONObject> clientList = getJSONList();
		Optional<JSONObject> client = clientList.stream().filter(c -> (Long) c.get("telefone") == telefone.longValue()).findFirst();
		if(client.isPresent())
			return client.get();

		return null;
	}

	public void updateClientList(ArrayList<JSONObject> clientListUpdated) {
		JSONObject finalList = new JSONObject();
		finalList.put("clientes", clientListUpdated);

		try {
			FileWriter writeFile = new FileWriter("saida.json");
			// Escreve no arquivo conteudo do Objeto JSON
			writeFile.write(finalList.toJSONString());
			writeFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
