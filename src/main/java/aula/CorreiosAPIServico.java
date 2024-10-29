package aula;

public class CorreiosAPIServico {

	private CorreiosAPI correiosAPI = new CorreiosAPI();
	
	public CorreiosAPIServico(CorreiosAPI correiosAPI) {
		this.correiosAPI = correiosAPI;
	}	
	
	public CorreiosAPIServico() {}
	
	public Endereco buscar(String cep) {
		
		//9052001
		Endereco endereco = correiosAPI.buscaCep(cep);
		if(endereco == null || (endereco !=null &&
							endereco.getLogradouro() == null) ) {
			Endereco enderecoNaoEncontrado = new Endereco();
			enderecoNaoEncontrado.setBairro("BAIRRO NAO ENCONTRADO");
			enderecoNaoEncontrado.setUf("UF NÃO ENCONTRADO");
			enderecoNaoEncontrado.setLogradouro("LOGRADOURO NÃO ENCONTRADO");
			return enderecoNaoEncontrado;
		}else {
			return endereco;
		}
	}
	
}
