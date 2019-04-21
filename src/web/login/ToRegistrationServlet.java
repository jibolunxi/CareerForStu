package web.login;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ToRegistrationServlet
 */
@WebServlet("/ToRegistrationServlet")
public class ToRegistrationServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private static final String REGIST = "/WEB-INF/jsp/student/regist.jsp";
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher(REGIST).forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
