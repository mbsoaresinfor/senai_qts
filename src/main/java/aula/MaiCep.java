package aula;

public class MaiCep {

	public static void main(String[] args) {
		
		CorreiosAPIServico correio = 
				new CorreiosAPIServico
				(new CorreiosAPI());

		Endereco end = correio.buscar("91130100");
		System.out.println("rua: " + end.getLogradouro());
		System.out.println("bairro: " + end.getBairro());
		
		
	}

}
