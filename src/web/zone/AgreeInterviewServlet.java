package web.zone;

import java.io.IOException;
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
 * Servlet implementation class AgreeInterviewServlet
 */
@WebServlet("/AgreeInterviewServlet")
public class AgreeInterviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String INTERVIEWDETAIL = "/WEB-INF/jsp/student/interviewDetail.jsp";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		HttpRequest httpRequest = new HttpRequest();
		String interviewId = request.getParameter("interviewId");
		JobInterview jobInterview = httpRequest.getInterviewById(Integer.parseInt(interviewId));
		jobInterview.setStatus(2);
		httpRequest.updateInterview(jobInterview);
		
		session.setAttribute("jobInterview", jobInterview);
		request.getRequestDispatcher(INTERVIEWDETAIL).forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
