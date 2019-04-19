package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import dao.GenericDao;
import entity.Contato;

public class ComandoRemover extends FrontComando {

	@Override
	public void process() throws ServletException, IOException {
		GenericDao dao = new GenericDao();
		dao.deletar(Integer.parseInt(request.getParameter("id")));
		List<Contato> contatos = dao.carregarTodosContato();
		request.setAttribute("lista_contatos", contatos);
		forward("lista");
	}

}
