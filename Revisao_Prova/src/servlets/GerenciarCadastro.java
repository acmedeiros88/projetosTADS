package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.Daogenerico;
import entity.Contato;

/**
 * Servlet implementation class GerenciarCadastro
 */
@WebServlet("/GerenciarCadastro")
public class GerenciarCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerenciarCadastro() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String cpf = request.getParameter("cpf");
		String telefone = request.getParameter("telefone");
		String acao = request.getParameter("acao");
		String destino = null;
		String mensagem = null;
		Daogenerico daog = new Daogenerico();

		if (acao.equals("Enviar")) {
			if (nome.isEmpty() && cpf.isEmpty()) {
				mensagem = "Campos obrigatorios nao preenchidos";
			} else {
				Contato contato = new Contato(nome, cpf, telefone);
				daog.salvarContato(contato);
				destino = "cadastro.jsp";
			}
		}
		if (acao.equals("Remover")) {
			int id = Integer.parseInt(request.getParameter("id"));
			daog.remover(id);
			destino = "cadastro.jsp";
		}
		if (acao.equals("Atualizar")) {
			Contato update = new Contato();
			update = daog.carregarContato(Integer.parseInt(request.getParameter("id")));
			update.setNome(request.getParameter("nome"));
			update.setCpf(request.getParameter("cpf"));
			update.setTel(request.getParameter("telefone"));
			daog.atualizar(update);
			destino = "cadastro.jsp";
		}
		if (acao.equals("Sair")) {
			HttpSession session = request.getSession();
			session.invalidate();
			destino="index.jsp";
		}
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("listaContato", daog.getBuscarTodos());
		request.getRequestDispatcher(destino).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
