package models;

public class Client {
    String nome;
    String tel;
    String end;
    String cpf;

    public Client(String nome, String tel, String end, String cpf) {
        this.nome = nome;
        this.tel = tel;
        this.end = end;
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }

    public String getEnd() {
        return end;
    }

    public String getCpf() {
        return cpf;
    }
}
