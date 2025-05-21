package aula;

public class PrevisaoTempoService {

	private Tempo tempo; // dependencia
	
	public PrevisaoTempoService(Tempo tempo) {
		this.tempo = tempo;
	}
	
	
	public String processarTempo(Integer idCidade) {
		InformacoesTempo informacoesTempo = tempo.getInformacoesTempo(idCidade);
		if(informacoesTempo.getTemperatura() < 18 
				&& informacoesTempo.getUmidade() < 18 ) {
			return "Tempo frio e não úmido";
		}
		if(informacoesTempo.getTemperatura() > 18 
				&& informacoesTempo.getUmidade() < 18 ) {
			return "Tempo quente e não úmido";
		}
		if(informacoesTempo.getTemperatura() < 18 
				&& informacoesTempo.getUmidade() > 18 ) {
			return "Tempo quente e úmido";
		}
		return "";

	}
	
}
