package gerenciador;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import object.Usuario;

public class GerenciaSessao {
	private ArrayList<Usuario> lista = new ArrayList<Usuario>();;
	HttpSession session;

	public void adicionarUsuario(Usuario usuario) {
		lista.add(usuario);
	}
	
	public ArrayList<Usuario> retornaLista(){
		return lista;
	}
	public int retonaTamanho() {
		
		return lista.size();
	}
	
}
