package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.TransactionalException;

import entity.Contato;
import fabricaConexao.FabricaJpa;

public class Daogenerico {

	public void salvarContato(Contato contato) {
		
			EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
			try {
			entityManager.getTransaction().begin();
			entityManager.persist(contato);
			entityManager.getTransaction().commit();
		}catch(EntityExistsException | TransactionalException e){
			FabricaJpa.shutdown();
		}
		
	}
	public List<Contato> getBuscarTodos(){
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		List<Contato> lista;
		try {
			String jpql ="FROM Contato";
			TypedQuery<Contato> q = entityManager.createQuery(jpql, Contato.class);
			lista = q.getResultList();
		}catch(EntityExistsException | TransactionalException e) {
			lista=null;
			FabricaJpa.shutdown();
		}
		return lista;
	}
	public void remover(int id) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Contato deletar = entityManager.find(Contato.class, id);
			entityManager.remove(deletar);
			entityManager.getTransaction().commit();
		}catch(EntityExistsException | TransactionalException e) {
			FabricaJpa.shutdown();
		}
	}
	public void atualizar(Contato contato) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.merge(contato);
			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			FabricaJpa.shutdown();
		}
	}
	
	public Contato carregarContato(int id) {
		EntityManager entityManager = FabricaJpa.getEntityManagerFactory().createEntityManager();
		Contato resultado;
		try {
			entityManager.getTransaction().begin();

			resultado = entityManager.find(Contato.class, id);

			entityManager.getTransaction().commit();
		} catch (EntityExistsException | TransactionalException e) {
			resultado = null;
			FabricaJpa.shutdown();
		}

		return resultado;
	}
}
