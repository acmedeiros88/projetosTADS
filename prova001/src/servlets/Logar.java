package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDao;
import entity.Usuario;

/**
 * Servlet implementation class Logar
 */
@WebServlet("/Logar")
public class Logar extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Logar() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		UsuarioDao dao = new UsuarioDao();
		String destino = null;
		String mensagem = null;
		Usuario usuario = new Usuario();
		usuario = dao.buscarPorCpf(cpf);
		
		if(!(usuario==null)) {	
			if (usuario.getCpf().equalsIgnoreCase(cpf) && usuario.getSenha().equalsIgnoreCase(senha)) {
				destino = "cadastroFilme.jsp";
			} else{
				destino = "index.jsp";
				mensagem = "Usuario e/ou senha não cadastrado";
			}
		}else {
			destino = "index.jsp";
			mensagem = "Usuario e/ou senha invalidos";
		}
		request.setAttribute("mensagem", mensagem);
		request.setAttribute("usuariSessao", request.getAttribute("usuarioSessao"));
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
