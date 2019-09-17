package br.com.estacionamento;
import java.time.LocalDateTime;
import java.util.Date;


public class ContaEstacionamento {
	@SuppressWarnings("unused")
	private CalculoValor calculo;
	private Veiculo veiculo;
	private Date inicio; 
	private Date fim; 
	double tempo;
	final int HORA = 3600000;
	final int DIA = 86400000;
	final long MES = 2628000000L;
	
	public ContaEstacionamento() {
		super();
	} 
	
	public LocalDateTime getStartTime() {
		inicio = new Date(); 
		LocalDateTime now = LocalDateTime.now();
    	int year = now.getYear();
    	int month = now.getMonthValue();
    	int day = now.getDayOfMonth();
    	int hour = now.getHour();
    	int minute = now.getMinute();
    	int second = now.getSecond();

    	LocalDateTime fromDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
    	return fromDateTime;
	}
	
	public LocalDateTime getFinalTime() {
		fim = new Date();
		tempo = fim.getTime()-inicio.getTime();
		LocalDateTime now = LocalDateTime.now();
    	int year = now.getYear();
    	int month = now.getMonthValue();
    	int day = now.getDayOfMonth();
    	int hour = now.getHour();
    	int minute = now.getMinute();
    	int second = now.getSecond();

    	LocalDateTime fromDateTime = LocalDateTime.of(year, month, day, hour, minute, second);
    	return fromDateTime;
	}


	
	public void calculateResults() {
		if(veiculo instanceof Passeio) {
			CalculoPasseio passeio = new CalculoPasseio(); 
			passeio.imprimir(veiculo,tempo);
		}else{
			CalculoCarga carga = new CalculoCarga(); 
			carga.imprimir(veiculo, tempo);
		}
	}
	
	public void setVeiculo(Veiculo veiculo) {
		this.veiculo = veiculo;
	}
	
	
	
}
