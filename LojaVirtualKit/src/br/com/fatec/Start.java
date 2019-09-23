package br.com.fatec;

import java.util.ArrayList;
import java.util.List;

public class Start {
	public static void main(String[] args) {
		CalculadorPreco calculador = null;
		CalculoDesconto calculo = null;
		//p1
		Produto notebook = new ProdutoUnitario("Dell Inspiron 5100", 5200.00);
		notebook.setDescricao("Intel i7 8ª geração, 8GB de RAM, HD SSD 1TB e Windows 10");
		
		calculo = new ValorFixo(new Desconto(5));
		calculador = new CalculadorPreco(notebook, calculo);
		
		System.out.println(notebook.getDescricao() + "\nValor Total: R$" + calculador.calcularDescontos());
		
		// p2
		Produto mouse = new ProdutoUnitario("Razer Deathadder Elite Destiny 2", 339.00);
		mouse.setDescricao("Mouse gamer de 16.000 DPI com chroma colors e 7 botões");
		
		calculo = new ValorPorcentagem(new Desconto(10));
		calculador = new CalculadorPreco(mouse, calculo);
		System.out.println("\n" + mouse.getDescricao() + "\nValor Total: R$" + calculador.calcularDescontos());
		
		//lp1
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(notebook);
		produtos.add(mouse);
		
		List<Desconto> descontos = new ArrayList<Desconto>();
		descontos.add(new Desconto(10));
		descontos.add(new Desconto(10));
		
		Produto kitGamer = new ProdutoComposto("Kit Gamer", produtos, descontos);
		kitGamer.setDescricao("Kit contendo um notebook Dell e um mouse Razer");
		
		calculo = new ValorPorcentagem(new Desconto(((ProdutoComposto) kitGamer).calcularDescontoTotal()));
		calculador = new CalculadorPreco(kitGamer, calculo);
		System.out.println("\n" + kitGamer.getDescricao() + "\n" + "Valor Total: R$" + calculador.calcularDescontos());
	}
}