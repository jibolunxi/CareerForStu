package web.zone;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Admin;
import domain.JobInterview;
import utils.HttpRequest;

/**
 * Servlet implementation class RefuseInterviewServlet
 */
@WebServlet("/RefuseInterviewServlet")
public class RefuseInterviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INTERVIEWMESSAGE = "/WEB-INF/jsp/student/interviewMessage.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		Admin admin = (Admin) session.getAttribute("admin");
		String interviewId = request.getParameter("interviewId");
		
		httpRequest.deleteInterview(Integer.parseInt(interviewId));
		List<JobInterview> jobInterviewList = httpRequest.getInterviewList(admin.getId());
		session.setAttribute("jobInterviewList", jobInterviewList);
		request.getRequestDispatcher(INTERVIEWMESSAGE).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
