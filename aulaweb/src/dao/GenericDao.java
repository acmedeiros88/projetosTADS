package dao;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;

import entity.Contato;
import fabricaConecxao.FabricaJPA;

public class GenericDao {

	public boolean salvar(Object objeto) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();

			entityManager.persist(objeto);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}

		return resultado;
	}
	
	public boolean deletar(int id) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		boolean resultado = true;
		try {
			entityManager.getTransaction().begin();
			entityManager.remove(entityManager.find(Contato.class, id));

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}

		return resultado;
	}

	public List<Contato> carregarTodosContato() {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		List<Contato> contatos = null;
		try {
			String jpql = "from Contato";
			TypedQuery<Contato> q = entityManager.createQuery(jpql, Contato.class);
			contatos = q.getResultList();
		} catch (EntityExistsException | TransactionalException e) {
			contatos = null;
			FabricaJPA.shutdown();
		}

		return contatos;
	}

	public Contato carregarContato(int id) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		Contato resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Contato.class, id);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJPA.shutdown();
		}

		return resultado;
	}

	public List<Contato> carregarContatoFavoritos(int id) {
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		List<Contato> contatos = null;
		try {
			String jpql = "select c from Contato c where c.favoritos = :valor";
			TypedQuery<Contato> q = entityManager.createQuery(jpql, Contato.class);
			q.setParameter("valor", true);
			contatos = q.getResultList();

		} catch (EntityExistsException | TransactionalException e) {
			FabricaJPA.shutdown();
		}

		return contatos;
	}
	public boolean atualizar(Contato contato) {
		boolean resultado = true;
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(contato);
			entityManager.getTransaction().commit();
			resultado = true;
		} catch (EntityExistsException | TransactionalException e) {
			resultado = false;
			FabricaJPA.shutdown();
		}
		return resultado;
	}
}
