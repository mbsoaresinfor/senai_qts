package aula;

import javax.swing.JOptionPane;

public class CalculadoraMain {
 
	public static void main(String[] args) {
	
	String v1 = JOptionPane
			.showInputDialog("digite valor 1");
	String v2 = JOptionPane
			.showInputDialog("digite valor 2");
	
	Calculadora c = new Calculadora();
	double resultado = c.somar(Double.valueOf(v2),
			Double.valueOf(v1));
	JOptionPane.showMessageDialog(null, resultado);
	

	}

}
