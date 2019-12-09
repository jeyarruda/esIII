package functions;

import models.Car;

public class Agendamentos {

    Car car;
    String dataAgendamento;


    public Agendamentos(Car car, String dataAgendamento) {
        this.car = car;
        this.dataAgendamento = dataAgendamento;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public String getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(String dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }
}
