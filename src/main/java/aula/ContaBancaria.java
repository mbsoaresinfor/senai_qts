package aula;

public class ContaBancaria {

	private String nomeCorrentista;
	private Float saldo;

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public Float depositaDinheiro(Float valor) {
		saldo = saldo + valor;
		return saldo;
	}

	public Float sacarDinheiro(Float valor) {
		saldo = saldo - valor;
		return saldo;
	}

}
