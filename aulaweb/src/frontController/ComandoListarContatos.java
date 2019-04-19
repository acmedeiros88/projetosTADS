package frontController;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import dao.GenericDao;
import entity.Contato;

/**
 * Servlet implementation class ListarContatos
 */
public class ComandoListarContatos extends FrontComando {
	
	public void process() throws ServletException, IOException {
		GenericDao dao = new GenericDao();
		List<Contato> contatos = dao.carregarTodosContato();
		request.setAttribute("lista_contatos", contatos);
		forward("lista");
	}

}
