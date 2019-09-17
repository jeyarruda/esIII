package br.com.estacionamento;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import javax.swing.JOptionPane;

public class App {

	
	
    public static void main(String[] args) {
    	boolean isParked = true;
		
    	ContaEstacionamento conta = new ContaEstacionamento (); 
    	Veiculo veiculo;

    	
    	LocalDateTime inicio = conta.getStartTime();
		String veiculoTipo = JOptionPane.showInputDialog("Bem vindo ao sistema! "
				+ "\nInforme qual tipo de veiculo correspondente: "
				+ "\n1 - Passeio"
				+ "\n2 - Carga");
		if(veiculoTipo.equals("1")) {
			String passeioTipo = JOptionPane.showInputDialog("Informe qual tipo de veiculo correspondente: "
					+ "\n1 - Comuns"
					+ "\n2 - Van ou ônibus");
			if(passeioTipo.equals("1")) {
		    	veiculo = new Passeio("comum");
			}else {
				veiculo = new Passeio("van");
			}
		}else {
			double cargaValor = Double.parseDouble(JOptionPane.showInputDialog("Informe qual o valor da carga: "));
			int cargaEixo = Integer.parseInt(JOptionPane.showInputDialog("Informe a quantidade de eixos do veículo: "));
			veiculo = new Carga(cargaValor, cargaEixo);
		}
		conta.setVeiculo(veiculo);
    	
    	while(isParked) {
    		String op = JOptionPane.showInputDialog("Digite '0' para sair ");
        	if(op.equals("0") ) {
        		LocalDateTime fim = conta.getFinalTime();

            	LocalDateTime tempDateTime = LocalDateTime.from( inicio );
            	LocalDateTime toDateTime = LocalDateTime.from( fim );


            	long years = tempDateTime.until( toDateTime, ChronoUnit.YEARS);
            	tempDateTime = tempDateTime.plusYears( years );

            	long months = tempDateTime.until( toDateTime, ChronoUnit.MONTHS);
            	tempDateTime = tempDateTime.plusMonths( months );

            	long days = tempDateTime.until( toDateTime, ChronoUnit.DAYS);
            	tempDateTime = tempDateTime.plusDays( days );


            	long hours = tempDateTime.until( toDateTime, ChronoUnit.HOURS);
            	tempDateTime = tempDateTime.plusHours( hours );

            	long minutes = tempDateTime.until( toDateTime, ChronoUnit.MINUTES);
            	tempDateTime = tempDateTime.plusMinutes( minutes );

            	long seconds = tempDateTime.until( toDateTime, ChronoUnit.SECONDS);

            	System.out.println( "você estacionou seu carro por "+years + " anos " + 
            	        months + " meses " + 
            	        days + " dias " +
            	        hours + " horas " +
            	        minutes + " minutos " +
            	        seconds + " segundos.");
            	
            	
            	conta.calculateResults();
            	
            	isParked = false;

            }
    	}
    }
}
