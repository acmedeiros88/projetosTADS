package dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import entity.Usuario;


@Stateless
public class UsuarioDao {
	
	
	@PersistenceContext
	private EntityManager entityManager;

	public List<Usuario> loadAllusuarios() {
		List<Usuario> lista = this.entityManager.createQuery("SELECT c FROM Usuario c", Usuario.class).getResultList();
		return lista;
	}

	public void delete(Usuario usuario) {
		if (entityManager.contains(usuario)) {
			entityManager.remove(usuario);
		} else {
			Usuario usuario_apagar = entityManager.find(Usuario.class, usuario.getId());
			if (usuario_apagar != null) {
				entityManager.remove(usuario_apagar);
			}
		}
	}

	public void adicionarUsuario(Usuario usuario) {
		this.entityManager.persist(usuario);
	}

	public void atulaizar(List<Usuario> usuarios) {
		usuarios.forEach(entityManager::merge);
	}

}
