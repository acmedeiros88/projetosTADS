package servidor;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gerenciador.GerenciaSessao;
import object.Usuario;

/**
 * Servlet implementation class GerenciaUsuario
 */
@WebServlet("/GerenciaUsuario")
public class GerenciaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GerenciaSessao sessao=new GerenciaSessao();
		
		String usuario = request.getParameter("usuario");
		String nome = request.getParameter("nome");
		String senha = request.getParameter("senha");
		
		Usuario u = new Usuario(nome,usuario,senha);
		sessao.adicionarUsuario(u);
		request.setAttribute("cadastrado", "Usuario cadastrado com sucesso!");
		request.getRequestDispatcher("logado.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
