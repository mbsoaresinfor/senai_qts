package aula;

import java.io.Console;
import java.util.ArrayList;
import java.util.Scanner;

public class MainRevisao {

	public static void main(String[] args) {
				
		 Scanner teclado = new Scanner(System.in);
		 ArrayList<Carro> lista = new ArrayList<Carro>();
		 ValidaCarro validar = new ValidaCarro();
		 
		 while(true) {
			 Carro carro = new Carro();
			 System.out.println("digite o id do carro [SAIR]");
			 String id = teclado.next();
			 if(id.equalsIgnoreCase("SAIR")) {
				 break;
			 }
			 boolean resultado = validar.validaIdCarro(Integer.parseInt(id));
			 if(resultado == false) {
				 System.out.println("ERROR, id invalido");
				 continue;
			 }
			 carro.setId(Integer.parseInt(id));
			 
			 
			 System.out.println("digite o modelo do carro [SAIR]");
			 String modelo = teclado.next();
			 if(modelo.equalsIgnoreCase("SAIR")) {
				 break;
			 }
			  resultado = validar.validaModelCarro(modelo);
			 if(resultado == false) {
				 System.out.println("ERROR, modelo invalido");
				 continue;
			 }
			 carro.setModelo(modelo);
			 
			 System.out.println("digite o ano do carro [SAIR]");
			 String ano = teclado.next();
			 if(id.equalsIgnoreCase("SAIR")) {
				 break;
			 }
			 resultado = validar.validaAnoFabricacao(Integer.parseInt(ano));
			 if(resultado == false) {
				 System.out.println("ERROR, ano invalido");
				 continue;
			 }
			 carro.setAno(Integer.parseInt(ano));
			 
			 
			 
			 lista.add(carro);
			 System.out.println("listagem de carros:");
			 for(Carro car : lista) {
				 System.out.println(car.getId());
				 System.out.println(car.getModelo());
				 System.out.println(car.getAno());
				 System.out.println("----------------");
			 }
		 }

	}

}
