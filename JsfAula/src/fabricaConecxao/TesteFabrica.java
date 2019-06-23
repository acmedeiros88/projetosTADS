package fabricaConecxao;

import javax.persistence.EntityManager;

public class TesteFabrica {
	public static void main(String[] args) {

		
		EntityManager entityManager = FabricaJPA.getEntityManagerFactory().createEntityManager();
		entityManager.getTransaction().begin();

		String sql = "select version()";

		String result = (String) entityManager.createNativeQuery(sql).getSingleResult();
		System.out.println(result);

		entityManager.getTransaction().commit();
		entityManager.close();

		FabricaJPA.shutdown();
	}

}
