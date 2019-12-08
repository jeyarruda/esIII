package trabalho.salao_beleza;

public class MenuPrincipal implements Menu {

	public void printOptions() {
		 System.out.println( "========= AGENDA WB =========" );
	     System.out.println("Selecione as seguintes opções para navegar");
	     System.out.println("1 - Cadastro/Serviços");
	     System.out.println("2 - Listagem");
	     System.out.println("3 - Relatórios");
	     System.out.println("0 - Sair");
	     System.out.println();
	     System.out.println("Digite: ");
	}

	public Menu applyOption(int pOption) {
		if(pOption == 1)
			return new MenuCadastro();
		if(pOption == 2)
			return new MenuListagem();
		if(pOption == 3)
			return new MenuRelatorios();
		

		return new MenuPrincipal();
	 
	}

	
}
