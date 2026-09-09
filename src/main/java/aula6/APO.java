package aula6;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class APO {

	public static void main(String[] args) {
	
		
		String dm = JOptionPane
		.showInputDialog(null, "digite uma data matrix");
		if(validaDataMatrix(dm) == true) {
			JOptionPane.showMessageDialog(null,
					"A data matrix é valida");
		}else {
			JOptionPane.showMessageDialog(null,
					"A data matrix é inválida");
		}
		
	}
	
	public static boolean validaDataMatrix(String dataMatrix) {
		if(dataMatrix == null) {
			return false;
		}
		
		if(dataMatrix.trim().length() != 31) {
			return false;
		}
		String codMedico = dataMatrix.trim().substring(0, 14);
		String dtProd = dataMatrix.trim().substring(14, 20);
		String serial = dataMatrix.trim().substring(20, 25);
		String lote = dataMatrix.trim().substring(25, 31);
		
		if(!ehInteiro(dtProd)) {
			return false;
		}
		
		if(!ehInteiro(lote)) {
			return false;
		}
		
		return true;
		
	}
	
	public static boolean ehInteiro(String texto) {
	    if (texto == null) return false;
	    try {
	        Integer.parseInt(texto);
	        return true; 
	    } catch (NumberFormatException e) {
	        return false; 
	    }
	}
	
}
