package aula3;

import javax.swing.JOptionPane;

public class Exercicio2 {

	public static void main(String[] args) {
		String valor = JOptionPane
		.showInputDialog("digite o valor");
		
		double tx = calculaTxJuros(Double
				.parseDouble(valor));
		
		JOptionPane.showMessageDialog(null,
				"taxa aplicada: " + tx);

	}
	
	public static double calculaTxJuros(double valor) {
			if(valor <= 4) {
				return 0.1;
			}
			if(valor >= 5 && valor <=10) {
				return 0.5;
			}
			if(valor >=11 && valor <=19) {
				return 0;
			}			
			return 0.3;
	}

}
