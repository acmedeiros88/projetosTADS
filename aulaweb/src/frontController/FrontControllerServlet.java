package frontController;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontContellerServlet
 */
@WebServlet("/FrontControllerServlet")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		FrontComando command = getCommand(request);
		command.init(getServletContext(), request, response);
		command.process();
	}
	
	private FrontComando getCommand(HttpServletRequest request) {
		try {
			
			Class type = Class
					.forName(String.format("frontController.Comando%s", request.getParameter("comando")));
			return (FrontComando) type.asSubclass(FrontComando.class).newInstance();
		} catch (Exception e) {
			return new ComandoDesconhecido();
		}
	}

}
