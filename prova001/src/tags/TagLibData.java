package tags;

import java.io.IOException;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class TagLibData extends SimpleTagSupport {

	public void doTag() throws JspException, IOException {
		getJspContext().getOut().println(new Date());
	}

}
