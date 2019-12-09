import models.*;

import java.util.Formatter;

import javax.swing.JOptionPane;

import functions.*;
import functions.Relatorio;

public class main {

    public static void main(String[] args) {

       Client c1 = new Client("Monica","35195705","Rua Abilia Machado", "3333333333");
       Car car1 = new Car("ekz-1111","Cadilac", 1995,500.00,c1);

       Agendamentos agendamento1 = new Agendamentos(car1, "26/11/2020");
       
//       Relatorio relatorio1 = new Relatorio(relatorio1);
         
       try
       {
    	 String nomeArq = "relatorio.txt";
         Formatter saida = new Formatter(nomeArq);
         saida.format("Nome: "+ c1.getNome() + " Cpf: " + c1.getCpf());
         saida.close();
         JOptionPane.showMessageDialog(null,"Arquivo '"+nomeArq+"' criado!","Arquivo",1);
       }
       //mostrando erro em caso se nao for possivel gerar arquivo
       catch(Exception erro){
         JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
       }
       
        System.out.println(
                agendamento1.getCar().getDono().getNome()  +"\n"+
                        agendamento1.getDataAgendamento() +"\n"+
                        agendamento1.getCar().getModelo()
        );
    }
}


