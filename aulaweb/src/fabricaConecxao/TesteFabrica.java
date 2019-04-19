package fabricaConecxao;

import java.util.ArrayList;



import dao.GenericDao;
import entity.Contato;
import entity.Nome;
import entity.Telefone;


public class TesteFabrica {
	public static void main(String[] args) {
		/*
		 * EntityManager entityManager =
		 * FabricaJPA.getEntityManagerFactory().createEntityManager();
		 * 
		 * entityManager.getTransaction().begin();
		 * 
		 * 
		 * Contato c1 = new Contato(); c1.setFavoritos(false); Nome riad = new Nome();
		 * riad.setPrimeiro("João"); riad.setSegundo("Carlos"); c1.setNome(riad);
		 * c1.setNotas("blebleble"); Telefone t1 = new Telefone(); Telefone t2 = new
		 * Telefone(); t1.setTelefone("47111111"); t2.setTelefone("48222222");
		 * 
		 * 
		 * ArrayList<Telefone> telefones = new ArrayList<>(); telefones.add(t1);
		 * telefones.add(t2); c1.setTelefones(telefones);
		 * 
		 * entityManager.persist(c1);
		 * 
		 * 
		 * //String sql = "select version()";
		 * 
		 * //String result = (String)
		 * entityManager.createNativeQuery(sql).getSingleResult();
		 * //System.out.println(result);
		 * 
		 * 
		 * 
		 * entityManager.getTransaction().commit();
		 * 
		 * 
		 * 
		 * FabricaJPA.shutdown();
		 */
	
		Contato c1 = new Contato(); 
		c1.setFavoritos(true); 
		Nome riad = new Nome();
		riad.setPrimeiro("João"); 
		riad.setSegundo("Carlos"); 
		c1.setNome(riad);
		c1.setNotas("blebleble"); 
		Telefone t1 = new Telefone(); 
		Telefone t2 = new
		Telefone(); 
		t1.setTelefone("4711111"); 
		t2.setTelefone("4822222");
		
		ArrayList<Telefone> telefones = new ArrayList<>(); telefones.add(t1);
		telefones.add(t2); c1.setTelefones(telefones);
		GenericDao dao = new GenericDao();
		//System.out.println(dao.salvar(c1));
		System.out.println(dao.carregarContatoFavoritos(1));
	}
}
