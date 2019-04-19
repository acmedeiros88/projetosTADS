package fabricaConexao;

import javax.persistence.EntityManager;

public class testaConexao {

	public static void main(String[] args) {
		EntityManager entityManenger = FabricaJpa.getEntityManagerFactory().createEntityManager();
		
		if(entityManenger != null ) {
			System.out.print("conxao realizada com sucesso");
		}else {
			System.out.println("nao foi possivel realizar a conexao");
		}
	}

}
