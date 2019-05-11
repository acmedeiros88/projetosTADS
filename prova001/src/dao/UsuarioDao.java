package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.transaction.TransactionalException;

import entity.Usuario;
import fabricaConexao.FabricaJpa;

public class UsuarioDao {
	GenericoDao daoGenerico = new GenericoDao();

	public boolean salvar(Usuario usuario) {
		return daoGenerico.salvar(usuario);
	}

	public Usuario buscarPorCpf(String cpf) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Usuario resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Usuario.class, cpf);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}
	@SuppressWarnings("unchecked")
	public List<Usuario> getListaUsuario() {
		return (List<Usuario>) daoGenerico.listarTodos(Usuario.class);
	}
}
