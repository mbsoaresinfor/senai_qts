package aula;

import java.util.Scanner;

public class CorreiosAPIServicoMain {

	public static void main(String[] args) {
		CorreiosAPIServico correiosAPIServico 
		= new CorreiosAPIServico(new CorreiosAPI());
		Scanner teclado = new Scanner(System.in); 
		
		System.out.println("Digite um CEP: ");
		String cep = teclado.next();
		Endereco endereco = correiosAPIServico.buscar(cep);
		System.out.println(endereco);

	}

}
