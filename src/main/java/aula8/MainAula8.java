package aula8;

import java.util.ArrayList;
import java.util.Scanner;

public class MainAula8 {

	public static void main(String[] args) {
		 
		Scanner teclado = new Scanner(System.in);
		ArrayList<Produto> lista = new ArrayList<Produto>();
		
		while(true) {
			System.out.println("1. cadastrar ");
			System.out.println("2. listar ");
			System.out.println("3. sair ");
			String op = teclado.nextLine();
			if(op.equals("1")) {
				System.out.println("digite a string de cadastro ");
				String valor = teclado.nextLine();
				Produto produto = criarProduto(valor);
				if(produto == null) {
					System.out.println("string de cadastro invalido");
				}else {
					boolean r = validaProduto(produto, lista);
					if(r == false) {
						System.out.println("houve problemas de validacao no produto");
					}else {
						lista.add(produto);
						System.out.println("produto salvo com sucesso.");
					}
				}
			}else if(op.equals("2")) {
				listar(lista);
			}else if(op.equals("3")) {
				break;
			}else {
				System.out.println("opcao invalida ");
			}
		}

	}

	public static void listar(ArrayList<Produto> lista) {
		if(lista.isEmpty()) {
			System.out.println("Nenhum produto cadastrado.");
			return;
		}
		for (Produto produto : lista) {
			System.out.println("Código: " + produto.getCodigo());
			System.out.println("Nome Produto: " + produto.getNome()); 
			System.out.println("Preço: R$ " + produto.getPreco());

		}
	}
	
	public static Produto criarProduto(String valor) {
		String[] valores = valor.split(";");
		if(valores.length != 3) {
			return null;
		}
		Produto produto = new Produto();
		produto.setCodigo(Integer.parseInt(valores[0]));
		produto.setNome(valores[1]);
		produto.setPreco(Float.parseFloat(valores[2]));
		return produto;
	}
	
	public static 
		boolean validaProduto(Produto produto,
							ArrayList<Produto> lista) {
		
		// Não pode ser salvo produtos com o mesmo código.
		for (Produto p : lista) {
			if(p.getCodigo() == produto.getCodigo()) {
				System.out.println("ja existe produto cadastrado com esse codigo");
				return false;
			}
		}
		
		// Nome do produto não pode estar vazio
		if(produto.getNome().isEmpty()) {
			System.out.println("nome não pode estar vazio");
			return false;
		}
		
		// Preço do produto não pode ser menor ou igual a 0
		if(produto.getPreco() <= 0 ) {
			System.out.println("preco nao pode se menor igual a 0");
			return false;
		}
		
		return true;
	}

}
