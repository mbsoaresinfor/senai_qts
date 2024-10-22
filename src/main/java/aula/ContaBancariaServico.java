package aula;

public class ContaBancariaServico {
	private ContaBancaria contaBancaria;

	public ContaBancariaServico(ContaBancaria conta) {
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
