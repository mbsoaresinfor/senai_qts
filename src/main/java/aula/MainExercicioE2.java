package aula;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainExercicioE2 {

	List<Produto> listaDados = new ArrayList<Produto>();

	public static void main(String[] args) throws Exception {

		new MainExercicioE2().inicio();

	}

	void inicio() throws Exception {
			Scanner teclado = new Scanner(System.in);

			while (true) {
				try {
					System.out.println("digite a linha de dados: ");
					String dados = teclado.next();
					if (dados.equalsIgnoreCase("fim")) {
						break;
					}
					validarLinha(dados);
					validarCodigo(dados);
					validarNomeProduto(dados);
					validarPreco(dados);
					if (existeCodigo(dados)) {
						throw new Exception("codigo já existe.");
					}
					salvar(dados);
					System.out.println(listar(listaDados));
				} catch (Throwable e) {
					System.out.println(e.getMessage());
				}
			}		
	}

	void salvar(String dados) {
		String codigo = dados.split(";")[0];
		String nome = dados.split(";")[1];
		String preco = dados.split(";")[2];
		Produto produto = new Produto();
		produto.codigo = Integer.parseInt(codigo);
		produto.nome = nome;
		produto.preco = Double.parseDouble(preco);
		listaDados.add(produto);
	}

	void validarLinha(String dados) throws Exception {
		if (dados == null) {
			throw new Exception("dados null");
		}
		if (dados.split(";").length != 3) {
			throw new Exception("dados invalidos");
		}
	}

	boolean existeCodigo(String dados) {
		String codigo = dados.split(";")[0];
		return listaDados.stream().anyMatch(obj -> obj.codigo == Integer.parseInt(codigo));
	}

	void validarCodigo(String dados) throws Exception {
		String codigo = dados.split(";")[0];
		try {
			Integer.parseInt(codigo);
		} catch (Exception e) {
			throw new Exception("codigo não é um número.");
		}
	}

	void validarNomeProduto(String dados) throws Exception {
		String nome = dados.split(";")[1];
		if (nome.equals("")) {
			throw new Exception("nome está vazio.");
		}
	}

	void validarPreco(String dados) throws Exception {
		String preco = dados.split(";")[2];
		if (preco.equals("")) {
			throw new Exception("preco invalido");
		}
		try {
			Double.parseDouble(preco);
		} catch (Exception e) {
			throw new Exception("preco não é um número.");
		}
		if (Double.parseDouble(preco) <= 0) {
			throw new Exception("preco igual ou menor que zero.");
		}
	}

	String listar(List<Produto> lista) {
		StringBuilder mensagem = new StringBuilder();
		for (Produto produto : lista) {
			mensagem.append("codigo: ").append(produto.codigo).append("\n");
			mensagem.append("nome: ").append(produto.nome).append("\n");
			mensagem.append("preco: ").append(produto.preco).append("\n");
		}
		return mensagem.toString();
	}

}
