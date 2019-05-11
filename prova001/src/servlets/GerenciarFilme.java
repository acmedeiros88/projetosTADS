package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.FilmeDao;
import entity.Filme;

/**
 * Servlet implementation class GerenciarFilme
 */
@WebServlet("/GerenciarFilme")
public class GerenciarFilme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HttpSession session;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GerenciarFilme() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nomeFilme = request.getParameter("nomeFilme");
		String anoFilme = request.getParameter("anoFilme");
		String mensagem = null;
		String destino = null;
		FilmeDao dao = new FilmeDao();
		String sessao = (String) request.getAttribute("usuarioSessao");
		
		if (nomeFilme.isEmpty() && anoFilme.isEmpty()) {
			mensagem = "Campos obrigatorios nao preenchidos";
			destino = "cadastroFilme.jsp";
		} else {
			Filme filme = new Filme(nomeFilme,anoFilme,sessao);
			dao.salvar(filme);
			mensagem="Filme Cadastrado com Sucesso!";
			destino = "cadastroFilme.jsp";
		}
		//request.setAttribute("listaContato", dao.getListaUsuario());
		request.setAttribute("mensagem", mensagem);
		request.getRequestDispatcher(destino).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
