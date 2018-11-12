package br.com.caelum.jdbc.teste;

import br.com.caelum.jdbc.dao.ContatoDao;
import br.com.caelum.jdbc.modelo.Contato;
public class TestaInsere {
	public static void main(String[] args) {
		
		//pronto para gravar
		Contato contato = new Contato();
		contato.setNome("Teste01");
		contato.setEmail("Teste@com.br");
		contato.setEndereco("Rua teste, 001");
		contato.setDataNascimento(null);
		
		//grave nessa conexão
		ContatoDao dao = new ContatoDao();
		
		dao.adiciona(contato);
		
		System.out.println("Gravado!");
	}
}
