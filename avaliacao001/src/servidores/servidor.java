package servidores;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/servidor")
public class servidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public servidor() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected static boolean validaLogin(String nome, String senha) {
		String admin = "admin";
		String senhaAdmin = "admin123";
		if (admin.equals(nome) && senhaAdmin.equals(senha)) {
			return true;
		}
		return false;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");

		if (validaLogin(nome, senha)) {
			request.getRequestDispatcher("logado.jsp").forward(request, response);
		} else {

			request.getRequestDispatcher("index.html").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
