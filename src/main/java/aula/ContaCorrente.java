package aula;

public class ContaCorrente {

	private float saldo;
	
	public ContaCorrente(float saldo) {	
		this.saldo = saldo;
	}

	public float getSaldo() {
		return saldo;
	}

	public void setSaldo(float saldo) {
		this.saldo = saldo;
	}

	public float depositar(float a) {
		if(a < 0) {
			return -1;
		}
		saldo = saldo + a;
		return saldo;
	}

	public float sacar(float a) {
		if (a <= saldo) {
			saldo = saldo - a;
			return saldo;
		} else {
			return -1;
		}
	}
}
