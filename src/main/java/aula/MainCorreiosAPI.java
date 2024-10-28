package aula;

public class MainCorreiosAPI {

	public static void main(String[] args) throws Exception {

		CorreiosAPI correiosAPI = new CorreiosAPI();
		Endereco end = correiosAPI.buscaCep("91010004");
		System.out.println(end.getLogradouro());
		System.out.println(end.getLocalidade());

	}

}
