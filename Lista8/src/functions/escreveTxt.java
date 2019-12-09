package functions;

 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
 import java.io.IOException;
 import java.io.PrintWriter;
 
 
public class escreveTxt {
	public static void criar() throws IOException {
//		FileWriter arq = null;
//		try {
//			arq = new FileWriter("relatorio.txt");
//		} catch (IOException e) {
//			 TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		PrintWriter gravarArq = new PrintWriter("relatorio.txt","UTF-8");
//		
//		gravarArq.println("abc");
//		gravarArq.println("abc");
//
//		gravarArq.close();
//		
//		System.out.print("abc");
		
		 // Cria arquivo
        File file = new File("C:\\Users\\Aluno\\Downloads\\teste\\teste\\teste\\relatorio.txt");

        // Se o arquivo nao existir, ele gera
        if (!file.exists()) {
            file.createNewFile();
        }

        // Prepara para escrever no arquivo
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        
        // Escreve e fecha arquivo
        bw.write("abc");
        bw.close();
        
        // Le o arquivo
        FileReader ler = new FileReader("relatorio.txt");
        BufferedReader reader = new BufferedReader(ler);  
        String linha;
        while( (linha = reader.readLine()) != null ){
            System.out.println(linha);
        }

        // Imprime confirmacao
        System.out.println("Feito =D");

    } 
    }


	


