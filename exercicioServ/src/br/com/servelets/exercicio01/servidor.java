package br.com.servelets.exercicio01;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servidor
 */
@WebServlet("/servidor")
public class servidor extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public servidor() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//PrintWriter out = response.getWriter();
		
		String nome =request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto=request.getParameter("dataNascimento");
		
		if(nome.equals("adriano")){
			nome=request.getParameter("nome")+"cardoso medeiros";
		}else{
			nome=request.getParameter("nome")+"não é o CARDOSO";
		}
		
		request.setAttribute("nome",nome);
		request.setAttribute("endereco",endereco);
		request.setAttribute("email", email);
		request.setAttribute("dataNascimento", dataEmTexto);

		//Para enviar a para o recurso do JSP(apresentar.jsp)
		request.getRequestDispatcher("apresentar.jsp").forward(request, response);

			/*out.println("<html>");
			out.println("<body>");
			out.println("Contato: "+nome);
			out.println("<br>");
			out.println("Endereço: "+endereco);
			out.println("<br>");
			out.println("Email: "+email);
			out.println("<br>");
			out.println("Data de Nascimento: "+dataEmTexto);
			out.println("</body>");
			out.println("</html>");*/
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
