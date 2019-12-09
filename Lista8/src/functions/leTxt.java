package functions;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import javax.swing.JOptionPane;

public class leTxt {
	
		  
		  private static BufferedReader leitor;

		public static void main(String[] args){
		    String mostra="";
		    String relatorio="relatorio.txt"; //Nome do arquivo, pode ser absoluto, ou pastas /dir/teste.txt
		    String linha="";
		    File arq = new File(relatorio);
		  
		    //Arquivo existe
		    if (arq.exists()){
		      mostra="Arquivo - '"+relatorio+"', aberto com sucesso!\n";
		      mostra+="Tamanho do arquivo "+Long.toString(arq.length())+"\n";
		      //tentando ler arquivo
		      try{
		        mostra+="Conteudo:relatorio.txt\n";
		        String nomeArq = "relatorio.txt";
				//abrindo arquivo para leitura
		        FileReader reader = new FileReader(nomeArq);
		        leitor = new BufferedReader(reader);
		        while(true){
		          linha=leitor.readLine();
		          if(linha==null)
		            break;
		          mostra+=linha+"\n";
		        }
		      }
		      catch(Exception erro) {}
		      JOptionPane.showMessageDialog(null,mostra,"Arquivo...",1);
		    }
		    //Se nao existir
		    else
		      JOptionPane.showMessageDialog(null,"Arquivo nao existe!","Erro",0);
		  }
		}

