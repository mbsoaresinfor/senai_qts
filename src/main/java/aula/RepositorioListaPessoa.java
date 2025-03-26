package aula;
import java.util.ArrayList;
import java.util.List;

public class RepositorioListaPessoa {

	List<Pessoa> lista = new ArrayList<Pessoa>();
	
	public boolean salvarPessoa(Pessoa pessoa) {
		
		if(pessoa != null) {	
			System.out.println("salvo no banco");
			 lista.add(pessoa);
		    return true;
		}else {
			System.out.println("nao salvo no banco");
			return false;
		}
	}
	
	public String listarPrimeiroPessoas() {
		StringBuilder message = new StringBuilder();
		// pega somente o nome
		for(Pessoa pessoa : lista) {
			String nome = pessoa.getNome().split(" ")[0];
			message.append(nome).append("\n");
		}		
		return message.toString();
	}

	public List<Pessoa> getPessoas() {
		return lista;		
	}	
	
}
