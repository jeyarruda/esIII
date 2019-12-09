package functions;
import models.Relatorio;
import javax.swing.*;
import java.util.Formatter; //formatar arquivo
public class criaTxt{
    
  public static void main(String[] args){
    String nomeArq="relatorio.txt";
    //tentando criar arquivo
    try
    {
      Formatter saida = new Formatter(nomeArq);
      saida.format("Arquivo gerado automaticamente!");
      saida.close();
      JOptionPane.showMessageDialog(null,"Arquivo '"+nomeArq+"' criado!","Arquivo",1);
    }
    //mostrando erro em caso se nao for possivel gerar arquivo
    catch(Exception erro){
      JOptionPane.showMessageDialog(null,"Arquivo nao pode ser gerado!","Erro",0);
    }
  } 
}


























//package functions;  
  
//public class Arquivo {
	
//	    private static final String Relatorio = null;

//		public void main(String[] args) {  
//	        String textoQueSeraEscrito = "Texto que sera escrito.";  
	          
//	        Relatorio arquivo;  
	          
//	        try {  
//	            arquivo = new Relatorio(new Relatorio(null, "Arquivo.txt", textoQueSeraEscrito));  
//	            arquivo.write(Relatorio);  
//	            arquivo.close();  
//	        } catch (Exception e) {  
//	            e.printStackTrace();  
//	        }  
	          
//	    }  
//	}  


