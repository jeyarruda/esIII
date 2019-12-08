package trabalho.salao_beleza;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Menu menu = new MenuPrincipal();
    	int option;
    	do
    	{
    		menu.printOptions();
    		option = menu.teclado.nextInt();
    		menu = menu.applyOption(option);

    	}while(option != 0);
    	System.out.println("PROGRAMA ENCERRADO");
    }
}
