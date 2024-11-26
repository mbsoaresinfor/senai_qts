package aula;

import java.util.List;
import java.util.Objects;

public class Calculadora {

	public Double somar(Double valor1, Double valor2) {
		if(valor1 == null || valor2 == null) {
			System.out.println("erro nas entradas");
			return -1d;			
		}
		return valor1 + valor2;
	}
	
	public Double somar(Double[] valores) {
		if(Objects.isNull(valores)) {
			throw new IllegalArgumentException("Vetor null");			
		}
		
		var somador = 0d;
		for(Double valor : valores) {
			somador = somador + valor;
		}
		
		return somador;
	}
	
	public ResultadoCalculoVO somar(List<Double> valores) {		
		
		if(Objects.isNull(valores)) {
			return  new ResultadoCalculoVO(0d,true,"lista vazia");
		}
		var somador = 0d;
		for(Double valor : valores) {
			somador = somador + valor;
		}
		
		return  new ResultadoCalculoVO(somador,false,"");
		
	}
	
	public Double subtrair(Double valor1, Double valor2) {
		if(valor1 < 0 || valor2 > 1000) {
			return null;
		}
		
		return valor1- valor2;
	}
	
	public Double subtrairComException(Double valor1, Double valor2) {
		if(valor1 < 0 || valor2 > 1000) {
			throw new IllegalArgumentException("Valores invalidos para a subtracao");
		}
		return valor1 - valor2;
	}
	
	public ResultadoCalculoVO multiplicacao(List<Double> valores) {		
		
		if(Objects.isNull(valores)) {
			return  new ResultadoCalculoVO(0d,true,"lista vazia");
		}else {		
			if(valores.size() > 5) {
				return  new ResultadoCalculoVO(0d,true,"Tamanho maximo de elementos [5]");
			}
		}
		
		
		var mult = 1d;
		for(Double valor : valores) {
			mult = mult * valor;
		}
		
		
		return  new ResultadoCalculoVO(mult,false,"");
		
	}	
	
	public Double divisao(Double valor1,Double valor2) {
		if(valor1 == null || valor2 == null) {
			throw new IllegalArgumentException("valores null");
		}
		if(valor2 == 0d) {
			throw new IllegalArgumentException("Não é possível dividir por zero");
		}
		return valor1/valor2;
	}
	
}
