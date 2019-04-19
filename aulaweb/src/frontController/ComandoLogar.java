package frontController;

import java.io.IOException;

import javax.servlet.ServletException;

public class ComandoLogar extends FrontComando{

	@Override
	public void process() throws ServletException, IOException {
		if(this.request.getParameter("login").
				equals(this.request.getParameter("password"))){
			forward("lista");
		}else {
			forward("index");
		}
			
		
	}

}
