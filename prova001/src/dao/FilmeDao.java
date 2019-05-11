package dao;

import java.util.List;

import entity.Filme;

public class FilmeDao {
	GenericoDao daoGenerico = new GenericoDao();

	public boolean salvar(Filme filme) {
		return daoGenerico.salvar(filme);
	}

	public Filme buscarPorCodFilme(int codFilme) {
		return (Filme) daoGenerico.buscarPorId(Filme.class, codFilme);
	}

	@SuppressWarnings("unchecked")
	public List<Filme> getListaUsuario() {
		return (List<Filme>) daoGenerico.listarTodos(Filme.class);
	}
}
