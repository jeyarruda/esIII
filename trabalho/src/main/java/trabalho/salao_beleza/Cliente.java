package trabalho.salao_beleza;

import java.util.ArrayList;

public class Cliente {

	private String _nome;
	private String _genero;
	private Long _telefone;
	private String _dataNascimento;
	private ArrayList<String> _servico = new ArrayList<String>();

	public String getNome() {
		return _nome;
	}
	public void setNome(String _nome) {
		this._nome = _nome;
	}
	public String getGenero() {
		return _genero;
	}
	public void setGenero(String _genero) {
		this._genero = _genero;
	}
	public Long getTelefone() {
		return _telefone;
	}
	public void setTelefone(Long _telefone) {
		this._telefone = _telefone;
	}
	public String getDataNascimento() {
		return _dataNascimento;
	}
	public void setDataNascimento(String _dataNascimento) {
		this._dataNascimento = _dataNascimento;
	}
	public ArrayList<String> getServico() {
		return _servico;
	}
	public void addServico (String pServico) {
		this._servico.add(pServico);
	}
}
