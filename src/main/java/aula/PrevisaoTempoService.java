package aula;

public class PrevisaoTempoService {

	private Tempo tempo;
	
	public PrevisaoTempoService() {}
	
	public PrevisaoTempoService(Tempo tempo) {
		this.tempo = tempo;
	}
	
	public Tempo getTempo() {
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		this.tempo = tempo;
	}



	public String processarTempo() {
		if(tempo.getTemperatura() <= 18 && 
				tempo.getUmidade() <= 18) {
			return "Tempo frio e não úmido";
		}
		if(tempo.getTemperatura() > 18 && 
				tempo.getUmidade() < 18 ) {
			return "Tempo quente e não úmido.";
		}
		if(tempo.getTemperatura() < 18 && 
				tempo.getUmidade() > 18 ) {
			return "Tempo frio e úmido.";
		}
		return "Temperatura/umidade não informado";

	}
	
	
}
