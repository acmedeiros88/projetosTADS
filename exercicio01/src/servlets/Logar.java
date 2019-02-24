package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;

/**
 * Servlet implementation class Logar
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public Logar() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login = request.getParameter("login");
		String senha = request.getParameter("senha");
		String mensagem = null;
		String destino = null;
		UsuarioDao usuarioDao = new UsuarioDao();

		if (!login.isEmpty() && !senha.isEmpty()) {
			if (login == "admin" && senha == "admin") {
				destino = "cadastrarUsuario.jsp";
			} else {
				if (usuarioDao.validarLogin(login, senha)) {
					destino = "cadastrarUsuario.jsp";
				} else {
					mensagem = "Usuario/Senha invalido";
					destino="index.html";
				}
			}

			request.setAttribute("mensagem", mensagem);
			request.getRequestDispatcher(destino).forward(request, response);
		}
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
