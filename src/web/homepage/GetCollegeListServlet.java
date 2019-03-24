package web.homepage;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.College;
import utils.HttpRequest;

@WebServlet("/GetCollegeListServlet")
public class GetCollegeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String COLLEGELIST = "/WEB-INF/jsp/student/collegeList.jsp";
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		if (session.getAttribute("colleges")==null) {
			List<College> colleges = httpRequest.getCollegeList();
			session.setAttribute("colleges", colleges);
		}
		request.getRequestDispatcher(COLLEGELIST).forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
