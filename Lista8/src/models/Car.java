package models;

public class Car {

    String placa;
    String modelo;
    int ano;
    double valor;
    Client dono;

    public Car(String placa, String modelo, int ano, double valor, Client dono) {
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.valor = valor;
        this.dono = dono;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Client getDono() {
        return dono;
    }

    public void setDono(Client dono) {
        this.dono = dono;
    }




//    Número da placa
//◦ Modelo/versão
//◦ Ano de fabricação
//◦ Valor de compra

}
