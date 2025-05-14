package aula;

public class MainBancoDados {

	BancoDados banco; // dependencia da classe.

	public MainBancoDados(BancoDados banco) {
		this.banco = banco;

	}

	public void iniciar() {
		// crio pessoa para salvar
		Pessoa pessoa1 = new Pessoa();
		pessoa1.setNome("pedro");
		pessoa1.setIdade(40);
		pessoa1.setSalario(500);
		inserirPessoa(pessoa1);

		// crio outra pessoa para salvar
		Pessoa pessoa2 = new Pessoa();
		pessoa2.setNome("maria");
		pessoa2.setIdade(50);
		pessoa2.setSalario(200);
		inserirPessoa(pessoa2);

		// LISTA DO BANCO
		for (Pessoa p : banco.listPessoa()) {
			System.out.println("-------------------------------");
			System.out.println("Pessoa id " + p.getId());
			System.out.println("Pessoa nome " + p.getNome());
			System.out.println("Pessoa idade " + p.getIdade());
			System.out.println("Pessoa salario " + p.getSalario());
			System.out.println("-------------------------------");
		}

		// ATUALIZA AS PESSOAS
		pessoa1.setIdade(90);
		banco.updatePessoa(pessoa1);
		pessoa2.setIdade(130);
		banco.updatePessoa(pessoa2);

		// LISTA DO BANCO
		listarPessoas();

		// DELETA NO BANCO AS PESSOAS
		banco.deletePessoa(pessoa1.getId());
		banco.deletePessoa(pessoa2.getId());

		// LISTA DO BANCO
		for (Pessoa p : banco.listPessoa()) {
			System.out.println("-------------------------------");
			System.out.println("Pessoa id " + p.getId());
			System.out.println("Pessoa nome " + p.getNome());
			System.out.println("Pessoa idade " + p.getIdade());
			System.out.println("Pessoa salario " + p.getSalario());
			System.out.println("-------------------------------");
		}
	}

	public MainBancoDados() {
		this(new BancoDados());
	}

	public String deletar(Integer id) {
		boolean resultado = banco.deletePessoa(id);
		if(resultado == true) {
			return "sucesso";
		}else {
			return "error";
		}
	}
	
	public boolean listarPessoas() {
		if (banco.listPessoa().isEmpty()) {
			return false;
		}
		for (Pessoa p : banco.listPessoa()) {
			System.out.println("-------------------------------");
			System.out.println("Pessoa id " + p.getId());
			System.out.println("Pessoa nome " + p.getNome());
			System.out.println("Pessoa idade " + p.getIdade());
			System.out.println("Pessoa salario " + p.getSalario());
			System.out.println("-------------------------------");
		}
		return true;
	}

	public boolean inserirPessoa(Pessoa pessoa) {
		if (pessoa == null) {
			return false;
		}
		int id = banco.insertPessoa(pessoa);
		if (id > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		// inicia o programa
		MainBancoDados mainBancoDados = new MainBancoDados();
		mainBancoDados.iniciar();
	}

}
