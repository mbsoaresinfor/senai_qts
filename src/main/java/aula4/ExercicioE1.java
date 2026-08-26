package aula4;

import java.util.Scanner;

public class ExercicioE1 {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		Aluno[] alunos = new Aluno[50];
		int ind=0;
		for(;;) {
			System.out.println("1. cadastrar");
			System.out.println("2. listar");
			System.out.println("3. sair");
			
			String op = teclado.next();
			if(op.equals("1")) {
				System.out.println("digite o nome: ");
				String nome = teclado.next();
				System.out.println("digite a idade: ");
				int idade = teclado.nextInt();
				System.out.println("digite o mes: ");
				int mes = teclado.nextInt();
				System.out.println("digite o ano: ");
				int ano = teclado.nextInt();
				boolean resultado = 
						validaAluno(nome, idade,
								mes, ano);
				if(resultado) {
					if(ind >= 50) {
						System.out.println("memória cheia");
						break;
					}else {
						Aluno aluno = new Aluno();
						aluno.nome = nome;
						aluno.idade = idade;
						aluno.mes = mes;
						aluno.ano = ano;
						alunos[ind] = aluno;
						ind = ind +1;
						System.out.println("cadastrado realizado com sucesso");
					}
				}else {
					System.out.println("aluno "
							+ "tem dados inválidos");
				}
				
				
			}else if(op.equals("2")) {
				System.out.println("LISTAGEM DE ALUNOS");
				
				for(int i=0; i < alunos.length;i++) {
					
					Aluno alunoTemp = alunos[i];
					if(alunoTemp == null) {
						continue;
					}
					 
					System.out.println("Nome: " 
								+ alunoTemp.nome + "," +
								alunoTemp.idade +"," +
								(alunoTemp.idade < 18 ? 
										" é menor de idade":
									" é maior de idade"));
				}
			}else if(op.equals("3")) {
				break;
			}else {
				System.out.println("opçao invalida");
			}
		}
		

	}
	
	// true=aluno ok, false=aluno com erro
	public static boolean validaAluno(
			String nome, int idade,
			int mes, int ano) {
		if(nome.equals("") ||
				nome.length() <= 4 ||
				nome.length() >= 50) {
			return false;
		}
		if(idade < 0 || idade > 150) {
			return false;
		}
		if(mes < 1 || mes > 12) {
			return false;
		}
		if(ano < 1900 || ano > 2026) {
			return false;
		}
		
		return true;
	}
		
	
	static class Aluno {
		String nome;
		int idade;
		int mes;
		int ano;
	}

}
