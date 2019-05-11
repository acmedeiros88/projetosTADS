package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.UsuarioDao;
import entity.Endereco;
import entity.Usuario;

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
		String cpf = request.getParameter("cpf");
		String senha = request.getParameter("senha");
		String rua = request.getParameter("rua");
		String numero = request.getParameter("numero");
		String complemento = request.getParameter("complemento");
		String destino = null;
		String mensagem=null;
		UsuarioDao dao = new UsuarioDao();
		
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setNumero(Integer.parseInt(numero));
		endereco.setComplemento(complemento);
		Usuario usuario = new Usuario(cpf,senha,nome,endereco);
		
		
		dao.salvar(usuario);
		mensagem="Usuario cadastrado com sucesso!";
		destino = "index.jsp";
		
		//request.setAttribute("listaContato", dao.getListaUsuario());
		request.setAttribute("mensagem", mensagem);
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
