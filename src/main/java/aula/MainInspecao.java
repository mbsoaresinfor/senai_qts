package aula;
import java.util.List;

import javax.swing.JOptionPane;

public class MainInspecao {

	
	/**
	 * REQUISITOS DO PROJETO
	 * Somente e possivel cadastrar uma pessoa onde:
	 * nome: nao pode ser em branco e ter que ter mais de 3 caracteres
	 * salario: nao pode ser menor que 0 e maior que 10000.
	 * 
	 * No listar nomes, deve visualizar somente o nome da pessoa (sem sobrenome)
	 * 
	 * Na listagem total, apresentar:
	 * nome completo
	 * salario total
	 * No desconto, se o salario for ate 5000, desconto e + 0,02%, acima disso 0.05% 
	 * 
	 * 
	 */
	
	/*
	 * ALTERACOESPARA FAZER
	 * 1. Retirar a validacao de valor minimo de caracteres do nome da pessoa
	 * 2. Alterar o valor do limite do salario para 12000
	 * 4. alterar o desconto do salario
	 * 3. alterar a forma de buscar o nome do usuario (sem sobrenome)
	 * 
	 */
	
	
	
	RepositorioListaPessoa banco = new RepositorioListaPessoa();
	public static void main(String[] args) {
		MainInspecao main = new MainInspecao();
		while(true) { 
		String opcao = JOptionPane.showInputDialog(null, "Selecione uma opcao\n1.Salvar\n2.Listar Nomes\n3.Listar salarios e descontos\n4.Sair");
			if("1".equals(opcao)) {
				main.salvar();
			}else if("2".equals(opcao)) {
				main.listar();
			}else if("3".equals(opcao)) {
				main.listarSalario();
			}
			else if("4".equals(opcao)) {
				break;
			}else {
				JOptionPane.showMessageDialog(null,"opcao invalida");
			}
		}
			
		
		
	}

	public  void listarSalario() {
		StringBuilder message = new StringBuilder();
		List<Pessoa> list = banco.getPessoas();
		
		for(Pessoa pessoa : list) {
			float salarioDesconto =  calculaDesconto( pessoa.getSalario());
			message.append("nome: " + pessoa.getNome() + "\n");
			message.append("salario: " + pessoa.getSalario() + "\n");
			message.append("desconto salario: " + salarioDesconto + "\n");
			message.append("------------------------\n");			
		}
		
		JOptionPane.showMessageDialog(null,message.toString());
	}
	

	private  void listar() {
		JOptionPane.showMessageDialog(null,banco.listarPrimeiroPessoas());		
	}

	private  void salvar() {
		String nome = JOptionPane.showInputDialog(null, "Digite o nome");	
		String salario = JOptionPane.showInputDialog(null, "Digite o salario");		
		
		Pessoa pessoa = new Pessoa();	
		pessoa.setNome(nome);
		pessoa.setSalario(Float.parseFloat(salario));
		boolean ret = validaPessoa(pessoa);
		if(ret == true) {
			boolean retBanco = banco.salvarPessoa(pessoa);
			if(retBanco == true) {
				JOptionPane.showMessageDialog(null, "Pessoa salva com sucesso");
			}else {
				JOptionPane.showMessageDialog(null, "ERROR ao salavar Pessoa");
			}
			
		}else {
			JOptionPane.showMessageDialog(null, "Dados invalidos para a pessoa");
		}
		
	}

	// retorna FALSE, se pessoa tiver problemas nos seus dados, ou TRUE, se tudo estiver sido OK.
	public  boolean validaPessoa(Pessoa pessoa) {
		boolean ret = false;
		if(pessoa.getNome().equals("") || pessoa.getNome().length() < 4 ) {
			ret = false;
		}else if(pessoa.getSalario() < 0 || pessoa.getSalario() > 10000) {
			ret = false;
		}else {
			return true;
		}
		return ret;
		
	}
	
	public  float calculaDesconto(float salario) {
		if(salario > 0 &&  salario <= 5000) {
			return salario * 0.02f;
		}else if(salario > 5000 &&  salario < 10000) {
			return salario * 0.05f;
		}
		return 0;
	}
	
	
	
}
