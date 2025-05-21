package aula;

public class ContaCorrenteServico {

	private ContaBancaria contaBancaria;

	public ContaCorrenteServico(ContaBancaria conta) {
		contaBancaria = conta;
	}

	public String processarDeposito(String nome, Float valor) {
		Float resultado = contaBancaria.depositaDinheiro(valor);
		if (resultado != null) {
			return "sucesso";
		} else {
			return "erro";
		}
	}

}
