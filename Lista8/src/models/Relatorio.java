package models;

import models.Car;
import models.Client;

public class Relatorio{
	 Car car;
	 String relatorio;
	 String dataRevisao;
	public Relatorio(Car car, String dataRevisao, String relatorio) {
		 this.car = car;
		 this.dataRevisao = dataRevisao;
		 this.relatorio = relatorio;
	 }


	public Relatorio(Relatorio relatorio2) {
		// TODO Auto-generated constructor stub
	}


	public Car getCar() {
		return car;
	}


	public void setCar(Car car) {
		this.car = car;
	}


	public String getRelatorio() {
		return relatorio;
	}


	public void setRelatorio(String relatorio) {
		this.relatorio = relatorio;
	}


	public String getDataRevisao() {
		return dataRevisao;
	}


	public void setDataRevisao(String dataRevisao) {
		this.dataRevisao = dataRevisao;
	}
	
	public void changeDataRevisao(String newDate) {
		setDataRevisao(newDate);
	}
	
	public void cancelDataRevisao(String dataRevisao) {
	}


	public void write(String relatorio2) {
		// TODO Auto-generated method stub
		
	}


	public void close() {
		// TODO Auto-generated method stub
		
	}
		 
	 
//	 public Car getCar() {
//		 return car;
//			 
//		 }
//		 
//	public void setCar(Car car) {
//        this.car = car;	 
//	 }
//	
//	public String getdatarelatorio() {
//		return datarelatorio;
//	}
//	
//	public void setrelatorio(String datarelatorio) {
//		this.datarelatorio = datarelatorio;
//	}
//	
	

}
