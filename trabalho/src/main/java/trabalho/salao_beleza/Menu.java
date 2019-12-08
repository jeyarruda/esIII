package trabalho.salao_beleza;

import java.util.Scanner;

public interface Menu {

	public static final Scanner teclado = new Scanner(System.in);
	
	public static final JSONWriter jsonWriter = new JSONWriter();

	void printOptions();

	Menu applyOption(int pOption); 
}
