package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.UsuarioBean;
import dao.UsuarioDao;

/**
 * Servlet implementation class GerenciarUsuario
 */
@WebServlet("/GerenciarUsuario")
public class GerenciarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GerenciarUsuario() {
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
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String mensagem = null;
		UsuarioDao dao = new UsuarioDao();

		if (!nome.isEmpty() && !login.isEmpty() && !senha.isEmpty()) {
			UsuarioBean usuario = new UsuarioBean(nome, login, senha);
			dao.cadastrar(usuario);
			mensagem = "Usuario cadastrado com sucesso";
		} else {
			mensagem = "Falta campos a ser preenchido";
		}

		request.setAttribute("mensagem", mensagem);
		request.getRequestDispatcher("cadastrarUsuario.jsp").forward(request, response);
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
