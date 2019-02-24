package financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import financas.modelo.Conta;
import financas.modelo.Movimentacao;
import financas.util.JPAUtil;

public class TesteInserirMovimentacao {
	
	public static void main(String[] args) {

        EntityManager em = new JPAUtil().getEntityManager();

        String jpql = "select m from Conta c join c.movimentacoes m where c.id = 2 ";
        Query query = em.createQuery(jpql);
      

        List<Movimentacao> movimentacoes = query.getResultList();


        for (Movimentacao movimentacao : movimentacoes) {
            System.out.println("Movimentação: " + movimentacao.getDescricao());
        }

        em.close();
    }

}
