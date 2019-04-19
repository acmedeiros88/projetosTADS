package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import dao.GenericDao;
import entity.Contato;
import entity.Nome;

public class ComandoAtualizar extends FrontComando {
	
	@Override
	public void process() throws ServletException, IOException {
		GenericDao dao = new GenericDao();
		Contato update = new Contato();
		update = dao.carregarContato(Integer.parseInt(request.getParameter("idUpdate")));
		Nome nome = new Nome();
		nome.setPrimeiro(request.getParameter("primeiro"));
		nome.setSegundo(request.getParameter("segundo"));
		update.setNome(nome);
		dao.atualizar(update);
		List<Contato> contatos = dao.carregarTodosContato();
		request.setAttribute("lista_contatos", contatos);
		forward("lista");
	}
}