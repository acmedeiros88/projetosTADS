package financas.teste;

import javax.persistence.EntityManager;

import financas.modelo.Conta;
import financas.util.JPAUtil;

public class TesteConta {

	public static void main(String[] args) {
		
		Conta conta = new Conta();
		conta.setTitular("Jeff");
		conta.setAgencia("123");
		conta.setBanco("BB");
		conta.setNumero("456");
		
		EntityManager em = new JPAUtil().getEntityManager();
		
		em.getTransaction().begin();
		em.persist(conta);
		em.getTransaction().commit();
		em.close();
		
	}
	
}
