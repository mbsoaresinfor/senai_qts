package aula3;

import javax.swing.JOptionPane;

public class Exercicio1 {

	public static void main(String[] args) {
		String idadeString = JOptionPane
		.showInputDialog("digite sua idade");
		
		boolean resultado = validaIdade(Integer
				.parseInt(idadeString));
		if(resultado) {
			JOptionPane.showMessageDialog(null,
					"idade válida");
		}else {
			JOptionPane.showMessageDialog(null,
					"idade inválida");
		}

	}
	
	public static boolean validaIdade(int idade) {
		if(idade >= 0 && idade <= 130 ) {
			return true;
		}
		return false;
	}

}
