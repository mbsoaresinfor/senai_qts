package aula3;

import javax.swing.JOptionPane;

public class Exercicio5 {

	public static void main(String[] args) {
		String nome = JOptionPane
				.showInputDialog("digite nome paciente");
		String idade = JOptionPane
				.showInputDialog("digite idade paciente");
		
		String resultado = validaPacientePediatria
				(Integer.parseInt(idade), nome);
		if(resultado.equals("")) {
			JOptionPane.showMessageDialog(null,
					"paciente internado na pediatria");
		}else {
			JOptionPane.showMessageDialog(null,
					"ERRO " + resultado);
		}
	}
	
	public static String validaPacientePediatria(
			int idade, String nome){
		if(idade < 0 || idade > 12) {
			return "Idade inválida para pediatria";
		}
		if(nome.length() <= 4) {
			return "Nome do paciente tem que ter mais"
					+ " que 4 caracteres para pediatria"
					+ "";
		}
		return "";
	}

}
