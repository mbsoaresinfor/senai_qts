package aula;

import java.util.Random;

public class Tempo {

	public InformacoesTempo getInformacoesTempo(Integer idCidade) {
		// aqui, eu buscaria as informacoes numa api, bd, ou qq outro lugar
		InformacoesTempo informacoesTempo = new InformacoesTempo();
		informacoesTempo.setTemperatura(new Random().nextFloat());
		informacoesTempo.setUmidade(new Random().nextFloat());
		return informacoesTempo;
	}
	
}
