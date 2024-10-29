package aula;

import javax.swing.JOptionPane;

public class MainCorreiosAPI {

	public static void main(String[] args) throws Exception {
		String cep = JOptionPane
				.showInputDialog("Digite um "
						+ "cep para consulta: ");
		CorreiosAPIServico correiosAPI = new CorreiosAPIServico();
		Endereco end = correiosAPI.buscar(cep);
		String mensagem = "Rua: " + end.getLogradouro() + "\n"+
		"Bairro: " + end.getBairro() + "\n" +
		"Estado: " + end.getUf()+ "\n";
		JOptionPane.showMessageDialog(null, mensagem);
		

	}

}
